package com.restaurante.api.novo.mapper;

import com.restaurante.api.novo.dto.response.UsuarioResponse;
import com.restaurante.api.novo.model.UsuarioModel;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class Usuariomapper {

    public UsuarioResponse toResponse(UsuarioModel usuario){

        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTipoUsuario()
        );
    }

    public List<UsuarioResponse> listResponse(List<UsuarioModel>usuario){

        return usuario.stream()
                .map(this::toResponse)
                .toList();
    }
}
