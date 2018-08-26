package com.seibert.deliveryfood.service.iterface.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.seibert.deliveryfood.domain.Ingrediente;
import com.seibert.deliveryfood.service.iterface.CalculaPreco;

@Component
public class Light implements CalculaPreco{

	@Override
	public Double calcularValor(List<Ingrediente> ingredientes) {
		
		Double totalAux = 0.0;
		Double total = 0.0;
		boolean temBacon = false;
		boolean temAlface = false;
		
		for (Ingrediente ingrediente : ingredientes) {
			totalAux = totalAux + ingrediente.getValor();
			if (ingrediente.getDescricao().contains(("Bacon"))){
				temBacon = true;
			}
			if (ingrediente.getDescricao().contains(("Alface"))){
				temAlface = true;
			}
		}
		
		if(temAlface && !temBacon) {
			total = totalAux - (totalAux * 0.1);
		}else {
			total = totalAux;
		}
		return total;
	}

}
