package com.biolab.ecommercebiolab.DTOs;

import com.biolab.ecommercebiolab.entities.Pagamento;
import com.biolab.ecommercebiolab.entities.Pedido;
import jakarta.persistence.CascadeType;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoDTO {

    private long id;
    private Instant momento;
    private long idPedido;

    public PagamentoDTO(long idPedido) {
        this.idPedido = idPedido;
        this.momento = Instant.now();
    }
}
