package br.ufsm.poli.csi.pp.intro.exercicio1a;

import lombok.Data;

@Data
public class SemiCirculo implements FormaGeometrica {

    private double raio;
    private double graus;

    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(raio, 2.0) * (graus / 360);
    }
}
