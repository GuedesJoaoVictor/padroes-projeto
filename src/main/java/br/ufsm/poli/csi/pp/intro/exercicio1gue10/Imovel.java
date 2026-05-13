package br.ufsm.poli.csi.pp.intro.exercicio1gue10;

import java.util.Collection;

public class Imovel implements FormasGeometricas, Volume {

    private Collection<Comodo> comodos;
    private String identificacao;
    private String proprietario;
    private TipoUso tipoUso;

    public enum TipoUso {
        RESIDENCIAL(1), COMERCIAL(2), INDUSTRIAL(3), PUBLICO(4);
        private int codigo;

        TipoUso(int codigo) {
            this.codigo = codigo;
        }

        public int getCodigo() {
            return codigo;
        }

    }

    @Override
    public double calcularArea() {
        double areaTotal = 0;
        for (Comodo comodo : comodos) {
            areaTotal += comodo.calcularArea();
        }
        return areaTotal;
    }

    @Override
    public double calcularVolume() {
        double volumeTotal = 0;
        for (Comodo comodo : comodos) {
            volumeTotal += comodo.calcularVolume();
        }
        return volumeTotal;
    }

}
