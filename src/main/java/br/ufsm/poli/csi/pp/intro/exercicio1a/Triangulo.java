package br.ufsm.poli.csi.pp.intro.exercicio1a;

import lombok.Data;

@Data
public class Triangulo implements FormaGeometrica {

    private double base;
    private double altura;

    @Override
    public double calcularArea() {
        return base * altura / 2;
    }
}
