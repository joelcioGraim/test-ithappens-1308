package com.ithappens.apiVenda.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Joelcio Graim (Analista de Sistemas e Desenvolvedor)
 * @version 1.0 (Data - 25/07/2020)
 */

@Entity
@Table(name = "forma_pagamento")
public class FormaPagamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, name = "idformapagamento")
	private long idFormaPagamento;

	/**
	 * OBS: O atributo deve ser apenas de três formas: A Vista, Boleto ou Cartão
	 */
	@Column(length = 7)
	private String descricao;

	/* ============= Relacionamentos =============== */

	/*@OneToMany(mappedBy = "formaPagamento")
	private Set<PedidoEstoque> pedidosEstoque;*/
	
	/* ============= Get / Set =============== */

	public long getIdFormaPagamento() {
		return idFormaPagamento;
	}

	public void setIdFormaPagamento(long idFormaPagamento) {
		this.idFormaPagamento = idFormaPagamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/*public Set<PedidoEstoque> getPedidosEstoque() {
		return pedidosEstoque;
	}

	public void setPedidosEstoque(Set<PedidoEstoque> pedidosEstoque) {
		this.pedidosEstoque = pedidosEstoque;
	}*/

}
