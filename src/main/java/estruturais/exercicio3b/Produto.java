package estruturais.exercicio3b;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Produto implements Componente {

    private String nome;
    private String descricao;
    private Double valor;

    @Override
    public Double getValor() {
        return valor;
    }
}
