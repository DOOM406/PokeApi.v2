package com.juan.PokeApi;


import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import okhttp3.*;

public class ApiService {

	private OkHttpClient client = new OkHttpClient();
	
	public Pokemones getPokemon(String nombre) throws Exception{
		//armado de url
		String url = "https://pokeapi.co/api/v2/pokemon/"+nombre.toLowerCase();
		//pedido a la api
		Request request  = new Request.Builder().url(url).build();
		
		//intento de conexion
		try(Response response = client.newCall(request).execute()){
			if(response.isSuccessful() && response.body()!=null) {
				String json = response.body().string();
				
				ArrayList<String> ability = new ArrayList<String>();
				
				JsonObject jsonObj = JsonParser.parseString(json).getAsJsonObject();
				
				jsonObj.getAsJsonArray("abilities").forEach(a->{
					String abilityName = a.getAsJsonObject()
							.getAsJsonObject("ability")
							.get("name")
							.getAsString();
					ability.add(abilityName);
				});
				
				return new Pokemones(
						jsonObj.get("name").getAsString(),
						jsonObj.get("height").getAsInt(),
						jsonObj.get("weight").getAsInt(),
						ability
						);
			}else {
				return null;
			}
		}
		
		
		
	}
	
}
