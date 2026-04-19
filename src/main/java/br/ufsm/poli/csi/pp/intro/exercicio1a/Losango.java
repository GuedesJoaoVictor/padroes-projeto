package br.ufsm.poli.csi.pp.intro.exercicio1a;

import lombok.Data;

@Data
public class Losango extends ModelFormaGeometrica {

    private double diagonalMaior;
    private double diagonalMenor;

    @Override
    public double calcularArea() {
        return diagonalMaior * diagonalMenor / 2.0;
    }
}
