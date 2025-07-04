package com.desafionttdata.microservicos.produtos.repository;

import com.desafionttdata.microservicos.produtos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
