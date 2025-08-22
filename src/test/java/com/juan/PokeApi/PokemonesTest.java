package com.juan.PokeApi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class PokemonesTest  {

	@Test
	@DisplayName("Constructor de clase")
	@Order(01)
	void test01() throws ExceptionPokemon {
		//
		Pokemones pikachu = new Pokemones("pikachu",40,60);
		assertNotNull(pikachu);
		assertEquals(400, pikachu.getHeigth());
		assertEquals("Pikachu",pikachu.getName().substring(0,1).toUpperCase()+pikachu.getName().substring(1));
		assertEquals(600, pikachu.getWeight());

		
	}

	@Test
	void test02() {
		
	}
	
}
