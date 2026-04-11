package br.ufsm.poli.csi.pp.intro.exercicio2;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Collection;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class ContaBancaria {

    private String cpf;
    private Double saldo;
    @EqualsAndHashCode.Include
    private Long numero;
    private Collection<Movimentacao> movimentacoes = new ArrayList<>();

    public enum TipoContaBancaria { CONTA_CORRENTE, POUPANCA, RENDA_FIXA, RENDA_VARIAVEL }

    public abstract Double getIRPFDevido();

}
