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
		
		///System.out.println("Version de MongoDB Driver "+ helper.getDatabase().getMongo().);
      
		// Consultar todos los documentos de la coleccion people
		
		FindIterable<Document> query = helper.getCollection("people").find();
//		System.out.println("Numero de Documentos en people:"+query.size());

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
		Document person = new Document("_id", new ObjectId());
		person.append("mae", "Andrew")
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
		
		
	}

}
