package es.uniovi.asw.trivial.business.impl;

import java.io.IOException;
import java.util.ArrayList;

import es.uniovi.asw.trivial.business.AdminService;
import es.uniovi.asw.trivial.conf.parser.ParserGIFT;
import es.uniovi.asw.trivial.conf.parser.ParserToJSON;
import es.uniovi.asw.trivial.model.Pregunta;
import es.uniovi.asw.trivial.persistence.impl.CollectionGatewayImpl;

public class AdminServiceImpl implements AdminService{


	@Override
	public void cargarEnBase(String ruta, String collection) {
		
		ArrayList<Pregunta> preguntas;
		try {
			//trasformamos el gift en objetos preguntas
			preguntas = ParserGIFT.parsear(ruta);
			
			ArrayList<String> arrayJson = ParserToJSON.stringJson(preguntas);
			
			CollectionGatewayImpl cG = new CollectionGatewayImpl();
			cG.newCollection(arrayJson, collection);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void removeDataBase() {
		
		CollectionGatewayImpl cG = new CollectionGatewayImpl();
		cG.removeAll();
		
	}

}
