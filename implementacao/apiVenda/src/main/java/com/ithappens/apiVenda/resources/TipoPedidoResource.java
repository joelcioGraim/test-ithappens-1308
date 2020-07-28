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

import com.ithappens.apiVenda.models.TipoPedido;
import com.ithappens.apiVenda.repository.TipoPedidoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST de Venda e Controle de Tipo de Pedido") // Config Swagger
@CrossOrigin(origins = "*") // Config Swagger - "*" indica que qualquer domínio pode acessar.
public class TipoPedidoResource {

	@Autowired
	TipoPedidoRepository tipoPedidoRepository;
		
	@GetMapping("/tiposPedido")
	@ApiOperation(value = "Método responsável em trazer todos os Tipos de Pedido em uma lista.")
	public List<TipoPedido> getLista(){
		return tipoPedidoRepository.findAll();
	}
	
	@GetMapping("/tipoPedido/{id}")
	@ApiOperation(value = "Método responsável em trazer um Tipo de Pedido específico atravez de seu ID.")
	public TipoPedido getId(@PathVariable(value = "id") long id){
		return tipoPedidoRepository.findById(id);
	}
	
	@PostMapping("/tipoPedido")
	@ApiOperation(value = "Método responsável em fazer a inserção de um novo Tipo de Pedido na base de dados.")
	public TipoPedido salvar(@RequestBody TipoPedido tipoPedido){
		return tipoPedidoRepository.save(tipoPedido);
	}
	
	@PutMapping("/tipoPedido")
	@ApiOperation(value = "Método responsável em atualizar um Tipo de Pedido específico na base de dados.")
	public TipoPedido atualizar(@RequestBody TipoPedido tipoPedido){
		return tipoPedidoRepository.save(tipoPedido);
	}
	
	@DeleteMapping("/tipoPedido")
	@ApiOperation(value = "Método responsável em deletar um Tipo de Pedido na base de dados.")
	public void deletar(@RequestBody TipoPedido tipoPedido){
		tipoPedidoRepository.delete(tipoPedido);
	}
}
