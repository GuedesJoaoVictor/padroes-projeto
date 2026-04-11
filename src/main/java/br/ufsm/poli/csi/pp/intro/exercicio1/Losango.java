package br.ufsm.poli.csi.pp.intro.exercicio1;

import lombok.Data;

@Data
public class Losango implements FormaGeometrica {

    private double diagonalMaior;
    private double diagonalMenor;

    @Override
    public double calcularArea() {
        return diagonalMaior * diagonalMenor / 2.0;
    }
}
