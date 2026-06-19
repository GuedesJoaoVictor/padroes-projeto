package br.ufsm.poli.csi.pp.estruturais.exercicio4a;

public interface Database {

    String query(String sql);
    void authenticate(String username, String passwrord);

}
