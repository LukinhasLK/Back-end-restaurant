package com.restaurante.api.novo.dto.request;

import jakarta.validation.constraints.NotNull;

public record PedidoRequest(
        @NotNull(message = "Mesa obrigatoria")
        Long mesaId,

        @NotNull(message = "atendente e Obrigatorio")
        Long atendenteId) {
}
