package com.seibert.deliveryfood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seibert.deliveryfood.domain.Lanche;
import com.seibert.deliveryfood.repository.LancheRepository;
import com.seibert.deliveryfood.service.iterface.CalculaPreco;
import com.seibert.deliveryfood.service.iterface.impl.Light;
import com.seibert.deliveryfood.service.iterface.impl.MuitaCarne;
import com.seibert.deliveryfood.service.iterface.impl.MuitoQueijo;
import com.seibert.deliveryfood.service.iterface.impl.Normal;
import com.seibert.deliveryfood.service.lanche.enums.TipoLanche;

@Service
public class LancheService {
	
	@Autowired
	private LancheRepository lancheRepository;
	
	public List<Lanche> findAll(){
		return lancheRepository.findAll();
	}
	
	public Double calculaValor(Lanche lanche) {
		CalculaPreco calculo = null;
		
		if(TipoLanche.NORMAL.equals(lanche.getTipoLanche())) {
			calculo = new Normal();
			lanche.setCalculo(calculo);
		}
		else if (TipoLanche.MUITA_CARNE.equals(lanche.getTipoLanche())){
			calculo = new MuitaCarne();
			lanche.setCalculo(calculo);
		}
		else if (TipoLanche.MUITO_QUEIJO.equals(lanche.getTipoLanche())){
			calculo = new MuitoQueijo();
			lanche.setCalculo(calculo);
		}
		else if (TipoLanche.LIGHT.equals(lanche.getTipoLanche())) {
			calculo = new Light();
			lanche.setCalculo(calculo);
		}
		return lanche.calcularValor(lanche.getIngredientes());
	}
}
