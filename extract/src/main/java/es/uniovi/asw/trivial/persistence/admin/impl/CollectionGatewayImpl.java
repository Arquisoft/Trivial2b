package es.uniovi.asw.trivial.persistence.admin.impl;

import java.net.UnknownHostException;
import java.util.ArrayList;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.util.JSON;

import es.uniovi.asw.trivial.persistence.admin.CollectionGateway;

public class CollectionGatewayImpl implements CollectionGateway{

	@Override
	public void newCollection(ArrayList<String> json, String collection) {
		
		try{
			
			Mongo mongo = new Mongo("localhost", 27017);
			DB db = mongo.getDB("preguntas");
			
			/**** Get collection / table from 'testdb' ****/
			// if collection doesn't exists, MongoDB will create it for you
			DBCollection table = db.getCollection(collection);
			
			// convert JSON to DBObject directly
			for(String p: json){
				DBObject dbObject = (DBObject) JSON.parse(p);
				
				table.insert(dbObject);
			}
			 
			DBCursor cursorDoc = table.find();
			while (cursorDoc.hasNext()) {
				System.out.println(cursorDoc.next());
			}
 
			System.out.println("Nueva colección creada correctamente");
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeAll() {
		
		Mongo mongo;
		try {
			
			mongo = new Mongo("localhost", 27017);
			DB db = mongo.getDB("preguntas");
			
			db.dropDatabase();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
