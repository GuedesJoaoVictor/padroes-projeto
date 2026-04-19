package br.ufsm.poli.csi.pp.intro.exercicio2a;

public class PoupancaFactory implements ContaBancariaFactory {

    @Override
    public ContaBancaria criar(String cpf, Double saldo, boolean especial, Double limite) {
        Poupanca poupanca = new Poupanca();
        poupanca.setCpf(cpf);
        poupanca.setSaldo(saldo);
        return poupanca;
    }
}
