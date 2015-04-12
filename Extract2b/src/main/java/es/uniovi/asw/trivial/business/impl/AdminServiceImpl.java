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
	public String cargarEnBase(String ruta, String collection) {
		
		ArrayList<Pregunta> preguntas;
		String ret = "";
		
		try {
			//trasformamos el gift en objetos preguntas
			preguntas = ParserGIFT.parsear(ruta);
			
			ArrayList<String> arrayJson = ParserToJSON.stringJson(preguntas);
			
			CollectionGatewayImpl cG = new CollectionGatewayImpl();
			ret = cG.newCollection(arrayJson, collection);
			
		} catch (IOException e) {
			return "Fichero no encontrado(compruebe la ruta)";
		}
		
		return ret;
		
	}

	@Override
	public String removeDataBase() {
		
		CollectionGatewayImpl cG = new CollectionGatewayImpl();
		return cG.removeAll();
		
	}

}
