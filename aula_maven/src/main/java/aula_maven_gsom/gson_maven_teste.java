package aula_maven_gsom;

import com.google.gson.Gson; 
import com.google.gson.GsonBuilder;

public class gson_maven_teste {

	public static void main(String[] args) {
		

		//contruindo um cliente
		
		String jsonString = "{\"cpf\":\"123\", \"nome\": \"pedro de lara\", \"email\":\"plara@gmail.com\", \"conta\": 5555-0}";
		
		//=================================================================================//
		//instanciar Json para serializar(imprimir)
		
		GsonBuilder builder = new GsonBuilder(); 
	    builder.setPrettyPrinting(); 
	    Gson gson = builder.create(); 
	    
	  //=================================================================================//
	  //a linha abaixo converto a string jSON EM OBJETO
	    
	    Cliente cliente = gson.fromJson(jsonString, Cliente.class);
	    
		
		jsonString = gson.toJson(cliente);
		
		System.out.println(jsonString);
			

	}
}
