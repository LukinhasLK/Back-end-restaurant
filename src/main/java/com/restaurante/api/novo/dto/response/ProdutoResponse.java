package com.restaurante.api.novo.dto.response;

import com.restaurante.api.novo.enuns.TipoProduto;

import java.math.BigDecimal;

public record ProdutoResponse(
        Long id ,
        String nome,
        String descricao,
        TipoProduto tipoProduto,
        boolean disponivel,
        BigDecimal preco
) {
}
