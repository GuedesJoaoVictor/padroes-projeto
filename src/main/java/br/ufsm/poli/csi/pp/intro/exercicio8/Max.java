package br.ufsm.poli.csi.pp.intro.exercicio8;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Max {
    double max() default Double.MAX_VALUE;
    String msgErro() default "";
}
