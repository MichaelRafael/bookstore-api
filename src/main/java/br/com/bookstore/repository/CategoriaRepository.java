package br.com.bookstore.repository;

import br.com.bookstore.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    Optional<Categoria> findByNome(String nome);

    @Query(value = "SELECT c FROM Categoria c WHERE c.nome =:nome")
    Optional<Categoria> buscarPorNome(@Param("nome") String nome);



}
