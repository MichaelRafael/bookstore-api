package br.com.bookstore.service;

import br.com.bookstore.enuns.LivroEnum;
import br.com.bookstore.model.Categoria;
import br.com.bookstore.model.Livro;
import br.com.bookstore.repository.CategoriaRepository;
import br.com.bookstore.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LivroRepository livroRepository;

    public void instaciaDB() {

        Categoria cat1 = new Categoria(null, "Informática", "Livro de TI");
        Categoria cat2 = new Categoria(null, "Ficção Científica", "Ficção Científica");
        Categoria cat3 = new Categoria(null, "Biografias", "Livros de Biografias");

        Livro l1 = new Livro(null, "Clean code", "Robertin Martin", "Lorem ipsum", LivroEnum.MEDIO, cat1);
        Livro l2 = new Livro(null, "Engenharia de Software", "Louis V. Gerstner", "Lorem ipsum", LivroEnum.GRANDE, cat1);
        Livro l3 = new Livro(null, "The time machine", "H. G. Wells", "Lorem ipsum", LivroEnum.MEDIO, cat2);
        Livro l4 = new Livro(null, "The war of the worlds", "H. G. Wells", "Lorem ipsum", LivroEnum.PEQUENO, cat2);
        Livro l5 = new Livro(null, "I, robot", "Isaac Asimov", "Lorem ipsum", LivroEnum.GRANDE, cat2);

        cat1.getLivros().addAll(Arrays.asList(l1));

        this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
    }
}
