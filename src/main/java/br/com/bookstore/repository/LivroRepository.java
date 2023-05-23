package br.com.bookstore.repository;

import br.com.bookstore.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

    Optional<Livro> findByTitulo(String titulo);

    @Query(value = "SELECT obj FROM Livro obj WHERE obj.categoria.id =:id_cat ORDER BY titulo")
    List<Livro> findAllByCategoria(@Param(value = "id_cat") Integer id_cat);

    @Query(value = "SELECT obj FROM Livro obj WHERE obj.categoria.nome =:nome_cat")
    List<Livro> findAllLivroByCategoriaNome(@Param(value = "nome_cat") String nome_cat);

    List<Livro> findByCategoriaNomeContaining(String name);
}
