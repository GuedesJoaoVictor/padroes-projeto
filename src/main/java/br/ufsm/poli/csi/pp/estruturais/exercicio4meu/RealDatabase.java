package br.ufsm.poli.csi.pp.estruturais.exercicio4meu;

public class RealDatabase implements Database {

    @Override
    public String query(String sql) {
        System.out.println("Executando: " + sql);
        return sql;
    }

    @Override
    public void authenticate(String username, String password) {
        System.out.println("Autenticando: " + username);
    }
}
