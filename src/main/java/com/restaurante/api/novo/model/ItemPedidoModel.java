package com.restaurante.api.novo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_item_pedidos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ItemPedidoModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pedidos_id", nullable = false)
    private PedidoModel pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private ProdutoModel produto;

    private Integer quantidade;
    private BigDecimal precounitario;
}


