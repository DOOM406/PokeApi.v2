package com.juan.PokeApi;

import java.io.IOException;
import java.util.Scanner;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import okhttp3.*;
public class App {
	
	public static void main(String[] args) throws IOException {
		
		ApiService service = new ApiService();
		OkHttpClient client = new OkHttpClient();
		Scanner sc = new Scanner(System.in);
		System.out.println("Bienvenido a la PokeApi!");
		
		while(true) {
			System.out.println("Introduzca el nombre de su pokemon: ");
			String nombre = sc.nextLine();
			if(nombre.equalsIgnoreCase("Salir")) {
				System.out.println("Gracias por su visita!");
				break;
			}
			
			Pokemones pokemon = service.getPokemon(nombre);
			if(pokemon!=null) {
				menuPokemon(pokemon, sc);
			}else {
				System.out.println("El pokemon no se encuentra en nuestro libro");
			}
			
		}
	}
	
	public static void menuPokemon(Pokemones pokemons, Scanner sc) {
		System.out.println("Tu pokemon ha sido encontrado!\n Que deseas ver de el?");
		
		int bandera=1;
		while(bandera==1) {
			System.out.println("-Name\n-Height\n-Weight\n-Salir");
			String valor = sc.nextLine().toLowerCase();
			switch (valor) {
			case "name":

				System.out.println("El nombre de tu pokemon es: "+pokemons.getName());
				System.out.println("Desea ver algo mas?");
				break;
			case "height":
				System.out.println("La altura de tu pokemons es de "+pokemons.getHeigth()+"cm");
				System.out.println("Desea ver algo mas?\n: ");
				break;
			case "weight":
				
				System.out.println("El peso de tu pokemon es de "+pokemons.getWeight()+"kg.");
				System.out.println("Desea ver algo mas?\n: ");
				break;
			case "salir":
				bandera=0;
				break;
			default:
				System.out.println("No se reconoce la palabra.");
				break;
			}
		}
	}

}
