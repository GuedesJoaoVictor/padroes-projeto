package br.ufsm.poli.csi.pp.comportamentais.exercicio5b;

import br.ufsm.poli.csi.pp.comportamentais.exercicio5.ContaBancaria;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOInvoker {

    private final List<Command> commands = new ArrayList<>();
    private DataSource dataSource;

    public synchronized void insert(ContaBancaria conta, DAOCallback callback) {
        InsertCommand command = new InsertCommand(conta, callback);
        commands.add(command);
    }

    public synchronized void update(ContaBancaria conta, DAOCallback callback) {
        UpdateCommand command = new UpdateCommand(conta, callback);
        commands.add(command);
    }

    public synchronized void delete(ContaBancaria conta, DAOCallback callback) {
        DeleteCommand command = new DeleteCommand(conta.getNumero(), callback);
        commands.add(command);
    }

    public synchronized void select(ContaBancaria conta, DAOCallback callback) {
        SelectCommand command = new SelectCommand(conta.getNumero(), callback);
        commands.add(command);
    }

    private void agendaCommand(Command command) {
        commands.add(command);
        if (commands.size() > 20) {
            try (Connection con = dataSource.getConnection()) {
                try {
                    batchInvoke(con);
                    con.commit();
                } catch (SQLException e) {
                   try { con.rollback(); } catch (SQLException ex) {
                       ex.printStackTrace();
                   }
                }
            } catch (SQLException e) {
            }
        }
        commands.clear();
    }

    private void batchInvoke(Connection con) throws SQLException {
        for (Command command : commands) {
            command.execute(con);
        }
    }

}
