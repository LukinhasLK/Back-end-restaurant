package com.restaurante.api.novo.dto.request;

import com.restaurante.api.novo.enuns.StatusMesa;
import jakarta.validation.constraints.NotNull;

public record MesaRequest(

        @NotNull(message = "numero da mesa obrigatorio")
        Integer numero,

        @NotNull(message = "E necessario colocar a capacidade de pessoas")
        Integer capacidade


        ) {
}
