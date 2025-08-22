package com.juan.PokeApi;


import java.io.IOException;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import okhttp3.*;

public class ApiService {

	private OkHttpClient client = new OkHttpClient();
	
	public Pokemones getPokemon(String nombre) throws IOException{
		//armado de url
		String url = "https://pokeapi.co/api/v2/pokemon/"+nombre.toLowerCase();
		//pedido a la api
		Request request  = new Request.Builder().url(url).build();
		
		//intento de conexcion
		try(Response response = client.newCall(request).execute()){
			if(response.isSuccessful() && response.body()!=null) {
				String json = response.body().string();
				JsonObject jsonObj = JsonParser.parseString(json).getAsJsonObject();
				return new Pokemones(
						jsonObj.get("name").getAsString(),
						jsonObj.get("height").getAsInt(),
						jsonObj.get("weight").getAsInt()
						);
			}else {
				return null;
			}
		}
		
		
		
	}
	
}
