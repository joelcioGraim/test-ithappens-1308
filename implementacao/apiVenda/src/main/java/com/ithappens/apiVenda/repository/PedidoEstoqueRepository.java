package com.ithappens.apiVenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ithappens.apiVenda.models.PedidoEstoque;

public interface PedidoEstoqueRepository extends JpaRepository<PedidoEstoque, Long>{
	
	PedidoEstoque findById(long id);
}
