package com.biolab.ecommercebiolab.service;

import com.biolab.ecommercebiolab.DTOs.PagamentoDTO;
import com.biolab.ecommercebiolab.Repositories.PagamentoRepository;
import com.biolab.ecommercebiolab.Repositories.PedidoRepository;
import com.biolab.ecommercebiolab.entities.Pagamento;
import com.biolab.ecommercebiolab.entities.Pedido;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class PagamentoService {
    private final PedidoRepository pedidoRepository;
    private final PagamentoRepository pagamentoRepository;
    public PagamentoService(PedidoRepository pedidoRepository, PagamentoRepository pagamentoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.pagamentoRepository = pagamentoRepository;
    }

    public String criarPagamento(PagamentoDTO dto){
        Pedido p = pedidoRepository.findById(dto.getIdPedido()).orElseThrow();
        Pagamento pagamento = new Pagamento();
        pagamento.setMomento(Instant.now());
        pagamento.setPedido(p);
        pagamentoRepository.save(pagamento);
        return "Pagamento Realizado com sucesso";
    }

}
