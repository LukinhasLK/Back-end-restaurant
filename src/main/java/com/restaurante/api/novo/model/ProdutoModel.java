package com.restaurante.api.novo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_produtos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProdutoModel {
    

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @OneToMany(mappedBy = "produto")
        private List<ItemPedidosModel> itemPedidos = new ArrayList<>();

        @Column(nullable = false)
        private String nome;

        @Column(nullable = false)
        private String descricao;

        @Column(nullable = false)
        @Enumerated(EnumType.STRING)
        private TipoProduto tipoProduto;

        @Column(nullable = false)
        private boolean disponivel;

        @Column(nullable = false)
        private BigDecimal preco;


    }

