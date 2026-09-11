package com.biolab.ecommercebiolab.DTOs;

import com.biolab.ecommercebiolab.entities.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

    private long id;
    @NotBlank
    private String nome;
    private String descricao;
    @NotNull
    private double preco;
    private String imgUrl;
    private long idCategoria;

    public ProdutoDTO(String nome, String descricao, double preco, String imgUrl) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imgUrl = imgUrl;
    }

    public ProdutoDTO(long id, String nome, Set<Produto> produtos) {
    }
}
