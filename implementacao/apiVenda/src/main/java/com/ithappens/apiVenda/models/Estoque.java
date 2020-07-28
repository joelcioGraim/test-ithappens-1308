package com.ithappens.apiVenda.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/** 
 * @author Joelcio Graim (Analista de Sistemas e Desenvolvedor)
 * @version 1.0 (Data - 25/07/2020)
 */

@Entity
@Table(name = "estoque")
public class Estoque implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, name = "idestoque")
	private long idEstoque;

	@Column(length = 150)
	private String categoria;

	@Column(name = "valor_unitario", precision = 10, scale = 2)
	private BigDecimal valorUnitario;

	@Column(precision = 10, scale = 2)
	private BigDecimal quantidade;

	/* ============= Relacionamentos =============== */

	/*@OneToMany(mappedBy = "estoque")
	private Set<Produto> produtos;
*/
	@ManyToOne
	@JoinColumn(name = "idfilial", referencedColumnName = "idfilial", nullable = false)
	private Filial filial;
	
	/* ============= Get / Set =============== */

	public long getIdEstoque() {
		return idEstoque;
	}

	public void setIdEstoque(long idEstoque) {
		this.idEstoque = idEstoque;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}	

	/*public Set<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}*/

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

}
