package br.ufsm.poli.csi.pp.intro.exercicio8;

public interface Validator<T> {
    /**
     * Valida um objeto.
     *
     * @param obj O objeto a ser validado.
     * @throws ValidationException Se a validação falhar.
     */
    void validate(T obj) throws ValidationException;
}
