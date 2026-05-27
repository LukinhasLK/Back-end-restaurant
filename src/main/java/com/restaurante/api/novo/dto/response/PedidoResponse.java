package com.restaurante.api.novo.dto.response;

import com.restaurante.api.novo.enuns.StatusPedidos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PedidoResponse(
        Long id,
        Integer numeromesa,
        String nomeatendente,
        StatusPedidos statusPedidos,
        BigDecimal valortotal,
        LocalDateTime data

        ) {
}
