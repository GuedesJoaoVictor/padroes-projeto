package br.ufsm.poli.csi.pp.intro.exercicio1gue10;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Retangulo implements FormasGeometricas {

    private Double base;
    private Double altura;

    @Override
    public double calcularArea() {
        return base * altura;
    }
}
