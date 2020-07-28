package com.ithappens.apiVenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ithappens.apiVenda.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findById(long id);
}
