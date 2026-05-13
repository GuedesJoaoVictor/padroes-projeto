package br.ufsm.poli.csi.pp.intro.exercicio1gue10;

public class Losango implements FormasGeometricas {

    private Double diagonalMaior;
    private Double diagonalMenor;

    @Override
    public double calcularArea() {
        return diagonalMaior * diagonalMenor / 2.0;
    }
}
