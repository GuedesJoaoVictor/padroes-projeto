package estruturais.exercicio3a;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LogsContasDecorator extends ContaBancaria {

    private final ContaBancaria contaBancaria;
    public static String LOGS_PATH;

    public LogsContasDecorator(ContaBancaria conta) {
        this.contaBancaria = conta;
        LOGS_PATH = "LogsContas " + conta.getNumero() + ".txt";

        Path path = Paths.get(LOGS_PATH);
        if (!Files.exists(path)) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(LOGS_PATH));
                writer.write("LOGS CONTA BANCARIA " + contaBancaria.getNumero());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void escreverLogs(String log) {
        Utils.escreverLog(log, LOGS_PATH);
    }

    @Override
    public Double getIRPFDevido() {
        Double irpf = contaBancaria.getIRPFDevido();
        escreverLogs("IRPF DEVIDO " + irpf);

        return irpf;
    }
}
