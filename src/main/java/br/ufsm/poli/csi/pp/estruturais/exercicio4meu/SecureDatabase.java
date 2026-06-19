package br.ufsm.poli.csi.pp.estruturais.exercicio4meu;

public class SecureDatabase implements Database {

    public RealDatabase realDatabase;

    public SecureDatabase(RealDatabase realDatabase) {
        this.realDatabase = realDatabase;
    }

    @Override
    public String query(String sql) {
        if (sql.startsWith("SELECT")) {
            return realDatabase.query(sql);
        }
        return null;
    }

    @Override
    public void authenticate(String username, String password) {
        realDatabase.authenticate(username, password);
    }

}
