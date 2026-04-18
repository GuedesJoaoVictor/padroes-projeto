package br.ufsm.poli.csi.pp.intro.exercicio2c;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class PoolGenerico<T> implements Pool<T> {

    private Class<T> clazz;
    private List<T> objetosDisponiveis = new ArrayList<>();
    private List<T> objetosCriados = new ArrayList<>();

    public PoolGenerico(Class<T> clazz) {
        this.clazz = clazz;
        for (int i = 0; i < 3; i++) {
            T o = criaInstancia();
            objetosCriados.add(o);
            objetosDisponiveis.add(o);
        }
    }

    @SneakyThrows
    private T criaInstancia() {
        return clazz.getDeclaredConstructor().newInstance();
    }

    @SneakyThrows
    @Override
    public T acquire() {
        synchronized (this) {
            if (objetosDisponiveis.isEmpty()) {
                if (objetosCriados.size() == 20) {
                    // deixa em stand by
                    System.out.println("[" + Thread.currentThread() + "] Não existem objetos, vai esperar!");
                    while (objetosDisponiveis.isEmpty()) {
                        wait();
                    }
                    System.out.println("[" + Thread.currentThread() + "] Acordou! Pegou o objeto disponivel");
                    return objetosDisponiveis.removeFirst();
                } else {
                    // cria objeto novo
                    T o = criaInstancia();
                    System.out.println("[" + Thread.currentThread() + "] Criou um novo objeto");
                    objetosCriados.add(o);
                    System.out.println("[" + Thread.currentThread() + "] Retornou o objeto ja disponivel");
                    return o;
                }
            }
        }
        return objetosDisponiveis.removeFirst();
    }

    @Override
    public void release(T t) {
        synchronized (this) {
            if (objetosCriados.contains(t)) {
                System.out.println("[" + Thread.currentThread() + "] Retornou o objeto");
                this.objetosDisponiveis.add(t);
            } else {
                throw new IllegalArgumentException("O objeto devolvido não pertence ao pull");
            }
        }
    }

}
