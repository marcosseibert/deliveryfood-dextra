package com.seibert.deliveryfood;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.seibert.deliveryfood.domain.Ingrediente;
import com.seibert.deliveryfood.service.iterface.CalculaPreco;
import com.seibert.deliveryfood.service.iterface.impl.Light;
import com.seibert.deliveryfood.service.iterface.impl.MuitaCarne;
import com.seibert.deliveryfood.service.iterface.impl.MuitoQueijo;
import com.seibert.deliveryfood.service.iterface.impl.Normal;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DeliveryfoodDextraApplicationTests {

	private Ingrediente alface;
	private Ingrediente bacon;
	private Ingrediente hamburguer;
	private Ingrediente ovo;
	private Ingrediente queijo;
			
	@Before
	public void setup() {
		
		alface = new Ingrediente(1, "Alface", 0.40);
		bacon = new Ingrediente(2, "Bacon", 2.00);
		hamburguer = new Ingrediente(3, "Hamburguer de Carne", 3.00);
		ovo = new Ingrediente(4, "Ovo", 0.80);
		queijo = new Ingrediente(5, "Queijo", 1.50);
	}
	
	/**
	 * Lanches do Cardapio
	 */
	@Test
	public void QuandoLancheForXbaconEntaoPrecoIgualSeisEciquenta() {
		
		//cenário
		CalculaPreco calcula = new Normal();
		
		//execução
		Double precoAtual = calcula.calcularValor(Arrays.asList(bacon,hamburguer,queijo));
		
		//verificação
		assertThat(precoAtual, is(equalTo(6.5)));
	}
	
	@Test
	public void QuandoLancheForXburguerEntaoPrecoIgualQuatroEciquenta() {
		
		//cenário
		CalculaPreco calcula = new Normal();
		
		//execução
		Double precoAtual = calcula.calcularValor(Arrays.asList(hamburguer,queijo));
		
		//verificação
		assertThat(precoAtual, is(equalTo(4.5)));
	}
	
	@Test
	public void QuandoLancheForXeggEntaoPrecoIgualQuatroEciquenta() {
		
		//cenário
		CalculaPreco calcula = new Normal();
		
		//execução
		Double precoAtual = calcula.calcularValor(Arrays.asList(ovo,hamburguer,queijo));
		
		//verificação
		assertThat(precoAtual, is(equalTo(5.3)));
	}
	
	/**
	 * Promoção muita carne
	 */
	@Test
	public void QuandoLancheForMuitaCarneComTresHamburguersEntaoPagaMenosUmHamburgues() {
		
		//cenário
		CalculaPreco calcula = new MuitaCarne();
		
		//execução
		Double precoAtual = calcula.calcularValor(Arrays.asList(ovo,hamburguer,hamburguer,hamburguer,queijo));
		
		//verificação
		assertThat(precoAtual, is(equalTo(8.3)));
	}
	
	@Test
	public void QuandoLancheForMuitaCarneComCincoHamburguerEntaoPagaMenosUmHamburgues() {
		
		//cenário
		CalculaPreco calcula = new MuitaCarne();
		
		//execução
		Double precoAtual = calcula.calcularValor(Arrays.asList(ovo,hamburguer,hamburguer,hamburguer,queijo,hamburguer,hamburguer));
		
		//verificação
		assertThat(precoAtual, is(equalTo(14.3)));
	}
	
	@Test
	public void QuandoLancheForMuitaCarneComSeisHamburguerEntaoPagaMenosDoisHamburgues() {
		
		//cenário
		CalculaPreco calcula = new MuitaCarne();
		
		//execução
		Double precoAtual = calcula.calcularValor(Arrays.asList(ovo,hamburguer,hamburguer,hamburguer,queijo,hamburguer,hamburguer,hamburguer));
		
		//verificação
		assertThat(precoAtual, is(equalTo(14.3)));
	}
	
	/**
	 * Promoção muito queijo
	 */
	
	@Test
	public void QuandoLancheForMuitoQueijoComTresQueijosEntaoPagaMenosUmQueijo() {
		
		//cenário
		CalculaPreco calcula = new MuitoQueijo();
		
		//execução
		Double precoAtual = calcula.calcularValor(Arrays.asList(ovo,queijo,queijo,queijo,hamburguer,alface));
		
		//verificação
		assertEquals(7.2, precoAtual, 0.001);
	}
	
	@Test
	public void QuandoLancheForMuitoQueijoComCincoQueijoEntaoPagaMenosUmQueijo() {
		
		//cenário
		CalculaPreco calcula = new MuitoQueijo();
		
		//execução
		Double precoAtual = calcula.calcularValor(Arrays.asList(ovo,queijo,queijo,queijo,queijo,queijo,hamburguer));
		
		//verificação
		assertThat(precoAtual, is(equalTo(9.8)));
	}
	
	/**
	 * Promoção Ligth
	 */
	@Test
	public void QuandoLancheForLightEntaoGanhaDescontoDezPorCento() {
		
		//cenário
		CalculaPreco calcula = new Light();
		
		//execução
		Double precoAtual = calcula.calcularValor(Arrays.asList(ovo,alface,hamburguer));
		
		//verificação
		assertEquals(3.78, precoAtual, 0.001);
		
	}
	
}
