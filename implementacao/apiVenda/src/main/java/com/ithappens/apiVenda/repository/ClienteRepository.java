package com.ithappens.apiVenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ithappens.apiVenda.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	Cliente findById(long id);
}
