package com.exercicio_s7.exerc_api_s7.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name= "tb_documentos")
public class Documento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name= "tipo_doc", nullable= false, length= 20)
	private String tipoDoc;
	@Column(name= "numero", nullable= false, length= 20)
	private String numero;
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name= "cliente_id")
	private Cliente clienteId;
	
	public Documento() {		
	}	

	public Documento(Long id, String tipoDoc, String numero, Cliente clienteId) {
		this.id = id;
		this.tipoDoc = tipoDoc;
		this.numero = numero;
		this.clienteId = clienteId;
	}	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	@JsonBackReference
	public Cliente getClienteId() {
		return clienteId;
	}

	public void setClienteId(Cliente clienteId) {
		this.clienteId = clienteId;
	}		
}
