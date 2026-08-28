package com.biolab.ecommercebiolab.Repositories;

import com.biolab.ecommercebiolab.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
