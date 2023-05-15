package br.com.bookstore;

import br.com.bookstore.model.Categoria;
import br.com.bookstore.model.Livro;
import br.com.bookstore.repository.CategoriaRepository;
import br.com.bookstore.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática", "Livro de TI");

		Livro l1 = new Livro(null, "Clean code", "Robertin Martin", "Lorem ipsum", cat1);

		cat1.getLivro().addAll(Arrays.asList(l1));

		this.categoriaRepository.saveAll(Arrays.asList(cat1));
		livroRepository.saveAll(Arrays.asList(l1));
	}
}
