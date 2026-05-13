package br.ufsm.poli.csi.pp.intro.exercicio1gue10;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SemiCirculo implements FormasGeometricas {

    private Double raio;
    private Double graus;

    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(raio, 2.0) * (graus / 360);
    }
}
