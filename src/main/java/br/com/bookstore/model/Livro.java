package br.com.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Livro implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "O campo TÍTULO é requerido")
    @Length(min = 3, max = 50, message = "O campo TÍTULO deve ter entre 3 e 50 caracteres")
    private String titulo;
    @NotBlank(message = "O campo NOME DO AUTOR é requerido")
    @Length(min = 3, max = 50, message = "O campo NOME DO AUTOR deve ter entre 3 e 50 caracteres")
    private String nome_autor;
    @NotBlank(message = "O campo TEXTO é requerido")
    @Length(min = 10, max = 2000000, message = "O campo TEXTO deve ter entre 10 e 2000000 caracteres")
    private String texto;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Livro() {
        super();
    }

    public Livro(Integer id, String titulo, String nome_autor, String texto, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.nome_autor = nome_autor;
        this.texto = texto;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNome_autor() {
        return nome_autor;
    }

    public void setNome_autor(String nome_autor) {
        this.nome_autor = nome_autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Livro)) return false;
        Livro livro = (Livro) o;
        return id.equals(livro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
