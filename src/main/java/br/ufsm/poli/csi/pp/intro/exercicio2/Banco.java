package br.ufsm.poli.csi.pp.intro.exercicio2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Banco {

    private Map<Long, ContaBancaria> contasBancarias = new ConcurrentHashMap<Long, ContaBancaria>();
    private Long NUMERO = 1L;

    public ContaBancaria criaContaBancaria(String cpf,
                                           Double saldo,
                                           ContaBancaria.TipoContaBancaria tipoContaBancaria,
                                           boolean especial,
                                           Double limite) {
        if (tipoContaBancaria == ContaBancaria.TipoContaBancaria.CONTA_CORRENTE) {
            ContaCorrente contaCorrente = ContaCorrente.builder().especial(especial).limiteChequeEspecial(limite).build();
            contaCorrente.setCpf(cpf);
            contaCorrente.setSaldo(saldo);
            contaCorrente.setNumero(generateNumConta());
            contasBancarias.put(contaCorrente.getNumero(), contaCorrente);
            return contaCorrente;
        } else if (tipoContaBancaria == ContaBancaria.TipoContaBancaria.POUPANCA) {
            Poupanca poupanca = new Poupanca();
            poupanca.setNumero(generateNumConta());
            poupanca.setSaldo(saldo);
            poupanca.setCpf(cpf);
            contasBancarias.put(poupanca.getNumero(), poupanca);
            return poupanca;
        } else {
            FundosRenda fundosRenda = new FundosRenda(tipoContaBancaria);
            fundosRenda.setSaldo(saldo);
            fundosRenda.setNumero(generateNumConta());
            fundosRenda.setCpf(cpf);
            return fundosRenda;
        }
    }

    public ContaBancaria excluiContaBancaria(Long numero) throws BancoException {
        synchronized (numero) {
            ContaBancaria contaBancaria = contasBancarias.remove(numero);
            if (contaBancaria == null) {
                throw new BancoException("conta inexistente");
            }
            return contaBancaria;
        }
    }

    public void saque(Long numeroConta, Double valorSaque) throws BancoException {
        synchronized (numeroConta) {
            ContaBancaria contaBancaria = contasBancarias.get(numeroConta);
            if (contaBancaria == null) {
                throw new BancoException("conta inexistente");
            }
            Double limite = 0.0;
            if (contaBancaria instanceof ContaCorrente && ((ContaCorrente) contaBancaria).isEspecial()) {
                limite = ((ContaCorrente) contaBancaria).getLimiteChequeEspecial();
            }
            if (valorSaque > (contaBancaria.getSaldo() + limite)) {
                throw new IllegalArgumentException("saldo insuficiente");
            }
            contaBancaria.setSaldo(contaBancaria.getSaldo() - valorSaque);
            contaBancaria.getMovimentacoes().add(
                    new Movimentacao("saque no banco",
                            valorSaque,
                            Movimentacao.TipoMovimentacao.DEBITO)
            );
        }
    }

    public void deposito(Long numeroConta, Double valorDeposito) throws BancoException {
        synchronized (numeroConta) {
            ContaBancaria contaBancaria = contasBancarias.get(numeroConta);
            if (contaBancaria == null) {
                throw new BancoException("conta inexistente");
            }
            contaBancaria.getMovimentacoes().add(new Movimentacao(
                    "deposito no banco",
                    valorDeposito,
                    Movimentacao.TipoMovimentacao.CREDITO
            ));
            contaBancaria.setSaldo(contaBancaria.getSaldo() + valorDeposito);
        }
    }

    public Double getSaldo(Long numeroConta) throws BancoException {
        synchronized (numeroConta) {
            ContaBancaria contaBancaria = contasBancarias.get(numeroConta);
            if (contaBancaria == null) {
                throw new BancoException("conta inexistente");
            }
            return contaBancaria.getSaldo();
        }
    }

    public String extrato(Long numeroConta) throws BancoException {
        synchronized (numeroConta) {
            ContaBancaria contaBancaria = contasBancarias.get(numeroConta);
            if (contaBancaria == null) {
                throw new BancoException("conta inexistente");
            }
            StringBuilder extrato = new StringBuilder();
            for (Movimentacao movimentacao : contaBancaria.getMovimentacoes()) {
                extrato.append(
                        movimentacao.getDescricao() + "\t" +
                                ((movimentacao.getTipoMovimentacao() == Movimentacao.TipoMovimentacao.DEBITO ? "-" : ""))
                                + movimentacao.getValor());
            }
            return extrato.toString();
        }
    }

    public void transferir(Long numeroContaOrigem,
                           Long numeroContaDestino,
                           Double valorTransferencia) throws BancoException
    {
        ContaBancaria contaOrigem = contasBancarias.get(numeroContaOrigem);
        if (contaOrigem == null) {
            throw new BancoException("conta de origem inexistente");
        }
        ContaBancaria contaDestino = contasBancarias.get(numeroContaDestino);
        if (contaDestino == null) {
            throw new BancoException("conta de destino inexistente");
        }
        saque(numeroContaOrigem, valorTransferencia);
        deposito(numeroContaOrigem, valorTransferencia);
    }


    private Long generateNumConta() {
        synchronized (this) {
            return NUMERO++;
        }
    }

    private void calculaRendimentos(double jurosPoupanca, double jurosRendaFixa, double jurosRendaVariavel) throws BancoException {
        for (ContaBancaria conta : contasBancarias.values()) {
            synchronized (conta.getNumero()) {
                if (conta instanceof Poupanca) {
                    double rendimento = conta.getSaldo() * (jurosPoupanca / 100);
                    conta.setSaldo(conta.getSaldo() + rendimento);
                    conta.getMovimentacoes().add(new Movimentacao("rendimento", rendimento, Movimentacao.TipoMovimentacao.RENDIMENTO_FINANCEIRO));
                } else if (conta instanceof FundosRenda) {
                    if (((FundosRenda) conta).getTipoContaBancaria() == ContaBancaria.TipoContaBancaria.RENDA_FIXA) {
                        double rendimento = conta.getSaldo() * (jurosRendaFixa / 100);
                        conta.setSaldo(conta.getSaldo() + rendimento);
                        conta.getMovimentacoes().add(new Movimentacao("rendimento", rendimento, Movimentacao.TipoMovimentacao.RENDIMENTO_FINANCEIRO));
                    } else {
                        double rendimento = conta.getSaldo() * (jurosRendaVariavel / 100);
                        conta.setSaldo(conta.getSaldo() + rendimento);
                        conta.getMovimentacoes().add(new Movimentacao("rendimento", rendimento, Movimentacao.TipoMovimentacao.RENDIMENTO_FINANCEIRO));
                    }
                }
            }
        }
    }

}
