package br.ufsm.poli.csi.pp.intro.exercicio8;

import br.ufsm.poli.csi.pp.intro.exercicio7.ClasseExemplo;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Objects;

public class ValidacaoFramework<T> implements Validator<T> {

    public static void main(String[] args) throws ValidationException {
        ClasseExemplo classeExemplo = new ClasseExemplo();
        classeExemplo.setId(10L);
        classeExemplo.setNome("Meu JSON Framework");
        classeExemplo.setValor(12.0);
        classeExemplo.setDataNascimento(new Date());
        classeExemplo.setNome("JoaoGue");

        ClasseExemplo.InnerClass innerClass = new ClasseExemplo.InnerClass();
        innerClass.setId(0L);
        classeExemplo.setObjAninhado(innerClass);

        ValidacaoFramework<ClasseExemplo> validacaoFramework = new ValidacaoFramework<ClasseExemplo>();
        validacaoFramework.validate(classeExemplo);
    }

    @SneakyThrows
    @Override
    public void validate(T obj) throws ValidationException {
        if (obj == null) {
            throw new ValidationException("objeto nulo");
        } else if (obj.getClass().isAnnotationPresent(Validate.class)) {
            for (Field field : obj.getClass().getDeclaredFields()) {
                field.setAccessible(true);

                if (field.isAnnotationPresent(Min.class) && Number.class.isAssignableFrom(field.getType())) {
                    Min annotation = field.getAnnotation(Min.class);
                    double min = annotation.min();

                    Object value = field.get(obj);
                    if (Number.class.isAssignableFrom(value.getClass())) {
                        boolean isMinor = ((Number) value).doubleValue() < min;
                        if (isMinor) {
                            throw new ValidationException("[" + field.getName() + "] " + annotation.msgErro());
                        }
                    }
                } else if (field.isAnnotationPresent(Max.class) && Number.class.isAssignableFrom(field.getType())) {
                    Max annotation = field.getAnnotation(Max.class);
                    double max = annotation.max();

                    field.setAccessible(true);
                    Object value = field.get(obj);
                    if (Number.class.isAssignableFrom(value.getClass())) {
                        boolean isMajor = ((Number) value).doubleValue() > max;
                        if (isMajor) {
                            throw new ValidationException("[" + field.getName() + "] " + annotation.msgErro());
                        }
                    }
                } else if (field.isAnnotationPresent(NotNull.class)) {
                    NotNull annotation = field.getAnnotation(NotNull.class);
                    Object value = field.get(obj);
                    if (Objects.isNull(value)) {
                        throw new ValidationException("[" + field.getName() + "] " + annotation.msgErro());
                    }
                } else if (field.isAnnotationPresent(Pattern.class)) {
                    Pattern annotation = field.getAnnotation(Pattern.class);
                    String regex = annotation.regex();
                    Object value = field.get(obj);
                    if (value instanceof String) {
                        boolean isInvalid = !((String) value).matches(regex);
                        if (isInvalid) {
                            throw new ValidationException("[" + field.getName() + "] " + annotation.msgErro());
                        }
                    }
                } else if (field.getType().isAnnotationPresent(Validate.class) && Objects.nonNull(field.get(obj))) {
                    Object value = field.get(obj);
                    if (Objects.nonNull(value) && value.getClass().isAnnotationPresent(Validate.class)) {
                        validate((T) value);
                    }
                }
            }
        }
    }
}
