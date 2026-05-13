package br.ufsm.poli.csi.pp.intro.exercicio1gue10;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Quadrado implements FormasGeometricas {

    private Double lado;

    @Override
    public double calcularArea() {
        return lado * lado;
    }
}
