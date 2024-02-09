package com.amk;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.InsertManyOptions;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

//Create
/*Pelicula:
 - Titulo
 - Director/es (array)
 - Año
 */
public class InsertOne {
	private static final String url="mongodb://localhost";
	public static void main(String[] args) {
		//Conecta al cliente de MongoDB
		try(MongoClient mc= MongoClients.create(url)){
			//Conecta o Crea la base de datos
			MongoDatabase mdb=mc.getDatabase("midb");
			//Conecta o Crea la colección
			MongoCollection<Document> mcol=mdb.getCollection("peliculas");
			Document peli=new Document("_id",new ObjectId());
			//Ejemplo crear una peli
			String titulo="Star Wars";
			List<String> directores=new ArrayList<>();
			directores.add("pepe");
			directores.add("jose");
			int ano=1974;
			peli
					.append("titulo",titulo)
					.append("director/es",directores)
					.append("año",ano);
			mcol.insertOne(peli);

		}
	}
}
