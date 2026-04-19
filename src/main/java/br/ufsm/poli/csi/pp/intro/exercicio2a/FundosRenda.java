package br.ufsm.poli.csi.pp.intro.exercicio2a;

import lombok.Data;

@Data
public class FundosRenda extends ContaBancaria {

    private TipoContaBancaria tipoContaBancaria;

    public FundosRenda(TipoContaBancaria tipoContaBancaria) {
        if (tipoContaBancaria ==  TipoContaBancaria.CONTA_CORRENTE ||
            tipoContaBancaria == TipoContaBancaria.POUPANCA) {
            throw new IllegalArgumentException("tipo não permitido para fundos de renda");
        }
        this.tipoContaBancaria = tipoContaBancaria;
    }

    @Override
    public Double getIRPFDevido() {
        double irpf = 0.0;
        for (Movimentacao movimentacao : getMovimentacoes()) {
            if (movimentacao.getTipoMovimentacao() == Movimentacao.TipoMovimentacao.RENDIMENTO_FINANCEIRO) {
                irpf += movimentacao.getValor() * 0.275;
            }
        }
        return irpf;
    }
}
