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
@Table(name = "tipo_pedido")
public class TipoPedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, name = "idtipopedido")
	private long idTipoPedido;

	/**
	 * OBS: O atributo deve ser apenas de dois tipos: Entrada ou Saída
	 */
	@Column(length = 7)
	private String descricao;

	/* ============= Get / Set =============== */

	public String getDescricao() {
		return descricao;
	}

	public long getIdTipoPedido() {
		return idTipoPedido;
	}

	public void setIdTipoPedido(long idTipoPedido) {
		this.idTipoPedido = idTipoPedido;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
