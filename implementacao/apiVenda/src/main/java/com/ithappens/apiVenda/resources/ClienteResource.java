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

import com.ithappens.apiVenda.models.Cliente;
import com.ithappens.apiVenda.repository.ClienteRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST de Venda e Controle de Cliente") // Config Swagger
@CrossOrigin(origins = "*") // Config Swagger - "*" indica que qualquer domínio pode acessar.
public class ClienteResource {

	@Autowired
	ClienteRepository clienteRepository;	
	
	@GetMapping("/clientes")
	@ApiOperation(value = "Método responsável em trazer todos os Clientes em uma lista.")
	public List<Cliente> getLista(){
		return clienteRepository.findAll();
	}	

	@GetMapping("/cliente/{id}")
	@ApiOperation(value = "Método responsável em trazer um Cliente específico atravez de seu ID.")
	public Cliente getId(@PathVariable(value = "id") long id){
		return clienteRepository.findById(id);
	}
	
	@PostMapping("/cliente")
	@ApiOperation(value = "Método responsável em fazer a inserção de um novo Cliente na base de dados.")
	public Cliente salvar(@RequestBody Cliente cliente){
		return clienteRepository.save(cliente);
	}
	
	@PutMapping("/cliente")
	@ApiOperation(value = "Método responsável em atualizar um Cliente específico na base de dados.")
	public Cliente atualizar(@RequestBody Cliente cliente){
		return clienteRepository.save(cliente);
	}
	
	@DeleteMapping("/cliente")
	@ApiOperation(value = "Método responsável em deletar um Cliente na base de dados.")
	public void deletar(@RequestBody Cliente cliente){
		clienteRepository.delete(cliente);
	}
}
