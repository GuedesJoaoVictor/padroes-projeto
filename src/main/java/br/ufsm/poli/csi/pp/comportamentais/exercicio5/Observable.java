package br.ufsm.poli.csi.pp.comportamentais.exercicio5;

public interface Observable {
    void subscribe(Observer o);
    void unsubscribe(Observer o);
}
