package com.restaurante.api.novo.controller;

import com.restaurante.api.novo.dto.request.ProdutoRequest;
import com.restaurante.api.novo.dto.response.ProdutoResponse;
import com.restaurante.api.novo.mapper.Produtomapper;
import com.restaurante.api.novo.model.ProdutoModel;
import com.restaurante.api.novo.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class Produtocontroller {

    private final ProdutoService service;
    private final Produtomapper mapper;

    public Produtocontroller(ProdutoService service, Produtomapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProdutoResponse>> list() {

        List<ProdutoModel> Produto = service.list();

        return ResponseEntity.ok(mapper.listResponse(Produto));
    }

    @GetMapping("/{id}")

    public ResponseEntity<ProdutoResponse> produtoId(@PathVariable Long id) {

        ProdutoModel produto = service.produtoId(id);

        return ResponseEntity.ok(mapper.toResponse(produto));
    }

    @PostMapping("/cadastrar")

    public ResponseEntity<ProdutoResponse> cadastrar(@Valid @RequestBody ProdutoRequest dto) {

        ProdutoModel produto = service.cadastrar(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(produto));
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<ProdutoResponse> alterar(@PathVariable Long id, @Valid @RequestBody ProdutoRequest dto) {
        ProdutoModel produto = service.alterar(id, dto);

        return ResponseEntity.ok(mapper.toResponse(produto));
    }

    @PatchMapping("/{id}/disponivel")

    public ResponseEntity<ProdutoResponse> disponivel(@PathVariable Long id) {
        ProdutoModel produto = service.disponivel(id);

        return ResponseEntity.ok(mapper.toResponse(produto));
    }

    @PatchMapping("/{id}/indisponivel")
    public ResponseEntity<ProdutoResponse> indisponivel(@PathVariable Long id) {

        ProdutoModel produto = service.indisponivel(id);

        return ResponseEntity.ok(mapper.toResponse(produto));
    }

    @DeleteMapping("/deletar/{id}")

    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        service.deletar(id);

        return ResponseEntity.noContent().build();
    }


}
