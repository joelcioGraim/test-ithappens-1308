package com.ithappens.apiVenda.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ithappens.apiVenda.models.Estoque;
import com.ithappens.apiVenda.repository.EstoqueRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST de Venda e Controle de Estoque") // Config Swagger
@CrossOrigin(origins = "*") // Config Swagger - "*" indica que qualquer domínio pode acessar.
public class EstoqueResource {

	@Autowired
	EstoqueRepository estoqueRepository;
		
	@GetMapping("/estoques")
	@ApiOperation(value = "Método responsável em trazer todos os Estoques em uma lista.")
	public List<Estoque> getLista(){
		return estoqueRepository.findAll();
	}
		
	@GetMapping("/estoque/{id}")
	@ApiOperation(value = "Método responsável em trazer um Estoque específico atravez de seu ID.")
	public Estoque getId(@PathVariable(value = "id") long id){
		return estoqueRepository.findById(id);
	}
	
	@PostMapping("/estoque")
	@ApiOperation(value = "Método responsável em fazer a inserção de um novo Estoque na base de dados.")
	public Estoque salvar(@RequestBody Estoque estoque){
		return estoqueRepository.save(estoque);
	}
	
	@PutMapping("/estoque")
	@ApiOperation(value = "Método responsável em atualizar um Estoque específico na base de dados.")
	public Estoque atualizar(@RequestBody Estoque estoque){
		return estoqueRepository.save(estoque);
	}
	
	@DeleteMapping("/estoque")
	@ApiOperation(value = "Método responsável em deletar um Estoque na base de dados.")
	public void deletar(@RequestBody Estoque estoque){
		estoqueRepository.delete(estoque);
	}
}
