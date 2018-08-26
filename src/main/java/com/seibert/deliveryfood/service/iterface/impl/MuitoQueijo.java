package com.seibert.deliveryfood.service.iterface.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.seibert.deliveryfood.domain.Ingrediente;
import com.seibert.deliveryfood.service.iterface.CalculaPreco;

@Component
public class MuitoQueijo implements CalculaPreco{

	public static final int PROMOCAO_CADA_TRES_QUEIJO = 3;

	@Override
	public Double calcularValor(List<Ingrediente> ingredientes) {

		Double totalAux = 0.0;
		Integer contadorQueijo = 0;
		Integer desconto = 0;
		Double totalDesconto = 0.0;
		Double valorQueijo = 0.0;
		
		for (Ingrediente ingrediente : ingredientes) {
			totalAux = totalAux + ingrediente.getValor();
			if (ingrediente.getDescricao().equals("Queijo")){
				contadorQueijo++;
				valorQueijo = ingrediente.getValor();
			}
		}
		desconto = contadorQueijo/MuitoQueijo.PROMOCAO_CADA_TRES_QUEIJO;
		if(desconto >= 1 ) {
			totalDesconto = new Double(desconto) * valorQueijo;
		}
		
		return totalAux - totalDesconto;
	}

}
