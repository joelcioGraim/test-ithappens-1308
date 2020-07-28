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

import com.ithappens.apiVenda.models.PedidoEstoque;
import com.ithappens.apiVenda.repository.ItensPedidoRepository;
import com.ithappens.apiVenda.repository.PedidoEstoqueRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST de Venda e Controle de Estoque") // Config Swagger
@CrossOrigin(origins = "*") // Config Swagger - "*" indica que qualquer domínio pode acessar.
public class PedidoEstoqueResource {

	@Autowired
	PedidoEstoqueRepository pedidoEstoqueRepository;
	
	@Autowired
	ItensPedidoRepository itensPedidoRepository;
	//@Autowired
	//FilialRepository filialRepository;
	
	@GetMapping("/pedidosEstoque")
	@ApiOperation(value = "Método responsável em trazer todos os Pedido de Estoques em uma lista.")
	public List<PedidoEstoque> getLista(){
		return pedidoEstoqueRepository.findAll();
	}
	
	@GetMapping("/pedidoEstoque/{id}")
	@ApiOperation(value = "Método responsável em trazer um Pedido de Estoque específico atravez de seu ID.")
	public PedidoEstoque getId(@PathVariable(value = "id") long id){
		return pedidoEstoqueRepository.findById(id);
	}
		
	@PutMapping("/pedidoEstoque")
	@ApiOperation(value = "Método responsável em atualizar um Pedido de Estoque específico na base de dados.")
	public PedidoEstoque atualizar(@RequestBody PedidoEstoque pedidoEstoque){
		return pedidoEstoqueRepository.save(pedidoEstoque);
	}
	
	@DeleteMapping("/pedidoEstoque")
	@ApiOperation(value = "Método responsável em deletar um Pedido de Estoque na base de dados.")
	public void deletar(@RequestBody PedidoEstoque pedidoEstoque){
		pedidoEstoqueRepository.delete(pedidoEstoque);
	}
	
	/* ====================== Regra de Negócio =============================================== */
	
	@PostMapping("/abrirPedidoEstoque")
	@ApiOperation(value = "Método responsável em fazer a abertura de um novo Pedido de Estoque na base de dados. "
			+ "OBS: É obrigatório informar o Usuário, Cliente, Filial e Tipo de Pedido.")
	public PedidoEstoque abrirPedidoEstoque(@RequestBody PedidoEstoque pedidoEstoque){	
		return pedidoEstoqueRepository.save(pedidoEstoque);
	}
	
	
//	@PutMapping("/addItenspedidoEstoque")
//	@ApiOperation(value = "Método responsável em criar a lista de itens do Pedido de Estoque (Entrada ou Saída), "
//			+ "bem como, tratar os itens com categoria não existente e os retorna em 'itensSemCategoria' "
//			+ "e verificar se há produtos repetidos retornando-os em 'produtosRepetidos'.")
//	public void addItensPedidoEstoqueEntrada (@RequestBody PedidoEstoque pedidoEstoque){
//			
//		List<Estoque> estoques =  estoqueRepository.findAll();
//		ArrayList<ItensPedido> itensSemCategoria = new ArrayList<>();
//		ArrayList<Produto> produtoRepetidos = new ArrayList<>();
//		Set<Produto> produtoValidos = new HashSet<>();
//		
//		//1º. Pega os Estoques
//		for(Estoque estoque : estoques){			
//			//2º. Seleciona o estoque específico da filial
//			if(estoque.getFilial().getIdFilial() == pedidoEstoque.getFilial().getIdFilial()){			 
//				//3º. Varre os istens que serão adicionados ao produto
//				for(ItensPedido item : pedidoEstoque.getItensPedidos()){	
//					//5º. Verifica se há produtos repetidos, adiciona-os em "produtoRepetidos" e os retira dos itens de pedido
//					if(!produtoValidos.add(item.getProduto()) && !"Cancelado".equals(item.getStatus())){
//						produtoRepetidos.add(item.getProduto());
//						pedidoEstoque.getItensPedidos().remove(item);
//					} else
//					//4º. Se o item não pertencer a uma categoria existente, ele é adicionado aos 
//					//itens sem categoria para ser corrigido e removido dos itens
//					if(!estoque.getCategoria().equals(item.getCategoria())){
//						itensSemCategoria.add(item);
//						pedidoEstoque.setItensSemCategoria(itensSemCategoria);
//						pedidoEstoque.getItensPedidos().remove(item);
//					} else { //5º. Se estiver tudo ok
//						item.setStatus("Ativo"); // Seta o status para ativo se for válido
//						item.setValorTotal(item.getQuantidade().multiply(item.getValorUnitario()));
//						item.setPedidoEstoque(pedidoEstoque);							
//					}
//				} //FIM FOR - 3º PASSO
//			} //FIM IF - 2º PASSO
//		}//FIM FOR - 1º PASSO
//		
//		if(pedidoEstoque.getItensPedidos() != null && pedidoEstoque.getItensPedidos().size() > 0){
//			itensPedidoRepository.saveAll(pedidoEstoque.getItensPedidos()); //Salva os Itens do Pedido
//		}
//			System.out.println("O");
//		//return pedidoEstoqueRepository.save(pedidoEstoque);
//	}
//	
//	
//	@PutMapping("/consolidarItensPedidoEntrada")
//	@ApiOperation(value = "Método responsável em persistir os produtos e atualizar o estoque de uma Entrada.")
//	public ResponseEntity<PedidoEstoque> consolidarItensPedido (@RequestBody PedidoEstoque pedidoEstoque){
//			
//		List<Estoque> estoques =  estoqueRepository.findAll();
//		ArrayList<ItensPedido> itensSemCategoria = new ArrayList<>();
//		ArrayList<Produto> produtoRepetidos = new ArrayList<>();
//		Set<Produto> produtoValidos = new HashSet<>();
//		
//		//1º. Pega os Estoques
//		for(Estoque estoque : estoques){			
//			//2º. Seleciona o estoque específico da filial
//			if(estoque.getFilial().getIdFilial() == pedidoEstoque.getFilial().getIdFilial()){			 
//				//3º. Varre os istens que serão adicionados ao produto
//				for(ItensPedido item : pedidoEstoque.getItensPedidos()){	
//					//5º. Verifica se há produtos repetidos, adiciona-os em "produtoRepetidos" e os retira dos itens de pedido
//					if(!produtoValidos.add(item.getProduto()) && !"Cancelado".equals(item.getStatus())){
//						produtoRepetidos.add(item.getProduto());
//						pedidoEstoque.getItensPedidos().remove(item);
//					}
//					//4º. Se o item não pertencer a uma categoria existente, ele é adicionado aos 
//					//itens sem categoria para ser corrigido e removido dos itens
//					if(!estoque.getCategoria().equals(item.getCategoria())){
//						itensSemCategoria.add(item);
//						pedidoEstoque.setItensSemCategoria(itensSemCategoria);
//						pedidoEstoque.getItensPedidos().remove(item);
//					}
//				} //FIM FOR - 3º PASSO
//			} //FIM IF - 2º PASSO
//		}//FIM FOR - 1º PASSO
//			
//		//return pedidoEstoqueRepository.save(pedidoEstoque);
//		return ResponseEntity.ok(pedidoEstoque);
//	}
}
