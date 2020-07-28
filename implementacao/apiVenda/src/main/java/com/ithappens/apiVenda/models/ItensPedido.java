package com.ithappens.apiVenda.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Joelcio Graim (Analista de Sistemas e Desenvolvedor)
 * @version 1.0 (Data - 25/07/2020)
 */

@Entity
@Table(name = "itens_pedido")
public class ItensPedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, name = "iditenspedido")
	private long idItensPedido;

	@Column(precision = 10, scale = 2, nullable = false)
	private BigDecimal quantidade;

	@Column(name = "valor_unitario", precision = 10, scale = 2, nullable = false)
	private BigDecimal valorUnitario;

	@Column(name = "valor_total", precision = 10, scale = 2, nullable = false)
	private BigDecimal valorTotal;
	
	@Column(length = 150)
	private String categoria;

	/**
	 * OBS: O atributo deve ser apenas de três formas: Ativo, Cancelado ou
	 * Processado
	 */
	@Column(length = 10, nullable = false)
	private String status;
	
	/* ============= Relacionamentos =============== */

	@ManyToOne
	@JoinColumn(name = "idpedidoestoque", referencedColumnName = "idpedidoestoque", nullable = false)
	private PedidoEstoque pedidoEstoque;
	
	@OneToOne(mappedBy = "itensPedido", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private ProdutoItem produtoItem;

	/* ============= Get / Set =============== */

	public long getIdItensPedido() {
		return idItensPedido;
	}

	public ProdutoItem getProdutoItem() {
		return produtoItem;
	}

	public void setProdutoItem(ProdutoItem produtoItem) {
		this.produtoItem = produtoItem;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setIdItensPedido(long idItensPedido) {
		this.idItensPedido = idItensPedido;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public PedidoEstoque getPedidoEstoque() {
		return pedidoEstoque;
	}

	public void setPedidoEstoque(PedidoEstoque pedidoEstoque) {
		this.pedidoEstoque = pedidoEstoque;
	}

}
