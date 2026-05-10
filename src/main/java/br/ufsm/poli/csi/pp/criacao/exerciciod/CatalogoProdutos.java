package br.ufsm.poli.csi.pp.criacao.exerciciod;

import java.util.HashMap;
import java.util.Map;

public class CatalogoProdutos {

    private Map<String, Produto> produtos = new HashMap<>();

    private void adicionarPrototipo(String nome, Produto produto) {
        this.produtos.put(nome, produto.clone());
    }

    private Produto clonarProduto(String nome) {
        if (!produtos.containsKey(nome)) {
            throw new IllegalArgumentException("Produto [" + nome + "] não existe no catálogo.");
        }
        return produtos.get(nome).clone();
    }

    public static void main(String[] args) {
        CatalogoProdutos catalogoProdutos = new CatalogoProdutos();
        Produto notebook = Produto.builder()
                .nome("Notebook Positivo")
                .categoria("Laptop")
                .preco(2500.0)
                .atributos(new HashMap<>(Map.of("Processador", "Intel i3")))
                .build();
        Produto teclado = Produto.builder()
                .nome("Telcado gamer")
                .categoria("Periféricos")
                .preco(100.00)
                .atributos(new HashMap<>(Map.of("Padrão", "ABNT2")))
                .build();
        catalogoProdutos.adicionarPrototipo("Notebook barato", notebook);
        catalogoProdutos.adicionarPrototipo("Teclado gamer", teclado);

        Produto notebookClonado = catalogoProdutos.clonarProduto("Notebook barato");
        notebookClonado.getAtributos().put("Processador", "Intel i9");
        notebookClonado.getAtributos().put("Memória", "32gb RAM");
        notebookClonado.setPreco(3000.0);
        catalogoProdutos.adicionarPrototipo("Notebook bom", notebookClonado);
    }

}
