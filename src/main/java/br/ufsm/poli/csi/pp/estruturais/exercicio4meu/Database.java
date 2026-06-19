package br.ufsm.poli.csi.pp.estruturais.exercicio4meu;

public interface Database {
    String query(String sql);
    void authenticate(String username, String password);
}
