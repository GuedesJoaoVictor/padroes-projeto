package br.ufsm.poli.csi.pp.comportamentais.exercicio5b;

import br.ufsm.poli.csi.pp.intro.exercicio2.ContaBancaria;
import br.ufsm.poli.csi.pp.intro.exercicio2.ContaCorrente;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@AllArgsConstructor
public class SelectCommand implements Command {

    private Long numero;
    private DAOCallback callback;

    @Override
    public void execute(Connection con) throws SQLException {
        try (PreparedStatement stmt = con.prepareStatement("SELECT cpf, saldo FROM conta_bancaria WHERE numero = ?")) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String cpf = rs.getString("cpf");
                Double saldo = rs.getDouble("saldo");
                ContaBancaria conta = new ContaCorrente(false, 0.0);
                conta.setSaldo(saldo);
                conta.setNumero(numero);
                conta.setCpf(cpf);
                callback.callback(conta);
                return;
            }
            callback.callback(null);
        }
    }
}
