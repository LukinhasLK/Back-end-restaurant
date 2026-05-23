package com.restaurante.api.novo.model;


import com.restaurante.api.novo.enuns.StatusPedidos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_pedidos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "mesa_id", nullable = false)
    private MesaModel mesaModel;

    @ManyToOne
    @JoinColumn(name = "usuarios_id",nullable = false)
    private UsuarioModel atendente ;

    @OneToOne(mappedBy = "pedido")
    private PagamentoModel pagamentoModel;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedidoModel> itemPedidos = new ArrayList<>();

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusPedidos statusPedido;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime data;

    @Column(nullable = false)
    private BigDecimal valortotal;
}

