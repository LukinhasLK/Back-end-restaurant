package com.restaurante.api.novo.service;

import com.restaurante.api.novo.dto.request.ProdutoRequest;
import com.restaurante.api.novo.model.ProdutoModel;
import com.restaurante.api.novo.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<ProdutoModel> list() {

        return repository.findAll();
    }

    public ProdutoModel produtoId(Long id) {


        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public ProdutoModel cadastrar(ProdutoRequest dto) {

        ProdutoModel produto = new ProdutoModel();

        produto.setNome(dto.nome());
        produto.setDescricao(dto.descricao());
        produto.setTipoProduto(dto.tipoProduto());
        produto.setDisponivel(true);
        produto.setPreco(dto.preco());

        return repository.save(produto);
    }

    public ProdutoModel alterar(Long id, ProdutoRequest dto) {

        ProdutoModel produto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto nao encontrado"));

        produto.setNome(dto.nome());
        produto.setDescricao(dto.descricao());
        produto.setTipoProduto(dto.tipoProduto());
        produto.setPreco(dto.preco());

        return repository.save(produto);

    }

    public ProdutoModel disponivel(Long id) {

        ProdutoModel produto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto nao encontrado"));

        produto.setDisponivel(true);

        return repository.save(produto);


    }

    public ProdutoModel indisponivel(Long id) {

        ProdutoModel produto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto nao encontrado"));

        produto.setDisponivel(false);

        return repository.save(produto);
    }

    public ProdutoModel deletar(Long id) {

        ProdutoModel produto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto nao encontrado"));

        repository.delete(produto);


        return produto;
    }
}
