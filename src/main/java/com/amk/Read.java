package com.amk;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.function.Consumer;

//Read
public class Read {
	private static final String url="mongodb://localhost";
	public static void main(String[] args) {
		//Conexión a la lista de bases de datos
		try(MongoClient mc= MongoClients.create(url)){
			//Conexión a base de datos
			MongoDatabase mdb=mc.getDatabase("midb");
			//Conexión a colección
			MongoCollection<Document> mcol=mdb.getCollection("pelis-multis");
			//Muestra todos los elementos de la colección
			Consumer<Document> printConsumer=document -> System.out.println(document.toJson());
			mcol.find().forEach(printConsumer);
		}
	}
}

