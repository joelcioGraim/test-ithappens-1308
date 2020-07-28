package com.ithappens.apiVenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ithappens.apiVenda.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	Produto findById(long id);
}
