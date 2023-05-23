package br.com.bookstore.service;

import br.com.bookstore.exceptions.DataIntegrityViolationException;
import br.com.bookstore.exceptions.ObjectNotFoundException;
import br.com.bookstore.model.Categoria;
import br.com.bookstore.model.Livro;
import br.com.bookstore.repository.LivroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ModelMapper modelMapper;

    public Livro findById(Integer id) {
        Optional<Livro> obj = livroRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }

    public List<Livro> findAllLivroByCategoriaNome(String nome) {
        return livroRepository.findByCategoriaNomeContaining(nome);

    }

    public List<Livro> findAll(Integer id_cat) {
        categoriaService.findLivroByCategoria(id_cat);
        return livroRepository.findAllByCategoria(id_cat);
    }

    public Livro upDate(Livro obj) {
        findById(obj.getId());
        return livroRepository.save(obj);
    }

    public Livro save(Integer id_cat, Livro obj) {
        obj.setId(null);
        findByTitulo(obj);
        Categoria cat = categoriaService.findById(id_cat);
        obj.setCategoria(cat);
        return livroRepository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        livroRepository.deleteById(id);
    }

    private void findByTitulo(Livro obj) {
        Optional<Livro> newObj = livroRepository.findByTitulo(obj.getTitulo());
        if (newObj.isPresent() && !newObj.get().getId().equals(obj.getId())) {
            throw new DataIntegrityViolationException("Já existe livro com o título " + obj.getTitulo() +
                    " na base de dados!");
        }
    }
}
