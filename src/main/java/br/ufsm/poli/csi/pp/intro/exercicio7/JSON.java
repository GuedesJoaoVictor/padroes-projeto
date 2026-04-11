package br.ufsm.poli.csi.pp.intro.exercicio7;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface JSON {
    String value() default " ";
    String dateFormat() default "yyyy-MM-dd HH:mm:ss";
}
