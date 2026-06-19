package br.ufsm.poli.csi.pp.estruturais.exercicio4a;

import br.ufsm.poli.csi.pp.estruturais.exercicio4meu.SecureDatabase;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SecureDatabaseProxy implements InvocationHandler {

    private Database database;
    private boolean authenticated = false;

    public SecureDatabaseProxy(Database database) {
        this.database = database;
    }

    public static Database createSecureDatabase(Database database) {
        return (Database) Proxy.newProxyInstance(
                SecureDatabase.class.getClassLoader(),
                new Class[] { Database.class },
                new SecureDatabaseProxy(database)
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("authenticate")) {
            try {
                method.invoke(database, args[0]);
                authenticated = true;
            } catch (Exception e) {
                authenticated = false;
                throw e;
            }
            return null;
        }
        String sql = (String) args[0];
        if (!sql.toLowerCase().startsWith("select")) {
            if (!authenticated) {
                throw new IllegalAccessException("not authenticated");
            }
        }
        return method.invoke(database, args);
    }

}
