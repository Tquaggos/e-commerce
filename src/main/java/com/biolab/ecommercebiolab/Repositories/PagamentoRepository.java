package com.biolab.ecommercebiolab.Repositories;

import com.biolab.ecommercebiolab.entities.Pedido;
import com.biolab.ecommercebiolab.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
