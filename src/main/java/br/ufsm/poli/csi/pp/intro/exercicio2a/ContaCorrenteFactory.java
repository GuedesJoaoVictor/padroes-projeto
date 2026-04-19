package br.ufsm.poli.csi.pp.intro.exercicio2a;

public class ContaCorrenteFactory implements ContaBancariaFactory {

    @Override
    public ContaBancaria criar(String cpf, Double saldo, boolean especial, Double limite) {
        ContaCorrente conta = ContaCorrente.builder()
                .especial(especial)
                .limiteChequeEspecial(limite)
                .build();
        conta.setCpf(cpf);
        conta.setSaldo(saldo);
        return conta;
    }

}
