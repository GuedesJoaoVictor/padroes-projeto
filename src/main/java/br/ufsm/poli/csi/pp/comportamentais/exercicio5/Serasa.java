package br.ufsm.poli.csi.pp.comportamentais.exercicio5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Serasa implements Observer{

    private final Set<String> listaNegativados = new HashSet<>();

    @Override
    public void update(Observable o) {
        ContaBancaria contaBancaria = (ContaBancaria) o;

        if (contaBancaria.getSaldo() < 0) {
            synchronized (listaNegativados) {
                listaNegativados.add(contaBancaria.getCpf());
            }
        }
    }
}
