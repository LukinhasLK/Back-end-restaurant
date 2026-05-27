package com.restaurante.api.novo.mapper;

import com.restaurante.api.novo.dto.response.PedidoResponse;
import com.restaurante.api.novo.model.PedidoModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Pedidomapper {

    public PedidoResponse toResponse(PedidoModel pedido) {
        return new PedidoResponse(
                pedido.getId(),
                pedido.getMesaModel().getNumero(),
                pedido.getAtendente().getNome(),
                pedido.getStatusPedido(),
                pedido.getValortotal(),
                pedido.getData()
        );
    }

    public List<PedidoResponse>toResponseList(List<PedidoModel>pedido){

        return pedido.stream()
                .map(this::toResponse)
                .toList();
    }
}
