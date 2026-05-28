package estruturais.exercicio3a;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Poupanca extends ContaBancaria {

    @Override
    public Double getIRPFDevido() {
        return 0.0;
    }
}
