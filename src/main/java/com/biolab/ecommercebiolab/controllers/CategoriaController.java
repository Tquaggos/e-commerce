package com.biolab.ecommercebiolab.controllers;

import com.biolab.ecommercebiolab.DTOs.CategoriaDTO;
import com.biolab.ecommercebiolab.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("categoria")
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
        }

    @PostMapping
    public ResponseEntity<?> criarCat(@RequestBody CategoriaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.criarCategoria(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarCat(@PathVariable long id) {
        return ResponseEntity.ok().body(service.buscarCatId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCat(@PathVariable long id){
        return ResponseEntity.noContent().build();
    }
}
