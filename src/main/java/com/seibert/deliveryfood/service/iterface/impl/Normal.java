package com.seibert.deliveryfood.service.iterface.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.seibert.deliveryfood.domain.Ingrediente;
import com.seibert.deliveryfood.service.iterface.CalculaPreco;

@Component
public class Normal implements CalculaPreco{

	@Override
	public Double calcularValor(List<Ingrediente> ingredientes) {
		Double total = 0.0;
		for (Ingrediente ingrediente : ingredientes) {
			total = total + ingrediente.getValor();
		}
		return total;
	}

}
