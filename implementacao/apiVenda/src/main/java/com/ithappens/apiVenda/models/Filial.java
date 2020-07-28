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
@Table(name = "filial")
public class Filial implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, name = "idfilial")
	private long idFilial;

	@Column(length = 150)
	private String nome;

	@Column(length = 150)
	private String cidade;

	@Column(length = 2)
	private String uf;

	@Column(length = 18)
	private String cnpj;

	@Column(length = 200)
	private String logradouro;

	@Column(length = 7)
	private String numero;

	/* ============= Get / Set =============== */

	public long getIdFilial() {
		return idFilial;
	}

	public void setIdFilial(long idFilial) {
		this.idFilial = idFilial;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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

}
