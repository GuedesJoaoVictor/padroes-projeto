package br.ufsm.poli.csi.pp.intro.exercicio1a;

import lombok.Data;

@Data
public class Retangulo implements FormaGeometrica {

    private double lado1;
    private double lado2;

    @Override
    public double calcularArea() {
        return lado1 * lado2;
    }
}
