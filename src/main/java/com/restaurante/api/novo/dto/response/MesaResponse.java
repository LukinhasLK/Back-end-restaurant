package com.restaurante.api.novo.dto.response;

import com.restaurante.api.novo.enuns.StatusMesa;

public record MesaResponse(
        Long id ,
        Integer numero,
        Integer capacidade,
        StatusMesa statusMesa
) {
}
