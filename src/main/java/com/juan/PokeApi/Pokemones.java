package com.juan.PokeApi;

import java.util.ArrayList;

public class Pokemones {
	
	private String name;
	private int heigth;
	private int weight;
	private ArrayList<String> ability;
	public Pokemones(String name, int heigth, int weight, ArrayList<String> ability) throws ExceptionPokemon {
		this.name = name;
		this.heigth = heigth;
		this.weight = weight;
		this.ability = ability;
	}

	public String getName() {
		return name;
	}



	public int getHeigth() {
		return heigth*10;
	}



	public int getWeight() {
		return weight;
	}

	public ArrayList<String> getAbility() {
		return ability;
	}


	public void habilidades() {
		//System.out.println("a");
		for(String e : ability) {
			System.out.println("- "+e);
		}
	}
	
	
	
}
