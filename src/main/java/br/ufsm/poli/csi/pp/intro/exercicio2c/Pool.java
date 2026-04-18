package br.ufsm.poli.csi.pp.intro.exercicio2c;

public interface Pool<T> {

    T acquire();
    void release(T t);
}
