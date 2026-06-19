package br.ufsm.poli.csi.pp.comportamentais.exercicio5b;

import br.ufsm.poli.csi.pp.comportamentais.exercicio5.ContaBancaria;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@AllArgsConstructor
public class UpdateCommand implements Command {

    private ContaBancaria conta;
    private DAOCallback callback;


    @Override
    public void execute(Connection con) throws SQLException {
        try (PreparedStatement stmt = con.prepareStatement("UPDATE conta_bancaria SET saldo ? WHERE id = ?")) {
            stmt.setDouble(1, conta.getSaldo());
            int i = stmt.executeUpdate();
            callback.callback(i);
        }
    }
}
