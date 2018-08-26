package com.seibert.deliveryfood.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.seibert.deliveryfood.domain.Lanche;
import com.seibert.deliveryfood.service.LancheService;


@RestController
@RequestMapping(value="lanches")
public class LancheResource {
	
	@Autowired
	private LancheService service;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Lanche>> findAll() {
		List<Lanche> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Lanche> calcula(@RequestBody Lanche lanche) {
		lanche.setValor(service.calculaValor(lanche));
		return ResponseEntity.ok().body(lanche);
	}
}
