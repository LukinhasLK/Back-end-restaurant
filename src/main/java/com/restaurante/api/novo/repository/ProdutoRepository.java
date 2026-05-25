package com.restaurante.api.novo.repository;

import com.restaurante.api.novo.model.ProdutoModel;
import com.restaurante.api.novo.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoModel,Long> {
}
