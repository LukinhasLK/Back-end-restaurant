package com.restaurante.api.novo.dto.request;

import com.restaurante.api.novo.enuns.TipoProduto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


import java.math.BigDecimal;

public record ProdutoRequest(

        @NotBlank(message = "Nome do Produto e Obrigatorio")
        String nome,

        @NotBlank(message = "Descricao do produto e obrigatorio")
        String descricao,

        @NotNull(message = "O Tipo do Produto e obrigatorio")
        TipoProduto tipoProduto,

        @NotNull(message = "O preco do produto e obrigatorio")
        @Positive(message = "O preso precisa ser positivo  maior que zero")
        BigDecimal preco

        ) {
}