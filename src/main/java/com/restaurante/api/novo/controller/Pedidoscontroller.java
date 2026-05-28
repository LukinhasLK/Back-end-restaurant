package com.restaurante.api.novo.controller;

import com.restaurante.api.novo.dto.request.PedidoRequest;
import com.restaurante.api.novo.dto.request.StatusRequest;
import com.restaurante.api.novo.dto.response.PedidoResponse;
import com.restaurante.api.novo.mapper.Pedidomapper;
import com.restaurante.api.novo.model.PedidoModel;
import com.restaurante.api.novo.service.Pedidoservices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class Pedidoscontroller {

    private final Pedidoservices services;
    private final Pedidomapper mapper;

    public Pedidoscontroller(Pedidoservices services, Pedidomapper mapper) {
        this.services = services;
        this.mapper = mapper;
    }

    @GetMapping("/list")
    public ResponseEntity<List<PedidoResponse>> list() {

        List<PedidoModel> pedido = services.list();

        return ResponseEntity.ok(mapper.toResponseList(pedido));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponse> pedidoById(@PathVariable Long id) {

        PedidoModel pedido = services.findById(id);

        return ResponseEntity.ok(mapper.toResponse(pedido));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<PedidoResponse> cadastrar(@Valid @RequestBody PedidoRequest dto) {

        PedidoModel pedido = services.cadastrar(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(pedido));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<PedidoResponse> alterar(@PathVariable Long id, @Valid @RequestBody StatusRequest dto) {

        PedidoModel pedido = services.alterar(id, dto.status());

        return ResponseEntity.ok(mapper.toResponse(pedido));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        services.deletar(id);

        return ResponseEntity.noContent()
                .build();
    }
}
