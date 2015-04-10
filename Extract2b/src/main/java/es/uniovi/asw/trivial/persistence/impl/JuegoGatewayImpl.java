package es.uniovi.asw.trivial.persistence.impl;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

import es.uniovi.asw.trivial.model.Pregunta;
import es.uniovi.asw.trivial.model.PreguntaMulti;
import es.uniovi.asw.trivial.persistence.JuegoGateway;

public class JuegoGatewayImpl implements JuegoGateway {
	
	private DB db;
	
	public JuegoGatewayImpl() {
		Mongo mongo;
		try {
			mongo = new Mongo("localhost", 27017);
			this.db = mongo.getDB("preguntas");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Pregunta> getPreguntasCollection(String collection) {
		DBCursor c = db.getCollection(collection).find();		
		Gson g = new Gson();		
		List<Pregunta> preguntas = new ArrayList<>();		
		while (c.hasNext()) {
			preguntas.add(g.fromJson(c.next().toString(), PreguntaMulti.class));
		}
				
//		for (Pregunta p: preg)
//			System.out.println(p.toStringDebug());
		
		return preguntas;
	}

}
