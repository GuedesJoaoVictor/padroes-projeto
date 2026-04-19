package br.ufsm.poli.csi.pp.intro.exercicio1a;

import lombok.Data;

import java.util.Collection;

@Data
public class Comodo implements FormaGeometrica, Volume {

    private String identificacao;
    private double peDireito;
    private Collection<FormaGeometrica>  formasGeometricas;

    @Override
    public double calcularArea() {
        double areaTotal = 0.0;
        for (FormaGeometrica forma : formasGeometricas) {
            areaTotal += forma.calcularArea();
        }
        return areaTotal;
    }

    @Override
    public double calcularVolume() {
        return calcularArea() * peDireito;
    }

}
