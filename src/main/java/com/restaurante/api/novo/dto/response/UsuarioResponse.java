package com.restaurante.api.novo.dto.response;

import com.restaurante.api.novo.enuns.TipoUsuario;

public record UsuarioResponse(
        Long id ,
        String nome,
        String email,
        TipoUsuario tipoUsuario

) {
}
