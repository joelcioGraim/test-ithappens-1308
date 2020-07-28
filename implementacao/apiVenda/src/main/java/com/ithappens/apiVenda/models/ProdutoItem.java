package com.ithappens.apiVenda.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Joelcio Graim (Analista de Sistemas e Desenvolvedor)
 * @version 1.0 (Data - 25/07/2020)
 */

@Entity
@Table(name = "produto_item")
public class ProdutoItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, name = "idprodutoitem")
	private long idProdutoItem;

	@Column(length = 10, nullable = false)
	private String codigo;

	@Column(length = 10, nullable = false)
	private String numero;

	@Column(length = 150, nullable = false)
	private String descricao;

	/* ============= Relacionamentos =============== */

	@OneToOne
	@JoinColumn(name = "iditenspedido", nullable = false)
	private ItensPedido itensPedido;

	/* ============= Get / Set =============== */

	public long getIdProdutoItem() {
		return idProdutoItem;
	}

	public void setIdProdutoItem(long idProdutoItem) {
		this.idProdutoItem = idProdutoItem;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public ItensPedido getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(ItensPedido itensPedido) {
		this.itensPedido = itensPedido;
	}

}
