package br.ufsm.poli.csi.pp.estruturais.exercicio4b;

import br.ufsm.poli.csi.pp.estruturais.exercicio3a.BancoService;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

public class LogBancoProxy implements InvocationHandler {

    private BancoService bancoService;
    private FileWriter fileWriter = new FileWriter("log.txt");

    public LogBancoProxy(BancoService bancoService) throws IOException {
        this.bancoService = bancoService;
    }

    private void escreverLog(String log, long millis) {
        try {
            fileWriter.write("[BANCO] " + new Date() + ": " + log + "(" + millis + "ms)\n");
            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long millis = System.currentTimeMillis();
        Object result = method.invoke(bancoService, args);
        escreverLog(method.getName(), System.currentTimeMillis() - millis);
        return result;
    }

}
