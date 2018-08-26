package com.seibert.deliveryfood.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.seibert.deliveryfood.domain.Ingrediente;
import com.seibert.deliveryfood.service.IngredienteService;


@RestController
@RequestMapping(value="ingredientes")
public class IngredienteResource {
	
	@Autowired
	private IngredienteService service;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Ingrediente>> findAll() {
		List<Ingrediente> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
		
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Ingrediente obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build(obj.getId());
		return ResponseEntity.created(uri).build();
	}
}
