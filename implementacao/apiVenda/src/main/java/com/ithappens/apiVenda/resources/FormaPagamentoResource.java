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

import com.ithappens.apiVenda.models.FormaPagamento;
import com.ithappens.apiVenda.repository.FormaPagamentoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST de Venda e Controle de Forma de Pagamento") // Config Swagger
@CrossOrigin(origins = "*") // Config Swagger - "*" indica que qualquer domínio pode acessar.
public class FormaPagamentoResource {

	@Autowired
	FormaPagamentoRepository formaPagamentoRepository;
		
	@GetMapping("/formasPagamento")
	@ApiOperation(value = "Método responsável em trazer todas as Formas de Pagamento em uma lista.")
	public List<FormaPagamento> getLista(){
		return formaPagamentoRepository.findAll();
	}
	
	@GetMapping("/formaPagamento/{id}")
	@ApiOperation(value = "Método responsável em trazer uma Forma de Pagamento específica atravez de seu ID.")
	public FormaPagamento getId(@PathVariable(value = "id") long id){
		return formaPagamentoRepository.findById(id);
	}
	
	@PostMapping("/formaPagamento")
	@ApiOperation(value = "Método responsável em fazer a inserção de uma nova Forma de Pagamento na base de dados.")
	public FormaPagamento salvar(@RequestBody FormaPagamento formaPagamento){
		return formaPagamentoRepository.save(formaPagamento);
	}
	
	@PutMapping("/formaPagamento")
	@ApiOperation(value = "Método responsável em atualizar uma Forma de Pagamento específico na base de dados.")
	public FormaPagamento atualizar(@RequestBody FormaPagamento formaPagamento){
		return formaPagamentoRepository.save(formaPagamento);
	}
	
	@DeleteMapping("/formaPagamento")
	@ApiOperation(value = "Método responsável em deletar uma Forma de Pagamento na base de dados.")
	public void deletar(@RequestBody FormaPagamento formaPagamento){
		formaPagamentoRepository.delete(formaPagamento);
	}
}
