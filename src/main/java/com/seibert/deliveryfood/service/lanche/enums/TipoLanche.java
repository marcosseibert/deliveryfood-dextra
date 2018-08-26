package com.seibert.deliveryfood.service.lanche.enums;

public enum TipoLanche {
	
	NORMAL(1,"Normal"),
	MUITA_CARNE(2,"Muita Carne"),
	MUITO_QUEIJO(3,"Muito Queijo"),
	LIGHT(4,"Light");
	
	private int cod;
	private String description;
	
	private TipoLanche(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}
	
	public int getCod() {
		return cod;
	}
	
	public void setCod(int cod) {
		this.cod = cod;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
