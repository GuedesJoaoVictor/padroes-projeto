package br.ufsm.poli.csi.pp.comportamentais.exercicio5b;

import br.ufsm.poli.csi.pp.comportamentais.exercicio5.ContaBancaria;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@AllArgsConstructor
public class InsertCommand implements Command {

    private ContaBancaria conta;
    private DAOCallback callback;

    @Override
    public void execute(Connection con) throws SQLException {
        try (PreparedStatement pstm =
            con.prepareStatement("insert into conta_bancaria (id, cpf, saldo) VALUES (?, ?, ?)")) {
            pstm.setLong(1, conta.getNumero());
            pstm.setObject(2, conta.getCpf());
            pstm.setObject(3, conta.getSaldo());
            int i = pstm.executeUpdate();
            callback.callback(i);
        }
    }
}
