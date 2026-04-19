package br.ufsm.poli.csi.pp.intro.exercicio1a;

import lombok.Data;

import java.util.Collection;

@Data
public class Imovel implements FormaGeometrica, Volume {

    private Collection<Comodo> comodos;
    private String identificacao;
    private String proprietario;
    private String endereco;
    private TipoUso tipoUso;

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


    public enum TipoUso {
        RESIDENCIAL(1), COMERCIAL(2), INDUSTRIAL(3), PUBLICO(4);
        private int codigo;

        public int getCodigo() {
            return codigo;
        }

        TipoUso(int codigo) {
            this.codigo = codigo;
        }


    }

}
