package com.biolab.ecommercebiolab.controllers;

import com.biolab.ecommercebiolab.DTOs.CategoriaDTO;
import com.biolab.ecommercebiolab.DTOs.ProdutoDTO;
import com.biolab.ecommercebiolab.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping
    ResponseEntity<?> criarProduto(@Valid @RequestBody ProdutoDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));
    }

    @GetMapping
    ResponseEntity<List<ProdutoDTO>>mostrar(){
        return ResponseEntity.ok(service.mostrar());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarProd(@PathVariable Long id, @RequestBody ProdutoDTO dto){
        return ResponseEntity.ok(service.editarProd(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable long id){
        return ResponseEntity.noContent().build();
    }
}
