package com.ithappens.apiVenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ithappens.apiVenda.models.TipoPedido;

public interface TipoPedidoRepository extends JpaRepository<TipoPedido, Long>{
	
	TipoPedido findById(long id);
}
