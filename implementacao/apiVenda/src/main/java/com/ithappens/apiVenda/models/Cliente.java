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
@Table(name = "cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, name = "idcliente")
	private long idCliente;

	@Column(length = 150, nullable = false)
	private String nome;

	@Column(length = 11, nullable = false, unique = true)
	private String cpf;

	@Column(length = 150)
	private String email;

	@Column(length = 11)
	private String celular;

	@Column(length = 150)
	private String cidade;

	@Column(length = 2)
	private String uf;

	@Column(length = 200)
	private String logradouro;

	@Column(length = 7)
	private String numero;

	/* ============= Relacionamentos =============== */

	/*@OneToMany(mappedBy = "cliente")
	private Set<PedidoEstoque> pedidosEstoque;*/

	/* ============= Get / Set =============== */

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	/*public Set<PedidoEstoque> getPedidosEstoque() {
		return pedidosEstoque;
	}

	public void setPedidosEstoque(Set<PedidoEstoque> pedidosEstoque) {
		this.pedidosEstoque = pedidosEstoque;
	}*/

}
