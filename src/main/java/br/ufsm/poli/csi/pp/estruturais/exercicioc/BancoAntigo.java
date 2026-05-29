package br.ufsm.poli.csi.pp.estruturais.exercicioc;

public interface BancoAntigo {

    boolean removerConta(String codigo);

    void movimentar(String codigo, double valor);

    double verificarSaldo(String codigo);

    String imprimirExtrato(String codigo);

    void transfereEntreContas(String origem, String destino, double valor);

    ContaBancaria novaConta(String cpf, String tipo, double saldoInicial, boolean vip, double limite);

}
