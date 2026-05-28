package estruturais.exercicio3a;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContaCorrente extends ContaBancaria {

    private boolean especial;
    private Double limiteChequeEspecial;

    @Override
    public Double getIRPFDevido() {
        return 0.0;
    }
}
