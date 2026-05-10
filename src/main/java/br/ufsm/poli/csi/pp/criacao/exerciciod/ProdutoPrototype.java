package br.ufsm.poli.csi.pp.criacao.exerciciod;

public interface ProdutoPrototype extends Cloneable {

    Produto clone() throws CloneNotSupportedException;

}
