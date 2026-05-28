package estruturais.exercicio3b;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Caixa implements Componente {

    private Double preco;
    private ArrayList<Componente> componentes;

    @Override
    public Double getValor() {
        Double valor = this.preco;
        for (Componente componente : componentes) {
            valor += componente.getValor();
        }
        return valor;
    }
}
