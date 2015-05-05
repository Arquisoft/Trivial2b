package business.impl;

import java.io.IOException;
import java.util.ArrayList;

import model.Pregunta;
import persistence.impl.CollectionGatewayImpl;
import business.AdminService;
import conf.parser.ParserGIFT;
import conf.parser.ParserToJSON;

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
