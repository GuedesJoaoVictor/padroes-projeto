package br.ufsm.poli.csi.pp.estruturais.exercicio3c;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BancoAntigoAdapter implements BancoAntigo {

    private Banco banco;

    @Override
    public boolean removerConta(String codigo) {
        try {
            this.banco.excluiContaBancaria(Long.valueOf(codigo));
            return true;
        } catch (BancoException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void movimentar(String codigo, double valor) {
        try {
            this.banco.deposito(Long.valueOf(codigo), valor);
        } catch (BancoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public double verificarSaldo(String codigo) {
        try {
            return this.banco.getSaldo(Long.valueOf(codigo));
        } catch (BancoException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public String imprimirExtrato(String codigo) {
        try {
            return this.banco.extrato(Long.valueOf(codigo));
        } catch (BancoException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public void transfereEntreContas(String origem, String destino, double valor) {
        try {
            this.banco.transferir(Long.valueOf(origem), Long.valueOf(destino), valor);
        } catch (BancoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ContaBancaria novaConta(String cpf, String tipo, double saldoInicial, boolean vip, double limite) {
        ContaBancaria.TipoContaBancaria tipoConta = ContaBancaria.TipoContaBancaria.valueOf(tipo);
        return this.banco.criaContaBancaria(cpf, saldoInicial, tipoConta, vip, limite);
    }
}
