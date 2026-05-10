package br.ufsm.poli.csi.pp.criacao.exercicioe;

public class RestauranteNormal {

    private Builder builder;

    public RestauranteNormal(Builder builder) {
        this.builder = builder;
    }

    public Lanche preparaCalabreza() {
        builder.preparaMassa();
        builder.colocaMolhoTomate();
        builder.colocaQueijoMucarela();
        builder.colocaCalabreza();
        builder.assa();
        return builder.build();
    }

    public Lanche preparaQuatroQueijos() {
        builder.preparaMassa();
        builder.colocaMolhoTomate();
        builder.colocaQueijoMucarela();
        builder.colocaQueijoProvolone();
        builder.colocaQueijoCatupiry();
        builder.colocaQueijoCheddar();
        builder.assa();
        return builder.build();
    }

    public Lanche preparaFrangoCatupiry() {
        builder.preparaMassa();
        builder.colocaMolhoTomate();
        builder.colocaQueijoMucarela();
        builder.colocaFrango();
        builder.colocaQueijoCatupiry();
        builder.assa();
        return builder.build();
    }

}
