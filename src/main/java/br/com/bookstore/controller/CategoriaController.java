package br.com.bookstore.controller;

import br.com.bookstore.dtos.CategoriaDTO;
import br.com.bookstore.dtos.CategoriaDTOFindAll;
import br.com.bookstore.model.Categoria;
import br.com.bookstore.service.CategoriaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ModelMapper modelMapper;
    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoriaDTO> findById(@PathVariable Integer id) {
        Categoria obj = categoriaService.findById(id);
        return ResponseEntity.ok().body(modelMapper.map(obj, CategoriaDTO.class));
    }
    @GetMapping
    public ResponseEntity<List<CategoriaDTOFindAll>> findAll() {
        List<Categoria> list = categoriaService.findAll();
        return ResponseEntity.ok().body(list.stream().map(obj -> new CategoriaDTOFindAll(obj))
                .collect(Collectors.toList()));
    }
    @PostMapping
    public ResponseEntity<CategoriaDTO> save(@Valid @RequestBody CategoriaDTO categoriaDTO) {
        return ResponseEntity.ok().body(modelMapper.map(categoriaService.save(categoriaDTO), CategoriaDTO.class));
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoriaDTO> upDate(@Valid @PathVariable Integer id, @RequestBody CategoriaDTO categoriaDTO) {
        categoriaDTO.setId(id);
        return ResponseEntity.ok().body(modelMapper.map(categoriaService.upDate(categoriaDTO), CategoriaDTO.class));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
