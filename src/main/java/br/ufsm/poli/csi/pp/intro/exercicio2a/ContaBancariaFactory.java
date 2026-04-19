package br.ufsm.poli.csi.pp.intro.exercicio2a;

public interface ContaBancariaFactory {

    ContaBancaria criar(String cpf, Double saldo, boolean especial, Double limite);

}
