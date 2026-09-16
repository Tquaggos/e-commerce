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
        categoriaRepository.save(categoria);
        return dto;
    }

    public String delete(long id){
        categoriaRepository.deleteById(id);
        return "Excluido com sucesso!!";
    }


    public String editarCat(Long id, CategoriaDTO dto){
        Categoria editarCat = categoriaRepository.findById(id).orElseThrow();
        editarCat.setNome(dto.getNome());
        categoriaRepository.save(editarCat);
        return "Alterado com sucesso!!!";
    }


}
