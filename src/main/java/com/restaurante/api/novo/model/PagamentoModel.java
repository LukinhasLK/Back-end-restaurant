package com.restaurante.api.novo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Entity
@Table(name = "tb_pagamentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class PagamentoModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "pedidos_id")
    private PedidoModel pedido;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TiposPagamentos tiposPagamentos;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime dataPagamento;

    @Enumerated(EnumType.STRING)
    private Statuspagamento statuspagamento;
}

