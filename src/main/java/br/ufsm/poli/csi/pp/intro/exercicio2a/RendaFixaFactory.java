package br.ufsm.poli.csi.pp.intro.exercicio2a;

public class RendaFixaFactory implements ContaBancariaFactory {

    @Override
    public ContaBancaria criar(String cpf, Double saldo, boolean especial, Double limite) {
        FundosRenda conta = new FundosRenda(ContaBancaria.TipoContaBancaria.RENDA_FIXA);
        conta.setCpf(cpf);
        conta.setSaldo(saldo);
        return conta;
    }
}
