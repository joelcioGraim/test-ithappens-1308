package com.ithappens.apiVenda.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ithappens.apiVenda.models.ItensPedido;
import com.ithappens.apiVenda.models.ProdutoItem;
import com.ithappens.apiVenda.repository.ItensPedidoRepository;
import com.ithappens.apiVenda.repository.ProdutoItemRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST de Venda e Controle de Item de Pedido") // Config Swagger
@CrossOrigin(origins = "*") // Config Swagger - "*" indica que qualquer domínio pode acessar.
public class ItensPedidoResource {

	@Autowired
	ItensPedidoRepository itensPedidoRepository;
	@Autowired
	ProdutoItemRepository produtoItemRepository;
		
	@GetMapping("/itensPedido")
	@ApiOperation(value = "Método responsável em trazer todos os Itens de Pedido em uma lista.")
	public List<ItensPedido> getLista(){
		return itensPedidoRepository.findAll();
	}
	
	@GetMapping("/itensPedido/{id}")
	@ApiOperation(value = "Método responsável em trazer um Item de Pedido específico atravez de seu ID.")
	public ItensPedido getId(@PathVariable(value = "id") long id){
		return itensPedidoRepository.findById(id);
	}
	
	@PostMapping("/addItensPedido")
	@ApiOperation(value = "Método responsável em fazer a inserção de um novo Item de Pedido na base de dados. "
			+ "OBS: É obrigatório informar o Pedido de Estoque criado, bem como, "
			+ "informar uma categoria existente em estoque da filial.")
	public ResponseEntity<ItensPedido> salvar(@RequestBody ItensPedido itensPedido){
		
		//1º. Seta o status para Ativo
		itensPedido.setStatus("Ativo");
		//2º. Calcula o valor total a partir da multiplicação da quantidade pelo valor unitário.
		itensPedido.setValorTotal(itensPedido.getQuantidade().multiply(itensPedido.getValorUnitario()));
		//3º. Guarda o ProdutoItem
		ProdutoItem pi = itensPedido.getProdutoItem();		
		//4º. Seta para nulo o ProdutoItem
		itensPedido.setProdutoItem(null);		
		//5º. Salva o Item do Pedido sem o ProdutoItem
		itensPedidoRepository.save(itensPedido);		
		//6º. Referencia o item do pedido criado		
		pi.setItensPedido(itensPedido);
		//7º. Salva o ProdutoItem
		produtoItemRepository.save(pi);
		
		//8º. Atualiza o item do pedido inserindo o produtoItem
		return ResponseEntity.ok(itensPedido);		
	}
	
	@PutMapping("/itensPedido")
	@ApiOperation(value = "Método responsável em atualizar um Item de Pedido específico na base de dados.")
	public ItensPedido atualizar(@RequestBody ItensPedido itensPedido){
		return itensPedidoRepository.save(itensPedido);
	}
		
}
