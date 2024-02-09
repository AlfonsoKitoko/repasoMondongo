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

public class InsertMultiple {
	private static final String url="mongodb://localhost";
	public static void main(String[] args) {
		//Conecta al cliente de MongoDB
		try(MongoClient mc= MongoClients.create(url)){
			//Conecta o Crea la base de datos
			MongoDatabase mdb=mc.getDatabase("midb");
			//Conecta o Crea la colección
			MongoCollection <Document> mcol=mdb.getCollection("pelis-multis");
			//Ejemplo crear varias pelis
			List<Document> pelis=new ArrayList<>();
			for(int i=0;i<3;i++){
				Document peli=new Document("_id",i);
				String titulo = ""+i;
				String ano = i+""+i+""+i+""+i;
				String director = i+" "+i;
				peli
						.append("titulo", titulo)
						.append("director/es", director)
						.append("año", ano);
				pelis.add(peli);
			}
			mcol.insertMany(pelis,new InsertManyOptions());
		}
	}
}
