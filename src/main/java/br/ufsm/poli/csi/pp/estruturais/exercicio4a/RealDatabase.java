package br.ufsm.poli.csi.pp.estruturais.exercicio4a;

import lombok.SneakyThrows;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class RealDatabase implements Database {

    private DataSource dataSource;

    public RealDatabase(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @SneakyThrows
    @Override
    public String query(String sql) {
        try (Connection connection = dataSource.getConnection();
             Statement stmt = connection.createStatement()) {
            if (stmt.execute(sql)) {
                ResultSet rs = stmt.getResultSet();
                int cont = 0;
                while (rs.next()) {
                    cont++;
                }
                return cont + " rows returnded.";
            } else {
                return stmt.getUpdateCount() + " rows affected.";
            }
        }
    }

    @SneakyThrows
    @Override
    public void authenticate(String username, String passwrord) {
        dataSource.getConnection(username, passwrord);
    }

}
