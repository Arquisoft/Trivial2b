package es.uniovi.asw.trivial.persistence;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

public class Connection {

	public void connection(){
		try {
			Mongo mongo = new Mongo();
			DB db = mongo.getDB("Preguntas");
			
			DBCollection table = db.getCollection("Preguntas");
			 
			BasicDBObject searchQuery = new BasicDBObject();
			//query que obtiene la pregunta con el id 1
			searchQuery.put("preguntas.tipo1.cuestion.P", "¿Cuál de las siguientes afirmaciones es correcta para un arquitecto de software?");
		 
			DBCursor cursor = table.find(searchQuery);
		 
			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}
	
}	



