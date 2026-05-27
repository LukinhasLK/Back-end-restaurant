package com.restaurante.api.novo.controller;

import com.restaurante.api.novo.dto.request.MesaRequest;
import com.restaurante.api.novo.dto.response.MesaResponse;
import com.restaurante.api.novo.mapper.Mesamapper;
import com.restaurante.api.novo.model.MesaModel;
import com.restaurante.api.novo.service.MesaServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesa")
public class Mesacontroller {

    private final MesaServices services;
    private final Mesamapper mapper;

    public Mesacontroller(MesaServices services, Mesamapper mapper) {
        this.services = services;
        this.mapper = mapper;
    }

    @GetMapping("/list")
    public ResponseEntity<List<MesaResponse>> list() {

        List<MesaModel> mesa = services.list();

        return ResponseEntity.ok(mapper.toResponselist(mesa));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MesaResponse> mesaId(@PathVariable Long id) {

        MesaModel mesa = services.mesaByid(id);

        return ResponseEntity.ok(mapper.toResponse(mesa));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<MesaResponse> cadastrar(@Valid @RequestBody MesaRequest dto) {

        MesaModel mesa = services.cadastrar(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(mesa));
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<MesaResponse> alterar(@PathVariable Long id,@Valid  @RequestBody MesaRequest dto) {

        MesaModel mesa = services.alterar(id, dto);

        return ResponseEntity.ok(mapper.toResponse(mesa));
    }

    @PatchMapping("/{id}/livre")
    public ResponseEntity<MesaResponse> livre(@PathVariable Long id) {

        MesaModel mesa = services.livre(id);

        return ResponseEntity.ok(mapper.toResponse(mesa));
    }

    @PatchMapping("/{id}/ocupado")
    public ResponseEntity<MesaResponse> ocupado(@PathVariable Long id) {

        MesaModel mesa = services.ocupado(id);

        return ResponseEntity.ok(mapper.toResponse(mesa));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        services.deletar(id);

        return ResponseEntity.noContent().build();
    }

}
