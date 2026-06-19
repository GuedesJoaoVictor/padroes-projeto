package br.ufsm.poli.csi.pp.comportamentais.exercicio5b;

import java.sql.Connection;
import java.sql.SQLException;

public interface Command {

    void execute(Connection con) throws SQLException;

}
