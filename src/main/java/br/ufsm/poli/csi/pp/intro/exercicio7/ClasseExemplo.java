package br.ufsm.poli.csi.pp.intro.exercicio7;

import br.ufsm.poli.csi.pp.intro.exercicio8.*;

import java.util.Date;
import java.util.List;

/**
 * Classe de exemplo utilizada na aula de padrões de projeto
 * @author rafael
 */
@Validate(mensagem = "Erro de validacao")
public class ClasseExemplo {

    private String mod;
    @Pattern(regex = "^[a-zA-Z]+$", msgErro = "Nome deve conter apenas letras")
    private String nome;
    @Min(min = 1, msgErro = "valor deve ser maior do que 1")
    private Long id;
    @Max(max = 100, msgErro = "valor deve ser menor do que 100")
    private Double valor;
    @NotNull(msgErro = "A data de nascimento não pode ser null")
    private Date dataNascimento;
    private InnerClass objAninhado;
    private List<String> propriedades;

    /**
     * lista de propriedades tanana...
     * @return uma lista
     */
    @JSON
    public List<String> getPropriedades() {
        return propriedades;
    }

    /**
     * seta a lista de propri...
     * @param propriedades uma lista
     */
    public void setPropriedades(List<String> propriedades) {
        this.propriedades = propriedades;
    }

    @JSON
    public InnerClass getObjAninhado() {
        return objAninhado;
    }

    public void setObjAninhado(InnerClass objAninhado) {
        this.objAninhado = objAninhado;
    }

    @JSON(dateFormat = "dd/MM/yyyy")
    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @JSON
    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getMod() {
        return mod;
    }

    public void setMod(String mod) {
        this.mod = mod;
    }

    @JSON
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @JSON
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Validate(mensagem = "Erro de validacao")
    public static class InnerClass {
        @Min(min = 1, msgErro = "valor deve ser maior do que 1")
        private Long id;
        private String nome;

        @JSON
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        @JSON
        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }
    }

}
