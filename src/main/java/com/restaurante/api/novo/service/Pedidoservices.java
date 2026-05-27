package com.restaurante.api.novo.service;

import com.restaurante.api.novo.dto.request.PedidoRequest;
import com.restaurante.api.novo.enuns.StatusMesa;
import com.restaurante.api.novo.enuns.StatusPedidos;
import com.restaurante.api.novo.model.MesaModel;
import com.restaurante.api.novo.model.PedidoModel;
import com.restaurante.api.novo.model.UsuarioModel;
import com.restaurante.api.novo.repository.MesaRepository;
import com.restaurante.api.novo.repository.PedidoRepository;
import com.restaurante.api.novo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class Pedidoservices {

    private final PedidoRepository pedidoRepository;
    private final MesaRepository mesaRepository;
    private final UsuarioRepository usuarioRepository;

    public Pedidoservices(PedidoRepository pedidoRepository, MesaRepository mesaRepository, UsuarioRepository usuarioRepository) {
        this.pedidoRepository = pedidoRepository;
        this.mesaRepository = mesaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<PedidoModel> list() {

        return pedidoRepository.findAll();
    }

    public PedidoModel findById(Long id) {

        return pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido nao encontrado"));
    }

    public PedidoModel cadastrar(PedidoRequest dto) {

        MesaModel mesa = mesaRepository.findById(dto.mesaId()).orElseThrow(() -> new RuntimeException("mesa nao encontrada"));

        UsuarioModel atendente = usuarioRepository.findById(dto.atendenteId()).orElseThrow(() -> new RuntimeException("Atendente nao encontrado"));

        PedidoModel pedido = new PedidoModel();

        pedido.setMesaModel(mesa);
        pedido.setAtendente(atendente);
        pedido.setStatusPedido(StatusPedidos.EM_ANDAMENTO);
        pedido.setValortotal(BigDecimal.ZERO);

        mesa.setStatusMesa(StatusMesa.OCUPADO);
        mesaRepository.save(mesa);

        return pedidoRepository.save(pedido);

    }

    public PedidoModel alterar(Long id, StatusPedidos status) {

        PedidoModel pedido = pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("pedido nao encontrado"));

        pedido.setStatusPedido(status);

        return pedidoRepository.save(pedido);


    }

    public void deletar(Long id) {

        pedidoRepository.findById(id)
                        .orElseThrow(()-> new RuntimeException("Pedido nao encontrado"));

        pedidoRepository.deleteById(id);
    }
}
