package br.ufsm.poli.csi.pp.intro.exercicio2c;

import br.ufsm.poli.csi.pp.intro.exercicio7.ClasseExemplo;
import lombok.SneakyThrows;

import java.security.SecureRandom;
import java.util.Random;

public class PoolTest {

    PoolGenerico<ClasseExemplo> pool = new PoolGenerico<ClasseExemplo>(ClasseExemplo.class);

    @SneakyThrows
    public static void main(String[] args) {
        new PoolTest();
        Thread.sleep(100000000);
    }

    PoolTest() {
        init();
    }

    private void init() {
        for (int i = 0; i < 100; i++) {
            Thread.ofVirtual().start(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    Random random = new SecureRandom();

                    while (true) {
                        Thread.sleep(random.nextInt(2000));
                        ClasseExemplo c = pool.acquire();
                        Thread.sleep(random.nextInt(2000));
                        pool.release(c);
                    }
                }
            });
        }
    }
}
