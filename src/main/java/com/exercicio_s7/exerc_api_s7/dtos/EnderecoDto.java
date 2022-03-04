package com.exercicio_s7.exerc_api_s7.dtos;

import com.exercicio_s7.exerc_api_s7.enums.TipoStatus;

public class EnderecoDto {

	private String bairro;
	
	private String tipoLogradouro;
	
	private String nomeRua;
	
	private Integer numero;
		
	private TipoStatus tipoStatus;
	
	private String cidade;
	
	private String estado;
	

	public EnderecoDto() {		
	}
	
	public EnderecoDto(String bairro, String tipoLogradouro, String nomeRua, Integer numero, TipoStatus tipoStatus,
			String cidade, String estado) {
		this.bairro = bairro;
		this.tipoLogradouro = tipoLogradouro;
		this.nomeRua = nomeRua;
		this.numero = numero;
		this.tipoStatus = tipoStatus;
		this.cidade = cidade;
		this.estado = estado;
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
}
