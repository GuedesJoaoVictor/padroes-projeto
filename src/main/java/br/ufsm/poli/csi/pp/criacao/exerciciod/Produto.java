package br.ufsm.poli.csi.pp.criacao.exerciciod;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Produto implements ProdutoPrototype {

    private String nome;
    private String categoria;
    private Double preco;
    private Map<String, String> atributos = new HashMap<>();


    @Override
    public Produto clone() {
        Map<String, String> atributos = new HashMap<>(this.atributos);
        return Produto.builder()
                .nome(getNome())
                .categoria(getCategoria())
                .preco(getPreco())
                .atributos(atributos)
                .build();
    }
}
