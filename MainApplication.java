package org.mongodb.app;

import org.mongodb.app.controller.MongoHelper;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;

import org.bson.Document;
import org.bson.types.ObjectId;

import static java.util.Arrays.asList; 

public class MainApplication {

	public static void main(String[] args) {
		
		System.out.println("Aplicacion Cliente Java de MongoDB");
		
		MongoHelper helper = new MongoHelper();
		
		helper.Initialize("devmongodb");
		
		System.out.println("Nombre de la Base de Datos:"+ helper.getDatabase().getName());
      
		// Consultar documentos con criterio
		FindIterable<Document> query = helper.getCollection("people")
				                             .find(new Document().append("company", "AWS"));
        System.out.println("Numero de Documentos en people:"+helper.getCollection("people").count());

		for(Document documento: query) {
			System.out.println(documento.toString());			
		}
		
		//  Inserta un documento en la coleccion people
		/*
		 * {
    		"_id" : ObjectId("5f65311e2313fd30f673d6c2"),
    		"name" : "Mary",
    		"gender" : "female",
    		"size" : 1.72,
    		"weight" : 54.0,
    		"phone" : "+51 2345679",
    		"age" : 25.0,
    		"email" : "mary.smith@gmail.com",
    		"company" : "AWS",
    		"isActive" : true,
    		"address" : [ 
        		{
            	"primary" : "100 Boulevard Miami",
            	"secondary" : "303 St. Geneva Rome"
        		}
    		]
			}
		 */
		// Insertar un nuevo documento que contiene sub documentos
		Document person = new Document("_id", new ObjectId());
		person.append("name", "Andrew")
		       .append("gender", "male")
		       .append("size", 1.75)
		       .append("weight", 67.5)
		       .append("phone", "+51 3456723")
		       .append("age", 28.0)
		       .append("email", "andrew.galarreta@gmail.com")
		       .append("company", "AWS")
		       .append("isActive", true)
		       .append("address", asList(new Document().append("primary", "100 Boulevard Miami"),
		    		                     new Document().append("secondary", "303 St. Geneva Rome")));
		
		       
		helper.getCollection("people").insertOne(person);        
		
		// Eliminar documentos con uno o mas criterios
		helper.getCollection("people").dropIndex(new Document().append("company", "Open Cloud"));
		
		// Eliminar la coleccion
		 helper.getCollection("people").drop();
		 
		 // Bson filtro seleccion
		 // Bson sentencia de update
		 // Collection updateOne -> result 
		
	}

}
