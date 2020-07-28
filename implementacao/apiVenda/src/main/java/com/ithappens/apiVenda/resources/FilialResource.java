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

import com.ithappens.apiVenda.models.Filial;
import com.ithappens.apiVenda.repository.FilialRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST de Venda e Controle de Filial") // Config Swagger
@CrossOrigin(origins = "*") // Config Swagger - "*" indica que qualquer domínio pode acessar.
public class FilialResource {

	@Autowired
	FilialRepository filialRepository;
	
	@GetMapping("/filiais")
	@ApiOperation(value = "Método responsável em trazer todas as Filiais em uma lista.")
	public List<Filial> getLista(){
		return filialRepository.findAll();
	}
	
	@GetMapping("/filial/{id}")
	@ApiOperation(value = "Método responsável em trazer uma Filial específica atravez de seu ID.")
	public Filial getId(@PathVariable(value = "id") long id){
		return filialRepository.findById(id);
	}
	
	@PostMapping("/filial")
	@ApiOperation(value = "Método responsável em fazer a inserção de uma nova Filial na base de dados.")
	public Filial salvar(@RequestBody Filial filial){
		return filialRepository.save(filial);
	}
	
	@PutMapping("/filial")
	@ApiOperation(value = "Método responsável em atualizar uma Filial específico na base de dados.")
	public Filial atualizar(@RequestBody Filial filial){
		return filialRepository.save(filial);
	}
	
	@DeleteMapping("/filial")
	@ApiOperation(value = "Método responsável em deletar uma Filial na base de dados.")
	public void deletar(@RequestBody Filial filial){
		filialRepository.delete(filial);
	}
}
