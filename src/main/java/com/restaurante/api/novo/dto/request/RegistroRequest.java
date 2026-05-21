package com.restaurante.api.novo.dto.request;

import com.restaurante.api.novo.enuns.TipoUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegistroRequest(

        @NotBlank(message = "Nome Obrigatorio")
        String nome,

        @Email(message = "Email invalido")
        @NotBlank(message = "Email obrigatorio")
        String email,

        @NotBlank(message = "Senha obrigatoria")
        String senha,

        @NotBlank(message = "Tipo de usuario e obrigatorio")
        TipoUsuario tipoUsuario

) {
}
