package com.ithappens.apiVenda.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ithappens.apiVenda.models.Produto;
import com.ithappens.apiVenda.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST de Venda e Controle de Estoque") // Config Swagger
@CrossOrigin(origins = "*") // Config Swagger - "*" indica que qualquer domínio pode acessar.
public class ProdutoResource {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	@ApiOperation(value = "Método responsável em trazer todos os Produtos em uma lista.")
	public List<Produto> getLista(){
		return produtoRepository.findAll();
	}
	
	@GetMapping("/produto/{id}")
	@ApiOperation(value = "Método responsável em trazer um Produto específico atravez de seu ID.")
	public Produto getId(@PathVariable(value = "id") long id){
		return produtoRepository.findById(id);
	}
	
	/*@PostMapping("/produto")
	@ApiOperation(value = "Método responsável em fazer a inserção de um novo Produto na base de dados.")
	public Produto salvar(@RequestBody Produto produto){
		return produtoRepository.save(produto);
	}*/
	
	@PutMapping("/produto")
	@ApiOperation(value = "Método responsável em atualizar um Produto específico na base de dados.")
	public Produto atualizar(@RequestBody Produto produto){
		return produtoRepository.save(produto);
	}
	
	@DeleteMapping("/produto")
	@ApiOperation(value = "Método responsável em deletar um Produto na base de dados.")
	public void deletar(@RequestBody Produto produto){
		produtoRepository.delete(produto);
	}
}
