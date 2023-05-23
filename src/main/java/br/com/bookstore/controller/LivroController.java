package br.com.bookstore.controller;

import br.com.bookstore.dtos.LivroDTO;
import br.com.bookstore.model.Livro;
import br.com.bookstore.service.LivroService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Integer id) {
        Livro obj = livroService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/categoria/{nome}")
    public ResponseEntity<List<LivroDTO>> findAllLivroByCategoria(@PathVariable String nome) {
        List<Livro> list = livroService.findAllLivroByCategoriaNome(nome);
        return ResponseEntity.ok().body(list.stream().map(x -> new LivroDTO(x)).collect(Collectors.toList()));
    }

    @GetMapping
    public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat) {
        List<Livro> list = livroService.findAll(id_cat);
        return ResponseEntity.ok().body(list.stream().map(x -> new LivroDTO(x)).collect(Collectors.toList()));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Livro> upDate(@PathVariable Integer id_cat, @Valid @RequestBody Livro obj) {
        return ResponseEntity.ok().body(livroService.save(id_cat, obj));
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Livro> upDatePatch(@PathVariable Integer id_cat, @Valid @RequestBody Livro obj) {
        return ResponseEntity.ok().body(livroService.save(id_cat, obj));
    }

    @PostMapping
    public ResponseEntity<Livro> save(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat,
                                      @Valid @RequestBody Livro obj) {
        return ResponseEntity.ok().body(livroService.save(id_cat, obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        livroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
