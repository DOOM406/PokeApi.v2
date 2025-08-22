package com.juan.PokeApi;

public class Pokemones {
	
	private String name;
	private int heigth;
	private int weight;
	
	public Pokemones(String name, int heigth, int weight) throws ExceptionPokemon {
		this.name = name;
		this.heigth = heigth;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}



	public int getHeigth() {
		return heigth*10;
	}



	public int getWeight() {
		return weight*10;
	}


	
	
	
}
