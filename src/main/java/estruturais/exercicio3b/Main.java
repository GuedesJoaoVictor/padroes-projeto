package estruturais.exercicio3b;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Produto notebook = Produto.builder()
                .nome("Notebook")
                .descricao("Notebook top")
                .valor(1500.00)
                .build();
        Produto teclado = Produto.builder()
                .nome("Teclado")
                .descricao("Teclado top")
                .valor(200.00)
                .build();

        Caixa caixa = Caixa.builder()
                .preco(50.00)
                .componentes(new ArrayList<>(Arrays.asList(notebook, teclado)))
                .build();

        Caixa caixa2 = Caixa.builder()
                .preco(10.00)
                .componentes(new ArrayList<>(Arrays.asList(caixa)))
                .build();

        Produto mouse = Produto.builder()
                .nome("Mouse")
                .descricao("Mouse top")
                .valor(100.00)
                .build();

        caixa2.getComponentes().add(mouse);

        System.out.println(caixa2.getValor());
    }

}
