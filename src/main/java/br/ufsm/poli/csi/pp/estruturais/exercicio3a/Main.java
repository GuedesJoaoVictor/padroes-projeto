package br.ufsm.poli.csi.pp.estruturais.exercicio3a;

import lombok.SneakyThrows;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        Banco banco = new Banco();
        LogsBancoDecorator logsBancoDecorator = new LogsBancoDecorator(banco);

        logsBancoDecorator.criaContaBancaria("05265295046", 50.00,
                ContaBancaria.TipoContaBancaria.CONTA_CORRENTE, true, 4500.00);
        logsBancoDecorator.criaContaBancaria("00000000000", 50.00,
                ContaBancaria.TipoContaBancaria.CONTA_CORRENTE, true, 4500.00);
        logsBancoDecorator.criaContaBancaria("00000000001", 50.00,
                ContaBancaria.TipoContaBancaria.CONTA_CORRENTE, true, 4500.00);

        logsBancoDecorator.getSaldo(1L);
        logsBancoDecorator.getSaldo(2L);
        logsBancoDecorator.transferir(1L, 2L, 50.00);
        logsBancoDecorator.getSaldo(1L);
        logsBancoDecorator.getSaldo(2L);
    }
}
