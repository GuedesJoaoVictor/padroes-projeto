package br.ufsm.poli.csi.pp.intro.exercicio1gue10;

import br.ufsm.poli.csi.pp.intro.exercicio1.FormaGeometrica;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Comodo implements FormasGeometricas, Volume {

    private String identificacao;
    private double peDireito;
    private Collection<FormaGeometrica> formaGeometricas;

    @Override
    public double calcularArea() {
        double areaTotal = 0.0;
        for (FormaGeometrica forma : formaGeometricas) {
            areaTotal += forma.calcularArea();
        }
        return areaTotal;
    }

    @Override
    public double calcularVolume() {
        return calcularArea() * peDireito;
    }

}
