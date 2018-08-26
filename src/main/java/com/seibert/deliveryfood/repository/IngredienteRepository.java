package com.seibert.deliveryfood.repository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.seibert.deliveryfood.domain.Ingrediente;

@Repository
public class IngredienteRepository {

	public List<Ingrediente> findAll(){
		// TODO Implementar buscar dos ingredientes aqui
		
		Ingrediente i1 = new Ingrediente(1, "Alface", 0.4);
		Ingrediente i2 = new Ingrediente(2, "Bacon", 2.00);
		Ingrediente i3 = new Ingrediente(3, "Hamburguer de carne", 3.00);
		Ingrediente i4 = new Ingrediente(4, "Ovo", 0.8);
		Ingrediente i5 = new Ingrediente(5, "Queijo", 1.5);
		
		List<Ingrediente> list = new ArrayList<>();
		list.add(i1);
		list.add(i2);
		list.add(i3);
		list.add(i4);
		list.add(i5);
		
		return list;
	}

	public Ingrediente save(Ingrediente ingrediente) {
		// TODO Implementar a persistencia aqui
		
		/*
		 * simulando persistencia de um objeto
		 */
		
		Ingrediente obj = ingrediente;
		obj.setId(6);
		System.out.println("Ingrediente =" + obj.getDescricao() + " foi Salvo " + " id=" + obj.getId());
		return obj;
	}
}
