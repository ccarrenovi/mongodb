package org.mongodb.app.controller;

import java.net.UnknownHostException;

import org.bson.Document;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class MongoHelper {
	
	private MongoClient client;
	private String HOST_NAME="localhost";
	private Integer PORT_NUMBER=new Integer(27017);
	
	private MongoDatabase database = null;
	private MongoCollection<Document> collection = null;
	
	public MongoHelper() {
		super();
        client = new MongoClient(HOST_NAME, PORT_NUMBER);	    	
	}

	public MongoDatabase getDatabase() {
		return database;
	}

	public void setDatabase(MongoDatabase database) {
		this.database = database;
	}

	public MongoCollection<Document> getCollection(String collectionName) {
		collection = getDatabase().getCollection(collectionName);
		return collection;
	}

	public void setCollection(MongoCollection<Document> collection) {
		this.collection = collection;
	}

	public void Initialize(String databaseName) {
		setDatabase(client.getDatabase(databaseName));
	}
	
	public void dropDatabase(String dbName) {
		client.dropDatabase(dbName);
	}
	
	public void dropCollection(String collectionName) {
		this.getDatabase().getCollection(collectionName).drop();
	}

	
	
}
