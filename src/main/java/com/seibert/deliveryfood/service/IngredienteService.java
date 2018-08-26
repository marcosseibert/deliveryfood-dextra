package com.seibert.deliveryfood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seibert.deliveryfood.domain.Ingrediente;
import com.seibert.deliveryfood.repository.IngredienteRepository;

@Service
public class IngredienteService {
	
	@Autowired
	private IngredienteRepository ingredienteRepository;
	
	public List<Ingrediente> findAll(){
		return ingredienteRepository.findAll();
	}
	
	public Ingrediente insert(Ingrediente ingrediente) {
		return ingredienteRepository.save(ingrediente);
	}
}
