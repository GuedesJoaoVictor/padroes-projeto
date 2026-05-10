package br.ufsm.poli.csi.pp.criacao.exercicioe;

public class RestauranteGourmet {

    private Builder builder;

    public RestauranteGourmet(Builder builder) {
        this.builder = builder;
    }

    public Lanche peparaSaborcamarao() {
        builder.preparaMassa();
        builder.colocaMolhoTomate();
        builder.colocaQueijoMucarela();
        builder.colocaCamarao();
        builder.assa();
        return builder.build();
    }

    public Lanche preparaMarguerita() {
        builder.preparaMassa();
        builder.colocaMolhoTomate();
        builder.colocaQueijoMucarela();
        builder.colocaManjericao();
        builder.assa();
        return builder.build();
    }

    public Lanche preparaFileQuatroQueijos() {
        builder.preparaMassa();
        builder.colocaMolhoTomate();
        builder.colocaQueijoMucarela();
        builder.colocaFile();
        builder.colocaQueijoGorgonzola();
        builder.colocaQueijoCatupiry();
        builder.colocaQueijoProvolone();
        builder.assa();
        return builder.build();
    }

}
