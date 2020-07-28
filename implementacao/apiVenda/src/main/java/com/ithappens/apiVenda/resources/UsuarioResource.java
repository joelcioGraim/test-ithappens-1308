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

import com.ithappens.apiVenda.models.Usuario;
import com.ithappens.apiVenda.repository.UsuarioRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST de Venda e Controle de Estoque") // Config Swagger
@CrossOrigin(origins = "*") // Config Swagger - "*" indica que qualquer domínio pode acessar.
public class UsuarioResource {

	@Autowired
	UsuarioRepository usuarioRepository;
		
	@GetMapping("/usuarios")
	@ApiOperation(value = "Método responsável em trazer todos os Usuários em uma lista.")
	public List<Usuario> getLista(){
		return usuarioRepository.findAll();
	}
		
	@GetMapping("/usuario/{id}")
	@ApiOperation(value = "Método responsável em trazer um Usuário específico atravez de seu ID.")
	public Usuario getId(@PathVariable(value = "id") long id){
		return usuarioRepository.findById(id);
	}
	
	@PostMapping("/usuario")
	@ApiOperation(value = "Método responsável em fazer a inserção de um novo Usuário na base de dados.")
	public Usuario salvar(@RequestBody Usuario usuario){
		return usuarioRepository.save(usuario);
	}
	
	@PutMapping("/usuario")
	@ApiOperation(value = "Método responsável em atualizar um Usuário específico na base de dados.")
	public Usuario atualizar(@RequestBody Usuario usuario){
		return usuarioRepository.save(usuario);
	}
	
	@DeleteMapping("/usuario")
	@ApiOperation(value = "Método responsável em deletar um Usuário na base de dados.")
	public void deletar(@RequestBody Usuario usuario){
		usuarioRepository.delete(usuario);
	}
}
