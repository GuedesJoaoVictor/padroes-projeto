package br.ufsm.poli.csi.pp.criacao.exercicio2c;

public interface Pool<K> {

    K acquire();
    void release(K t);
}
