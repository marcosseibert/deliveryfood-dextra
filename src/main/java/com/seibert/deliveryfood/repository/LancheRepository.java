package com.seibert.deliveryfood.repository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.seibert.deliveryfood.domain.Ingrediente;
import com.seibert.deliveryfood.domain.Lanche;
import com.seibert.deliveryfood.service.lanche.enums.TipoLanche;

@Repository
public class LancheRepository {

	public List<Lanche> findAll(){
		
		Ingrediente alface = new Ingrediente(1, "Alface", 0.4);
		Ingrediente bacon = new Ingrediente(2, "Bacon", 2.00);
		Ingrediente hamburguer = new Ingrediente(3, "Hamburguer de carne", 3.00);
		Ingrediente ovo = new Ingrediente(4, "Ovo", 0.8);
		Ingrediente queijo = new Ingrediente(5, "Queijo", 1.5);
		
//		Ingrediente ixbacon1 = new Ingrediente(1, "Bacon", 2.00);
//		Ingrediente ixbacon2 = new Ingrediente(1, "Hamburguer de carne", 3.00);
//		Ingrediente ixbacon3 = new Ingrediente(1, "Queijo", 1.5);
		
		List<Ingrediente> ingredientesXbacon = new ArrayList<>();
		ingredientesXbacon.add(bacon);
		ingredientesXbacon.add(hamburguer);
		ingredientesXbacon.add(queijo);
		
//		Ingrediente ixBurguer1 = new Ingrediente(1, "Hamburguer de carne", 3.00);
//		Ingrediente ixBurguer2 = new Ingrediente(1, "Queijo", 1.5);
		
		List<Ingrediente> ingredientesXburguer = new ArrayList<>();
		ingredientesXburguer.add(hamburguer);
		ingredientesXburguer.add(queijo);
		ingredientesXburguer.add(alface);
		
//		Ingrediente ixEggBacon1 = new Ingrediente(1, "ovo", 3.00);
//		Ingrediente ixEggBacon2 = new Ingrediente(1, "Queijo", 1.5);
//		Ingrediente ixEggBacon2 = new Ingrediente(1, "Queijo", 1.5);
		
		List<Ingrediente> ingredientesXeggBacon = new ArrayList<>();
		ingredientesXeggBacon.add(ovo);
		ingredientesXeggBacon.add(bacon);
		ingredientesXeggBacon.add(hamburguer);
		ingredientesXeggBacon.add(queijo);
		
		Lanche xbacon = new Lanche(1,"X-bacon", ingredientesXbacon, TipoLanche.NORMAL);
		Lanche xburguer = new Lanche(1,"X-burguer", ingredientesXburguer, TipoLanche.NORMAL);
		Lanche xEggBacon = new Lanche(1,"X-Egg Bacon", ingredientesXeggBacon, TipoLanche.NORMAL);
		
		return Arrays.asList(xbacon,xburguer,xEggBacon);
	}
}
