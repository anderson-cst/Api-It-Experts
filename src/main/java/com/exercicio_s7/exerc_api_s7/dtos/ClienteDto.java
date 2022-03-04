package com.exercicio_s7.exerc_api_s7.dtos;


public class ClienteDto {

	
	private String nome;
	
	private Integer idade;
	
	private String genero;
	
	private Double altura;
	
	private Boolean ativo;

	
	public ClienteDto() {
	}
	
	public ClienteDto(String nome, Integer idade, String genero, Double altura, Boolean ativo) {
		this.nome = nome;
		this.idade = idade;
		this.genero = genero;
		this.altura = altura;
		this.ativo = ativo;
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
}
