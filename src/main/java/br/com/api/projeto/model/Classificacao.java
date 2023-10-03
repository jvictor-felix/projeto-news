package br.com.api.projeto.model;

public enum Classificacao {
	
	RUIM("Ruim"),
	DAPARAMELHORAR("DaParaMelhorar"),
	BOM("Bom"),
	EXCELENTE("Excelente");
	
	private String descricao;
	
	Classificacao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;	
	}

}
