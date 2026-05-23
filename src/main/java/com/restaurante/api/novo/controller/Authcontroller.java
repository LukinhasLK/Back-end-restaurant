package com.restaurante.api.novo.controller;

import com.restaurante.api.novo.dto.request.RegistroRequest;
import com.restaurante.api.novo.dto.response.UsuarioResponse;
import com.restaurante.api.novo.mapper.Usuariomapper;
import com.restaurante.api.novo.model.UsuarioModel;
import com.restaurante.api.novo.service.UsuarioServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class Authcontroller {

    private final UsuarioServices services;
    private final Usuariomapper mapper;

    public Authcontroller(UsuarioServices services, Usuariomapper mapper) {
        this.services = services;
        this.mapper = mapper;
    }

    @GetMapping("/list")
    public ResponseEntity<List<UsuarioResponse>>lista(){

         List<UsuarioModel> usuario= services.listaUsuario();

        return ResponseEntity.ok(mapper.listResponse(usuario));
    }
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse>Userid(@PathVariable Long id){

        UsuarioModel usuario = services.buscarporId(id);

        return ResponseEntity.ok(mapper.toResponse(usuario));
    }

    @PostMapping("/cadastro")
    public ResponseEntity<UsuarioResponse>cadastrar(@Valid @RequestBody RegistroRequest dto){
        UsuarioModel usuario = services.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(usuario));
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<UsuarioResponse>alterar(@PathVariable Long id,@Valid @RequestBody RegistroRequest dto){

        UsuarioModel usuario = services.alterar(id,dto);

        return ResponseEntity.ok(mapper.toResponse(usuario));
    }

    @PatchMapping("/desativar/{id}")
    public ResponseEntity<UsuarioResponse>desativar(@PathVariable Long id ){

        UsuarioModel usuario = services.desativarUsuario(id);

        return ResponseEntity.ok(mapper.toResponse(usuario));
    }

    @PatchMapping("/{id}/ativar")
    public ResponseEntity<UsuarioResponse>ativar(@PathVariable Long id ){

        UsuarioModel usuario = services.ativarUsuario(id);

        return ResponseEntity.ok(mapper.toResponse(usuario));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void>deletarUser(@PathVariable Long id){

         services.deletar(id);

      return ResponseEntity
              .noContent()
              .build();
    }


}
