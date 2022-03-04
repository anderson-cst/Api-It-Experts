package com.exercicio_s7.exerc_api_s7.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.exercicio_s7.exerc_api_s7.enums.TipoStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name= "tb_enderecos")
public class Endereco implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	@Column(name= "bairro", nullable= false, length= 50)
	private String bairro;
	@Column(name= "tipo_logradouro", nullable= false, length= 30)
	private String tipoLogradouro;
	@Column(name= "nome_rua", nullable= false, length= 50)
	private String nomeRua;
	@Column(name= "numero", nullable= false, length= 5)
	private Integer numero;
	@Column(name= "tipo_status", nullable= false, length= 10)
	@Enumerated(EnumType.STRING)
	private TipoStatus tipoStatus;
	@Column(name= "cidade", nullable= false, length= 50)
	private String cidade;
	@Column(name= "estado", nullable= false, length= 30)
	private String estado;
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name= "cliente_id")
	private Cliente clienteId;
	
	
	public Endereco() {
	}

	public Endereco(Long id, String bairro, String tipoLogradouro, String nomeRua, Integer numero, TipoStatus tipoStatus,
			String cidade, String estado, Cliente clienteId) {
		this.id = id;
		this.bairro = bairro;
		this.tipoLogradouro = tipoLogradouro;
		this.nomeRua = nomeRua;
		this.numero = numero;
		this.tipoStatus = tipoStatus;
		this.cidade = cidade;
		this.estado = estado;
		this.clienteId = clienteId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getNomeRua() {
		return nomeRua;
	}

	public void setNomeRua(String nomeRua) {
		this.nomeRua = nomeRua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public TipoStatus getTipoStatus() {
		return tipoStatus;
	}

	public void setTipoStatus(TipoStatus tipoStatus) {
		this.tipoStatus = tipoStatus;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	@JsonBackReference
	public Cliente getClienteId() {
		return clienteId;
	}

	public void setClienteId(Cliente clienteId) {
		this.clienteId = clienteId;
	}
	
	
	
	









}
