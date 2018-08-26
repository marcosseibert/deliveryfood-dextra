package com.seibert.deliveryfood.service.iterface;

import java.util.List;

import com.seibert.deliveryfood.domain.Ingrediente;

public interface CalculaPreco {

	public Double calcularValor(List<Ingrediente> ingredientes);
}
