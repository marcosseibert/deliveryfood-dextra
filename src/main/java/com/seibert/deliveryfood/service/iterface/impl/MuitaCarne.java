package com.seibert.deliveryfood.service.iterface.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.seibert.deliveryfood.domain.Ingrediente;
import com.seibert.deliveryfood.service.iterface.CalculaPreco;

@Component
public class MuitaCarne implements CalculaPreco{
	
	public static final int PROMOCAO_CADA_TRES_HAMBURGUER = 3;

	@Override
	public Double calcularValor(List<Ingrediente> ingredientes) {

		Double totalAux = 0.0;
		Integer contadorHamburguer = 0;
		Integer desconto = 0;
		Double totalDesconto = 0.0;
		Double valorHamburguer = 0.0;
		
		for (Ingrediente ingrediente : ingredientes) {
			totalAux = totalAux + ingrediente.getValor();
			if (ingrediente.getDescricao().equals("Hamburguer de Carne")){
				contadorHamburguer++;
				valorHamburguer = ingrediente.getValor();
			}
		}
		desconto = contadorHamburguer/MuitaCarne.PROMOCAO_CADA_TRES_HAMBURGUER;
		if(desconto >= 1 ) {
			totalDesconto = new Double(desconto) * valorHamburguer;
		}
		totalAux = totalAux - totalDesconto;
		return totalAux;
	}
}
