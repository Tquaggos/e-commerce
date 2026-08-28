package com.biolab.ecommercebiolab.controllers;

import com.biolab.ecommercebiolab.DTOs.UsuarioDTO;
import com.biolab.ecommercebiolab.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody UsuarioDTO dto){
        return ResponseEntity.ok(service.criar(dto));
    }
}
