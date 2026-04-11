package br.ufsm.poli.csi.pp.intro.exercicio6;

import br.ufsm.poli.csi.pp.intro.exercicio2.Banco;
import br.ufsm.poli.csi.pp.intro.exercicio2.ContaBancaria;
import lombok.SneakyThrows;

import javax.swing.*;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class BancoReflection {

    @SneakyThrows
    public static void main(String[] args) {
        /*JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.showOpenDialog(null);
        if (chooser.getSelectedFile() != null) {
            File jarFile = chooser.getSelectedFile();
            JarFile jar = new JarFile(jarFile);
            Enumeration<JarEntry> entries = jar.entries();
            URLClassLoader childCL = new URLClassLoader(new URL[]{ jarFile.toURL() }, BancoReflection.class.getClassLoader());
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                if (entry.getName().endsWith(".class") &&  entry.getName().startsWith("BOOT-INF/classes/")) {
                    String className = entry.getName().replace(".class", "");
                    className = className.replace("BOOT-INF/classes/", "").replaceAll("/", ".");
                    Class<?> clazz = Class.forName(className, true, childCL);
                }
            }
        }*/
        printClass(ContaBancaria.class);
    }

    public static void printClass(Class classe) {
        for (Field f : classe.getDeclaredFields()) {
            int m = f.getModifiers();
            String abs = Modifier.isAbstract(m) ? "abstract " : "";
            String pub = Modifier.isPublic(m) ? "public " : "";
            String priv = Modifier.isPrivate(m) ? "private " : "";
            String prot = Modifier.isProtected(m) ? "protected " : "";
            String fin = Modifier.isFinal(m) ? "final " : "";
            String sta = Modifier.isStatic(m) ? "static " : "";
            String mod = abs + pub + priv + prot + fin + sta;
            System.out.println(mod + f.getType().getName() + " " + f.getName()+ ";");
        }
        System.out.println("\n");
        for (Method method : classe.getDeclaredMethods()) {
            int m = method.getModifiers();
            String abs = Modifier.isAbstract(m) ? "abstract " : "";
            String pub = Modifier.isPublic(m) ? "public " : "";
            String priv = Modifier.isPrivate(m) ? "private " : "";
            String prot = Modifier.isProtected(m) ? "protected " : "";
            String fin = Modifier.isFinal(m) ? "final " : "";
            String sta = Modifier.isStatic(m) ? "static " : "";
            String mod = abs + pub + priv + prot + fin + sta;
            String params = "";
            for (Parameter param : method.getParameters()) {
                params += param.getType().getName() + " " + param.getName() + ", ";
            }
            if (params.length() > 0) {
                params = params.substring(0, params.length() - 2);
            }
            System.out.println(mod + method.getReturnType().getName() + " " + method.getName() + "(" + params + ");");
        }
    }


}
