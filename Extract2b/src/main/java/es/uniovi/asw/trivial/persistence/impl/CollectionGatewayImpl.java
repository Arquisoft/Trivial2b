package es.uniovi.asw.trivial.persistence.impl;

import java.net.UnknownHostException;
import java.util.ArrayList;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.util.JSON;

import es.uniovi.asw.trivial.persistence.CollectionGateway;

public class CollectionGatewayImpl implements CollectionGateway{
	
	private DB db;
	
	public CollectionGatewayImpl() {
		Mongo mongo;
		try {
			mongo = new Mongo("localhost", 27017);
			this.db = mongo.getDB("preguntas");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String newCollection(ArrayList<String> json, String collection) {
		
		/**** Get collection / table from 'preguntas' ****/
		// if collection doesn't exists, MongoDB will create it for you
		DBCollection table = db.getCollection(collection);
		
		// convert JSON to DBObject directly
		for(String p: json){
			DBObject dbObject = (DBObject) JSON.parse(p);			
			table.insert(dbObject);
		}
		 
//		DBCursor cursorDoc = table.find();
//		while (cursorDoc.hasNext()) {
//			System.out.println(cursorDoc.next());
//		}
 
		System.out.println("Nueva colección creada correctamente");
		
		return "Nueva categoría creada correctamente";
	}

	@Override
	public String removeAll() {
		db.dropDatabase();		
		return "Se ha borrado correctamente la base de datos";
	}

}
