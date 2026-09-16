package com.biolab.ecommercebiolab.Repositories;

import com.biolab.ecommercebiolab.entities.Categoria;
import com.biolab.ecommercebiolab.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
