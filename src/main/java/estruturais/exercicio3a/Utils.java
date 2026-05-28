package estruturais.exercicio3a;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {

    public static void escreverLog(String log, String arquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {
            writer.write(log + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
