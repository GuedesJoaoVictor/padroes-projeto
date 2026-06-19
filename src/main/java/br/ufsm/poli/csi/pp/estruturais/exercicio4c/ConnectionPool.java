package br.ufsm.poli.csi.pp.estruturais.exercicio4c;

import lombok.SneakyThrows;

import javax.sql.DataSource;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

    public static final int MAX_CONNECTIONS = 20;
    public static final int MIN_CONNECTIONS = 3;
    private final List<Connection> availableConnections = new ArrayList<>();
    private final List<Connection> createdConnections = new ArrayList<>();
    private final DataSource dataSource;

    private class ConnectionInvHandler implements InvocationHandler {
        private final Connection connection;

        public ConnectionInvHandler(Connection connection) {
            this.connection = connection;
        }

        @Override
        public Object invoke(Object proxy, java.lang.reflect.Method method, Object[] args) throws Throwable {
            if (method.getName().equals("close")) {
                release(connection);
                return null;
            }
            return method.invoke(connection, args);
        }

    }

    public ConnectionPool(DataSource dataSource) {
        this.dataSource = dataSource;
        for (int i = 0; i < MIN_CONNECTIONS; i++) {
            Connection connection = createConnection();
            createdConnections.add(connection);
            availableConnections.add(connection);
        }
    }

    @SneakyThrows
    private Connection createConnection() {
        return (Connection) Proxy.newProxyInstance(
                ConnectionPool.class.getClassLoader(),
                new Class[] { Connection.class },
                new ConnectionInvHandler(dataSource.getConnection())
        );
    }

    @SneakyThrows
    public Connection acquire() {
        synchronized (this) {
            if (availableConnections.isEmpty()) {
                if (createdConnections.size() == MAX_CONNECTIONS) {
                    // Makes thread wait
                    System.out.println("[" + Thread.currentThread() + "] Don't exist connections, waiting...");
                    while (availableConnections.isEmpty()) {
                        this.wait();
                    }
                    System.out.println("[" + Thread.currentThread() + "] wake up!");
                    return availableConnections.removeFirst();
                }
                // Creates new connection
                System.out.println("Don't exist connections, creating new connection...");
                Connection connection = createConnection();
                createdConnections.add(connection);
                return connection;
            }
            // Has available connections
            System.out.println("[" + Thread.currentThread() + "] has available connections. " +
                    "Connections remaining: " + availableConnections.size());
            return availableConnections.removeFirst();
        }
    }

    private void release(Connection connection) {
        synchronized (this) {
            if (createdConnections.contains(connection)) {
                System.out.println("[" + Thread.currentThread() + "] connection released");
                availableConnections.add(connection);
                this.notify();
                return;
            }
            throw new IllegalArgumentException("Connection not created by this pool");
        }
    }

}
