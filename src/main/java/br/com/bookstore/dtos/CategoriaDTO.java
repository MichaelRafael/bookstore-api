package br.com.bookstore.dtos;

import br.com.bookstore.model.Categoria;
import br.com.bookstore.model.Livro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoriaDTO implements Serializable {

    private static final long serialVersionUID = 1l;
    private Integer id;
    @NotBlank(message = "O campo NOME é requerido")
    @Length(min = 3, max = 100, message = "O campo NOME deve ter entre 3 e 100 caracteres")
    private String nome;
    @NotBlank(message = "O campo DESCRIÇÃO é requerido")
    @Length(min = 3, max = 100, message = "O campo DESCRIÇÃO deve ter entre 3 e 100 caracteres")
    private String descricao;
    private List<Livro> livros = new ArrayList<>();

    public CategoriaDTO() {
        super();
    }

    public CategoriaDTO(Categoria obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.descricao = obj.getDescricao();
        this.livros = obj.getLivros();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }


}
