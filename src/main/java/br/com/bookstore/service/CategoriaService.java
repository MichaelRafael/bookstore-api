package br.com.bookstore.service;

import br.com.bookstore.dtos.CategoriaDTO;
import br.com.bookstore.exceptions.DataIntegrityViolation;
import br.com.bookstore.exceptions.DataIntegrityViolationException;
import br.com.bookstore.exceptions.IllegalArgumentException;
import br.com.bookstore.exceptions.ObjectNotFoundException;
import br.com.bookstore.model.Categoria;
import br.com.bookstore.model.Livro;
import br.com.bookstore.repository.CategoriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Categoria findById(Integer id) {
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada!"));
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria save(CategoriaDTO objDTO) {
        findByNome(objDTO);
        objDTO.setId(null);
        return categoriaRepository.save(modelMapper.map(objDTO, Categoria.class));
    }

    public Categoria upDate(CategoriaDTO objDTO) {
        findById(objDTO.getId());
        buscarPorNome(objDTO);
        return categoriaRepository.save(modelMapper.map(objDTO, Categoria.class));
    }

    public void delete(Integer id) {
        findById(id);
        Optional<Categoria> cat = categoriaRepository.findById(id);
        if (cat.get().getLivros().size() > 0) {
            throw new DataIntegrityViolation("Esta categoria possui livros, não pode ser deletada!!!");
        }
        categoriaRepository.deleteById(id);
    }

    private void findByNome(CategoriaDTO objDTO) {
        Optional<Categoria> cat = categoriaRepository.findByNome(objDTO.getNome());
        if (cat.isPresent() && cat.get().getNome().equals(objDTO.getNome())) {
            throw new IllegalArgumentException("Já existe uma categoria com o nome " + objDTO.getNome());
        }

    }
    private void buscarPorNome(CategoriaDTO objDTO) {
        Optional<Categoria> cat = categoriaRepository.buscarPorNome(objDTO.getNome());
        if (cat.isPresent() && !cat.get().getId().equals(objDTO.getId())) {
            throw new DataIntegrityViolationException("Este ID " + objDTO.getId() + " não correponde a esta categoria");
        }
    }

    public Categoria findLivroByCategoria(Integer id_cat) {
        Optional<Categoria> obj = categoriaRepository.findById(id_cat);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada!"));
    }
}
