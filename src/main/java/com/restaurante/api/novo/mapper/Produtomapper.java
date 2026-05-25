package com.restaurante.api.novo.mapper;

import com.restaurante.api.novo.dto.response.ProdutoResponse;
import com.restaurante.api.novo.model.ProdutoModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Produtomapper {

    public ProdutoResponse toResponse(ProdutoModel produto) {


        return new ProdutoResponse(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getTipoProduto(),
                produto.isDisponivel(),
                produto.getPreco()
        );

    }

    public List<ProdutoResponse> listResponse(List<ProdutoModel> produto) {

        return produto.stream()
                .map(this::toResponse)
                .toList();
    }
}
