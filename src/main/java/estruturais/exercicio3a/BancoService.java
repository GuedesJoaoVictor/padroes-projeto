package estruturais.exercicio3a;

public interface BancoService {
    ContaBancaria criaContaBancaria(String cpf, Double saldo, ContaBancaria.TipoContaBancaria tipoContaBancaria,
                                    boolean especial, Double limite);

    ContaBancaria excluiContaBancaria(Long numero) throws BancoException;

    void deposito(Long numeroConta, Double valorDeposito) throws BancoException;

    void saque (Long numeroConta, Double valorSaque) throws BancoException;

    Double getSaldo(Long numeroConta) throws BancoException;

    String extrato(Long numeroConta) throws BancoException;

    void transferir(Long numeroContaOrigem, Long numeroContaDestino, Double valorTransferencia) throws BancoException;

    void calculaRendimentos(double jurosPoupanca, double jurosRendaFixa, double jurosRendaVariavel) throws BancoException;

}
