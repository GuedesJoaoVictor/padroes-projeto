package br.ufsm.poli.csi.pp.criacao.exercicioe;

public class BuilderPastel implements Builder {

    private Pastel pastel;
    private boolean cru = true;

    @Override
    public void preparaMassa() {
        this.pastel = new Pastel();
        System.out.println("Preparando massa...");
    }

    @Override
    public void colocaMolhoTomate() {
        System.out.println("Colocando molho tomate...");
    }

    @Override
    public void colocaQueijoMucarela() {
        System.out.println("Colocando queijo mucarela...");
    }

    @Override
    public void colocaQueijoCatupiry() {
        System.out.println("Colocando queijo catupiry...");
    }

    @Override
    public void colocaQueijoProvolone() {
        System.out.println("Colocando queijo provolone...");
    }

    @Override
    public void colocaQueijoCheddar() {
        System.out.println("Colocando queijo cheddar...");
    }

    @Override
    public void colocaQueijoGorgonzola() {
        System.out.println("Colocando queijo gorgonzola...");
    }

    @Override
    public void colocaCalabreza() {
        System.out.println("Colocando calabreza...");
    }

    @Override
    public void colocaCebola() {
        System.out.println("Colocando cebola...");
    }

    @Override
    public void colocaTomate() {
        System.out.println("Colocando tomate...");
    }

    @Override
    public void colocaFrango() {
        System.out.println("Colocando frango...");
    }

    @Override
    public void colocaCoracao() {
        System.out.println("Colocando coracao...");
    }

    @Override
    public void colocaFile() {
        System.out.println("Colocando file...");
    }

    @Override
    public void colocaAzeitona() {
        System.out.println("Colocando azeitona...");
    }

    @Override
    public void colocaAbacaxi() {
        System.out.println("Colocando abacaxi...");
    }

    @Override
    public void colocaManjericao() {
        System.out.println("Colocando manjericao...");
    }

    @Override
    public void colocaCamarao() {
        System.out.println("Colocando camarao...");
    }

    @Override
    public void adicionaBacon() {
        System.out.println("Adicionando bacon...");
    }

    @Override
    public void assa() {
        if (pastel == null) {
            throw new IllegalArgumentException("não foi preparada a massa");
        }
        System.out.println("Assando forno...");
        this.cru = false;
    }

    @Override
    public void frita() {
        if (pastel == null) {
            throw new IllegalArgumentException("não foi preparada a massa");
        }
        System.out.println("Fritando...");
        this.cru = false;
    }

    public Pastel build() {
        if (pastel == null) {
            throw new IllegalArgumentException("não foi preparada a massa");
        }
        if (this.cru) {
            throw new IllegalArgumentException("pastel esta cru");
        }
        //esta tudo ok, entregando
        Pastel pronto = pastel;
        this.pastel = null;
        this.cru = true;
        return pronto;
    }

}
