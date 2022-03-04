package com.exercicio_s7.exerc_api_s7.enums;

public enum TipoStatus {
	
	ATIVO("Ativo"),
	INATIVO("Inativo");
	
	private final String statusPorExtenso;

	private TipoStatus(String statusPorExtenso) {
		this.statusPorExtenso = statusPorExtenso;
	}

	public String getStatusPorExtenso() {
		return statusPorExtenso;
	}

}
