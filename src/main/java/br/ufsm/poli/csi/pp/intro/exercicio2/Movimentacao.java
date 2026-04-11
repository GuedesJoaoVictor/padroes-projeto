package br.ufsm.poli.csi.pp.intro.exercicio2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Movimentacao {

    private String descricao;
    private Double valor;
    private TipoMovimentacao tipoMovimentacao;

    public enum TipoMovimentacao {
        CREDITO,
        DEBITO,
        RENDIMENTO_FINANCEIRO
    }

}
