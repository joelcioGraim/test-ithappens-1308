package com.ithappens.apiVenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ithappens.apiVenda.models.ProdutoItem;

public interface ProdutoItemRepository extends JpaRepository<ProdutoItem, Long>{
	
	ProdutoItem findById(long id);
}
