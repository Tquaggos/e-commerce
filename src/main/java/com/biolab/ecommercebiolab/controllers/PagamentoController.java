package com.biolab.ecommercebiolab.controllers;

import com.biolab.ecommercebiolab.DTOs.PagamentoDTO;
import com.biolab.ecommercebiolab.service.PagamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pagamento")
public class PagamentoController {

    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @PostMapping
    public ResponseEntity<?> savePayment(@RequestBody PagamentoDTO dto){

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(pagamentoService.criarPagamento(dto));
    }

    @DeleteMapping
    public ResponseEntity<?> delOrder(@PathVariable long id){
        return ResponseEntity.ok("Apagado com sucesso!!");
    }
}
