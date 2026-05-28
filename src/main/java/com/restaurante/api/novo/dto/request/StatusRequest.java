package com.restaurante.api.novo.dto.request;

import com.restaurante.api.novo.enuns.StatusPedidos;
import jakarta.validation.constraints.NotNull;

public record StatusRequest(
        @NotNull(message = "Status obrigatorio")
        StatusPedidos status
) {}