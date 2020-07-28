package com.ithappens.apiVenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ithappens.apiVenda.models.Filial;

public interface FilialRepository extends JpaRepository<Filial, Long>{
	
	Filial findById(long id);
}
