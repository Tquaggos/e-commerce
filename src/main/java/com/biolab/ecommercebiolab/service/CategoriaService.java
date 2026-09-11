package com.biolab.ecommercebiolab.service;

import com.biolab.ecommercebiolab.DTOs.CategoriaDTO;
import com.biolab.ecommercebiolab.Repositories.CategoriaRepository;
import com.biolab.ecommercebiolab.entities.Categoria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public String criarCategoria(CategoriaDTO dto){
        Categoria categoria = new Categoria();
        categoria.setNome(dto.getNome());
        categoriaRepository.save(categoria);
        return "Categoria Criada com Sucesso!!!";
    }

    public CategoriaDTO buscarCatId(long id){
        Categoria categoria = categoriaRepository.findById(id).orElseThrow();
        CategoriaDTO dto = new CategoriaDTO();
        dto.setId(categoria.getId());
        dto.setNome(categoria.getNome());
        return dto;
    }

    public String delete(long id){
        categoriaRepository.deleteById(id);
        return "Excluido com sucesso!!";
    }

    public List<Categoria> buscarCat(){
        List<Categoria> categorias = categoriaRepository.findAll();

        return categorias;
    }
}
