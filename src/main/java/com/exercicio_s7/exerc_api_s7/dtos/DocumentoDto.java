package com.exercicio_s7.exerc_api_s7.dtos;


public class DocumentoDto {
	
	private String tipoDoc;
	
	private String numero;

	public DocumentoDto() {
	}
	
	public DocumentoDto(String tipoDoc, String numero) {
		this.tipoDoc = tipoDoc;
		this.numero = numero;
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

	
}
