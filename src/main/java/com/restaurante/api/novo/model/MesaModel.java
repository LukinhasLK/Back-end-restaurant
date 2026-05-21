package com.restaurante.api.novo.model;

import com.restaurante.api.novo.enuns.StatusMesa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_mesa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class MesaModel {




        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @OneToMany(mappedBy = "mesaModel")
        List<PedidoModel> pedidos = new ArrayList<>();

        @Column(nullable = false)
        private Integer numero;

        @Column(nullable = false)
        private Integer capacidade;

        @Column(nullable = false)
        @Enumerated(EnumType.STRING)
        private StatusMesa statusMesa;

    }


