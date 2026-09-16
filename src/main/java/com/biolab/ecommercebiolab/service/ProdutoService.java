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
        produtoRepository.save(p);
        return "Produto salvo com sucesso";
    }

    public List<ProdutoDTO> mostrar(){
        return produtoRepository.findAll().stream().map(produto -> new ProdutoDTO(
                produto.getId(), produto.getNome(),
                produto.getDescricao(), produto.getPreco())).toList();
    }

    public String delete(long id){
        produtoRepository.deleteById(id);
        return "Produto excluido com sucesso!!!";

    }

    public String editarProd(Long id, ProdutoDTO dto){
        Produto editarProd = produtoRepository.findById(id).orElseThrow();
        editarProd.setNome(dto.getNome());
        editarProd.setDescricao(dto.getDescricao());
        editarProd.setPreco(dto.getPreco());
        editarProd.setImgUrl(dto.getImgUrl());
        produtoRepository.save(editarProd);
        return "Editado com sucesso!!";
    }


}
