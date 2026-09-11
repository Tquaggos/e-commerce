package com.biolab.ecommercebiolab.service;

import com.biolab.ecommercebiolab.DTOs.ProdutoDTO;
import com.biolab.ecommercebiolab.Repositories.CategoriaRepository;
import com.biolab.ecommercebiolab.Repositories.ProdutoRepository;
import com.biolab.ecommercebiolab.entities.Categoria;
import com.biolab.ecommercebiolab.entities.Produto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public String criar(ProdutoDTO dto){
        Produto p = new Produto();
        p.setNome(dto.getNome());
        p.setDescricao(dto.getDescricao());
        p.setPreco(dto.getPreco());
        p.setImgUrl(dto.getImgUrl());

        Categoria cat = categoriaRepository.getReferenceById(dto.getIdCategoria());
        p.getCategorias().add(cat);
        return "Produto salvo com sucesso";
    }

    public List<ProdutoDTO> mostrar(){
        return produtoRepository.findAll().stream().map(produto -> new
                ProdutoDTO(produto.getId(), produto.getNome(),
                produto.getProdutos())). toList();
    }

}
