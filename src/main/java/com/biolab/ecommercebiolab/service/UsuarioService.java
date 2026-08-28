package com.biolab.ecommercebiolab.service;

import com.biolab.ecommercebiolab.DTOs.UsuarioDTO;
import com.biolab.ecommercebiolab.Repositories.UsuarioRepository;
import com.biolab.ecommercebiolab.entities.Usuario;
import com.biolab.ecommercebiolab.entities.enums.Role;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    public String criar(UsuarioDTO u){
        Usuario usuario = new Usuario();
        usuario.setEmail(u.getEmail());
        usuario.setNome(u.getNome());
        usuario.setSenha(u.getSenha());
        usuario.setTelefone(u.getTelefone());
        usuario.setRole(Role.USER);
        repo.save(usuario);
        return "Usuario criado com sucesso!!!";

    }
}
