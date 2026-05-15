package br.ufsm.poli.csi.pp.intro.exercicio2gue10;

import lombok.Data;

@Data
public abstract class Conta {
    private Long numero;
    private Double saldo;
    private boolean especial;

    public enum TipoConta { POUPANCA, CONTA_CORRENTE, FUNDOS_RENDA_FIXA, FUNDOS_RENDA_VARIAVEL }

}
