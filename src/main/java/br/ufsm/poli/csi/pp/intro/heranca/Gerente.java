package br.ufsm.poli.csi.pp.intro.heranca;

public class Gerente extends Funcionario {

    private String senha;
    private int numFuncionariosGerenciados;

    @Override
    public double getBonificacao() {
        return getSalario() * 0.15;
    }


}
