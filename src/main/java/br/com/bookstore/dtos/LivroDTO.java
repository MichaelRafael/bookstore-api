package br.com.bookstore.dtos;

import br.com.bookstore.enuns.LivroEnum;
import br.com.bookstore.model.Livro;

import java.io.Serializable;

public class LivroDTO implements Serializable {

    private static final long serialVersionUID = 1l;

    private Integer id;
    private String titulo;
    private String nome_autor;

    private String texto;

    private LivroEnum livroEnum;

    public LivroDTO() {
    }

    public LivroDTO(Livro obj) {
        this.id = obj.getId();
        this.titulo = obj.getTitulo();
        this.nome_autor = obj.getNome_autor();
        this.texto = obj.getTexto();
        this.livroEnum = obj.getLivroEnum();

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

    public LivroEnum getLivroEnum() {
        return livroEnum;
    }

    public void setLivroEnum(LivroEnum livroEnum) {
        this.livroEnum = livroEnum;
    }
}
