package br.ufsm.poli.csi.pp.comportamentais.exercicio5;

import br.ufsm.poli.csi.pp.estruturais.exercicio3a.Movimentacao;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Collection;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class ContaBancaria implements Observable {

    private String cpf;
    private Double saldo;
    @EqualsAndHashCode.Include
    private Long numero;
    private Collection<Observer> observers = new ArrayList<>();
    private Collection<Movimentacao> movimentacoes = new ArrayList<>();

    public enum TipoContaBancaria { CONTA_CORRENTE, POUPANCA, RENDA_FIXA, RENDA_VARIAVEL }

    public abstract Double getIRPFDevido();

    @Override
    public void subscribe(Observer o) {
        observers.add(o);
    }

    @Override
    public void unsubscribe(Observer o) {
        observers.remove(o);
    }
}
