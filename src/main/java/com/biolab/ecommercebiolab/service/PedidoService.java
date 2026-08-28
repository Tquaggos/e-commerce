package com.biolab.ecommercebiolab.service;

import com.biolab.ecommercebiolab.DTOs.PedidoDTO;
import com.biolab.ecommercebiolab.Repositories.PedidoRepository;
import com.biolab.ecommercebiolab.Repositories.UsuarioRepository;
import com.biolab.ecommercebiolab.entities.Pedido;
import com.biolab.ecommercebiolab.entities.Usuario;
import com.biolab.ecommercebiolab.entities.enums.StatusPedido;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final UsuarioRepository usuarioRepository;

    public PedidoService(PedidoRepository pedidoRepository, UsuarioRepository usuarioRepository) {
        this.pedidoRepository = pedidoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public String criarPedido(PedidoDTO dto){
        Usuario u = usuarioRepository.findById(dto.getIdCliente())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrato"));
        Pedido p = new Pedido();
        p.setCliente(u);
        p.setMomento(Instant.now());
        p.setStatus(StatusPedido.AGUARDANDO_PAGAMENTO);
        pedidoRepository.save(p);
        return "Pedido criado com sucesso";
    }

    public String deleltarPedido(Long id){
        Pedido pedido = pedidoRepository.findById(id).orElseThrow();
        pedidoRepository.deleteById(id);
        return "Excluido com sucesso";
    }
}
