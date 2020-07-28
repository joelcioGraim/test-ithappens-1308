package com.ithappens.apiVenda.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author Joelcio Graim (Analista de Sistemas e Desenvolvedor)
 * @version 1.0 (Data - 25/07/2020)
 */

@Entity
@Table(name = "pedido_estoque")
public class PedidoEstoque implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, name = "idpedidoestoque")
	private long idPedidoEstoque;

	@Column(name = "valor_total", precision = 10, scale = 2, nullable = false)
	private BigDecimal valorTotal;

	@Column(precision = 10, scale = 2, nullable = false)
	private BigDecimal quantidade;

	/* ============= Atributos Transiente =============== */

	@Transient
	private List<ItensPedido> itensSemCategoria;

	@Transient
	private List<Produto> produtosRepetidos;

	/* ============= Relacionamentos =============== */

	@OneToOne
	@JoinColumn(name = "idtipopedido", nullable = false)
	private TipoPedido tipoPedido;

	@ManyToOne
	@JoinColumn(name = "idfilial", referencedColumnName = "idfilial", nullable = false)
	private Filial filial;

	@ManyToOne
	@JoinColumn(name = "idusuario", referencedColumnName = "idusuario", nullable = false)
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "idcliente", referencedColumnName = "idcliente", nullable = false)
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "idformapagamento", referencedColumnName = "idformapagamento", nullable = true)
	private FormaPagamento formaPagamento;

	@OneToMany(mappedBy = "pedidoEstoque")
	private Set<ItensPedido> itensPedidos;

	/* ============= Get / Set =============== */

	public List<Produto> getProdutosRepetidos() {
		return produtosRepetidos;
	}

	public void setProdutosRepetidos(List<Produto> produtosRepetidos) {
		this.produtosRepetidos = produtosRepetidos;
	}

	public long getIdPedidoEstoque() {
		return idPedidoEstoque;
	}

	public List<ItensPedido> getItensSemCategoria() {
		return itensSemCategoria;
	}

	public void setItensSemCategoria(List<ItensPedido> itensSemCategoria) {
		this.itensSemCategoria = itensSemCategoria;
	}

	public void setIdPedidoEstoque(long idPedidoEstoque) {
		this.idPedidoEstoque = idPedidoEstoque;
	}

	public TipoPedido getTipoPedido() {
		return tipoPedido;
	}

	public void setTipoPedido(TipoPedido tipoPedido) {
		this.tipoPedido = tipoPedido;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Set<ItensPedido> getItensPedidos() {
		return itensPedidos;
	}

	public void setItensPedidos(Set<ItensPedido> itensPedidos) {
		this.itensPedidos = itensPedidos;
	}

}
