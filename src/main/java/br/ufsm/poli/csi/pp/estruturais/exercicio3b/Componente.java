package br.ufsm.poli.csi.pp.estruturais.exercicio3b;

import java.util.Collection;

public interface Componente {

    Collection<Componente> getComponentes();
    Double getValor();

}
