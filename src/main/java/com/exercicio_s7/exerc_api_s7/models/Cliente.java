package com.exercicio_s7.exerc_api_s7.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name= "tb_clientes")
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name= "nome", nullable= false, length= 50)
	private String nome;
	@Column(name= "idade", nullable= false, length= 3)
	private Integer idade;
	@Column(name= "genero", nullable= false, length= 1)
	private String genero;
	@Column(name= "altura", nullable= false, length= 4)
	private Double altura;
	@Column(name= "ativo", nullable= false, length= 10)
	private Boolean ativo;
	@OneToMany(mappedBy= "clienteId", cascade = CascadeType.ALL)
	private List<Endereco> enderecos;
	@OneToMany(mappedBy= "clienteId", cascade = CascadeType.ALL)
	private List<Documento> documentos;
	
	
	public Cliente() {
	}
	
	public Cliente(String nome, Integer idade, String genero, Double altura, Boolean ativo, List<Documento> documentos,
			List<Endereco> enderecos) {
		this.nome = nome;
		this.idade = idade;
		this.genero = genero;
		this.altura = altura;
		this.ativo = ativo;
		this.documentos = documentos;
		this.enderecos = enderecos;
	}
	
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Double getAltura() {
		return altura;
	}
	public void setAltura(Double altura) {
		this.altura = altura;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	@JsonManagedReference
	public List<Documento> getDocumentos() {
		return documentos;
	}
	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}
	@JsonManagedReference
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}	
	
	
}
