package com.ithappens.apiVenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ithappens.apiVenda.models.Estoque;
import com.ithappens.apiVenda.models.Filial;

public interface EstoqueRepository extends JpaRepository<Estoque, Long>{
	
	Estoque findById(long id);
	
	Estoque findByFilial(Filial filial);
}
