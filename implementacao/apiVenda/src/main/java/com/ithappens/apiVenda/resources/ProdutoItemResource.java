package com.ithappens.apiVenda.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ithappens.apiVenda.models.ProdutoItem;
import com.ithappens.apiVenda.repository.ProdutoItemRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST de Venda e Controle de Estoque") // Config Swagger
@CrossOrigin(origins = "*") // Config Swagger - "*" indica que qualquer domínio pode acessar.
public class ProdutoItemResource {

	@Autowired
	ProdutoItemRepository produtoItemRepository;
	
	@GetMapping("/produtosItem")
	@ApiOperation(value = "Método responsável em trazer todos os ProdutosItem em uma lista.")
	public List<ProdutoItem> getLista(){
		return produtoItemRepository.findAll();
	}
	
	@GetMapping("/produtoItem/{id}")
	@ApiOperation(value = "Método responsável em trazer um ProdutoItem específico atravez de seu ID.")
	public ProdutoItem getId(@PathVariable(value = "id") long id){
		return produtoItemRepository.findById(id);
	}
	
    /*@PostMapping("/produtoItem")
	@ApiOperation(value = "Método responsável em fazer a inserção de um novo ProdutoItem na base de dados.")
	public ProdutoItem salvar(@RequestBody ProdutoItem produtoItem){
		return produtoItemRepository.save(produtoItem);
	}*/
	
	@PutMapping("/produtoItem")
	@ApiOperation(value = "Método responsável em atualizar um ProdutoItem específico na base de dados.")
	public ProdutoItem atualizar(@RequestBody ProdutoItem produtoItem){
		return produtoItemRepository.save(produtoItem);
	}
	
	/*@DeleteMapping("/produtoItem")
	@ApiOperation(value = "Método responsável em deletar um ProdutoItem na base de dados.")
	public void deletar(@RequestBody ProdutoItem produtoItem){
		produtoItemRepository.delete(produtoItem);
	}*/
}
