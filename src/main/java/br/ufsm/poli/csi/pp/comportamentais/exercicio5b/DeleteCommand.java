package br.ufsm.poli.csi.pp.comportamentais.exercicio5b;

import br.ufsm.poli.csi.pp.comportamentais.exercicio5.ContaBancaria;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@AllArgsConstructor
public class DeleteCommand implements Command {

    private Long numero;
    private DAOCallback callback;

    @Override
    public void execute(Connection con) throws SQLException {
        try (PreparedStatement stmt = con.prepareStatement("DELETE FROM conta WHERE numero = ?")) {
            stmt.setLong(1, numero);
            stmt.executeUpdate();
            int i =  stmt.executeUpdate();
            callback.callback(i);
        }
    }
}
