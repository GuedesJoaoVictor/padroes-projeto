package br.ufsm.poli.csi.pp.intro.exercicio7;

import br.ufsm.poli.csi.pp.intro.exercicio1.Comodo;
import lombok.SneakyThrows;
import org.jspecify.annotations.NonNull;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class MeuJSONFramework {

    public static void main(String[] args) {
        ClasseExemplo classeExemplo = new ClasseExemplo();
        classeExemplo.setId(11L);
        classeExemplo.setValor(1.123);
        classeExemplo.setDataNascimento(new Date());
        classeExemplo.setPropriedades(List.of("lala", "lele", "lili"));
        classeExemplo.setNome("Meu JSON Framework");
        classeExemplo.setMod("moomomo");
        ClasseExemplo.InnerClass innerClass = new ClasseExemplo.InnerClass();
        innerClass.setId(12L);
        innerClass.setNome("nomenome");
        classeExemplo.setObjAninhado(innerClass);
        MeuJSONFramework meuJSONFramework = new MeuJSONFramework();
        System.out.println(meuJSONFramework.geraJSON(classeExemplo));
    }

    public String geraJSON(Object obj) {
        return geraJSON(obj, "\t");
    }
    @SneakyThrows
    private String geraJSON(Object obj, String indent) {
        StringBuilder strRet = new StringBuilder();
        strRet.append("{\n");
        for (Method m : obj.getClass().getMethods()) {
            if ((m.getName().startsWith("get") || m.getName().startsWith("is")) && m.isAnnotationPresent(JSON.class)) {
                String nome;
                if (m.getName().startsWith("get")) {
                    nome = m.getName().substring(3, 4).toLowerCase() + m.getName().substring(4);
                } else {
                    nome = m.getName().substring(2, 3).toLowerCase() + m.getName().substring(3);
                }
                Object retVal = m.invoke(obj);
                String valor = getValorJSON(m, retVal, indent);
                strRet.append(indent).append("\"").append(nome).append("\": ").append(valor);
                strRet.append(",\n");
            }
        }
        strRet.delete(strRet.length() - 2, strRet.length());
        strRet.append("\n").append(indent).append("}");
        return strRet.toString();
    }

    private @NonNull String getValorJSON(Method m, Object retVal, String indent) {
        String valor;
        String aspas = "";
        if (!Number.class.isAssignableFrom(m.getReturnType())
                && m.getReturnType().getName().startsWith("java.")) {
            aspas = "\"";
        }
        if (retVal != null) {
            if (retVal instanceof Date) {
                aspas = "\"";
                DateFormat df = new SimpleDateFormat(m.getAnnotation(JSON.class).dateFormat());
                valor = df.format((Date) retVal);
            } else if (Collection.class.isAssignableFrom(retVal.getClass())) {
                valor = "[";
                aspas = "";
                for (Object arrObj : (Collection<?>) retVal) {
                    valor += (getValorJSON(m, arrObj, indent) + ", ");
                }
                valor = valor.substring(0, valor.length() - 2) + "]";
            } else if (!retVal.getClass().getName().startsWith("java.")) {
                valor = geraJSON(retVal, indent + "\t");
            } else {
                valor = retVal.toString();
            }
        } else {
            valor = "null";
            aspas = "";
        }
        return aspas + valor + aspas;
    }

    @SneakyThrows
    public static String getJSON(Object obj) {
        for (Method m : obj.getClass().getMethods()) {
            if (m.getName().startsWith("get") && m.isAnnotationPresent(JSON.class)) {
                System.out.println(m.getName());
                System.out.println(m.invoke(obj));
            }
        }
        return "";
    }

}
