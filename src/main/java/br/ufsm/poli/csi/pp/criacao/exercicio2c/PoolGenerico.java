package br.ufsm.poli.csi.pp.criacao.exercicio2c;

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
            T object = criaInstancia();
            objetosCriados.add(object);
            objetosDisponiveis.add(object);
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
            // nao tem objeto disponivel
            if (objetosDisponiveis.isEmpty()) {
                if (objetosCriados.size() == 20) {
                    // colocamos pra esperar
                    System.out.println("Não existem objetos," + Thread.currentThread() + " vai esperar!");
                    while (objetosDisponiveis.isEmpty()) {
                        this.wait();
                    }
                    // parou de esperar pq conseguiu o objeto
                    System.out.println(Thread.currentThread() + " acordou! Pegou o objeto disponivel");
                    return objetosDisponiveis.removeFirst();
                } else {
                    // cria um objeto novo!
                    System.out.println(Thread.currentThread() + " criou um novo objeto");
                    T object = criaInstancia();
                    objetosCriados.add(object);
                    System.out.println(Thread.currentThread() + " retornou o objeto criado");
                    return object;
                }
            } else {
                // tem objeto disponivel
                System.out.println(Thread.currentThread() + " retornou o objeto disponivel");
                return objetosDisponiveis.removeFirst();
            }
        }
    }

    @Override
    public void release(T t) {
        synchronized (this) {
            if (objetosCriados.contains(t)) {
                System.out.println(Thread.currentThread() + " devolveu o objeto");
                objetosDisponiveis.add(t);
                this.notify();
            } else {
                throw new IllegalArgumentException("Esse objeto não pertence ao pool");
            }
        }
    }
}
