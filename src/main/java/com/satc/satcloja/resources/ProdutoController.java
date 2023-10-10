package com.satc.satcloja.resources;

import com.satc.satcloja.model.Produto;
import com.satc.satcloja.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity buscaTodos() {
        return ResponseEntity.ok(produtoService.buscaTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity buscaPorId(@PathVariable Long id) {
        Produto entity = produtoService.buscaPorId(id);

        return ResponseEntity.ok(entity);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Produto entity) {
        Produto saved = produtoService.salvar(entity);

        return ResponseEntity.created(URI.create("/api/produtos/" + saved.getId())).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        produtoService.remover(id);

        return ResponseEntity.noContent().build();
    }
}
