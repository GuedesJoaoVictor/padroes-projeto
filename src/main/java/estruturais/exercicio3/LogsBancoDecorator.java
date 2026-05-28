package estruturais.exercicio3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LogsBancoDecorator implements BancoService {

    private final BancoService bancoService;
    public static final String LOGS_PATH = "logsBanco.txt";


    public LogsBancoDecorator(BancoService bancoService) {
        this.bancoService = bancoService;

        Path path = Paths.get("logsBanco.txt");
        if (!Files.exists(path)) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("logsBanco.txt"));
                writer.write("LOGS DO BANCO");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void escreverLog(String log) {
        Utils.escreverLog(log, LOGS_PATH);
    }

    @Override
    public ContaBancaria criaContaBancaria(String cpf, Double saldo, ContaBancaria.TipoContaBancaria tipoContaBancaria, boolean especial, Double limite) {
        ContaBancaria contaBancaria = this.bancoService.criaContaBancaria(cpf, saldo, tipoContaBancaria, especial, limite);
        escreverLog("Criando conta bancaria com o número " + contaBancaria.getNumero());

        return contaBancaria;
    }

    @Override
    public ContaBancaria excluiContaBancaria(Long numero) throws BancoException {
        ContaBancaria conta = bancoService.excluiContaBancaria(numero);
        escreverLog("Conta com o numero " + numero + " excluido com sucesso");

        return conta;
    }

    @Override
    public void deposito(Long numeroConta, Double valorDeposito) throws BancoException {
        bancoService.deposito(numeroConta, valorDeposito);
        escreverLog("Tentando deposito na " + numeroConta + " depositado " + valorDeposito);
    }

    @Override
    public void saque(Long numeroConta, Double valorSaque) throws BancoException {
        bancoService.saque(numeroConta, valorSaque);
        escreverLog("Tentando saque " + numeroConta + " valor do saque " + valorSaque);
    }

    @Override
    public Double getSaldo(Long numeroConta) throws BancoException {
        Double saldo = bancoService.getSaldo(numeroConta);
        escreverLog("Saldo atual: " + saldo);

        return saldo;
    }

    @Override
    public String extrato(Long numeroConta) throws BancoException {
        String extrato = bancoService.extrato(numeroConta);
        escreverLog("Extrato: " + extrato);

        return extrato;
    }

    @Override
    public void transferir(Long numeroContaOrigem, Long numeroContaDestino, Double valorTransferencia) throws BancoException {
        bancoService.transferir(numeroContaOrigem, numeroContaDestino, valorTransferencia);
        escreverLog("Tentando transferir " + valorTransferencia + " da conta " + numeroContaOrigem + " destino "
                + numeroContaDestino);
    }

    @Override
    public void calculaRendimentos(double jurosPoupanca, double jurosRendaFixa, double jurosRendaVariavel) throws BancoException {
        bancoService.calculaRendimentos(jurosPoupanca, jurosRendaFixa, jurosRendaVariavel);
        escreverLog("Calculando rendimentos.");
    }
}
