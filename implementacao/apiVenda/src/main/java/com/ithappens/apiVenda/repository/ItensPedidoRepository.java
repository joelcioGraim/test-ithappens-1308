package com.ithappens.apiVenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ithappens.apiVenda.models.ItensPedido;

public interface ItensPedidoRepository extends JpaRepository<ItensPedido, Long>{
	
	ItensPedido findById(long id);
}
