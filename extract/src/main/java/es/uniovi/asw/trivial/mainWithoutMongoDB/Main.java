package es.uniovi.asw.trivial.mainWithoutMongoDB;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

import es.uniovi.asw.trivial.juego.JuegoConsola;
import es.uniovi.asw.trivial.model.Pregunta;
import es.uniovi.asw.trivial.parser.ParserGIFT;

public class Main {

	public static void main(String[] args) throws IOException {
		//parseadores
		ParserGIFT parser = new ParserGIFT();
		Gson gson = new Gson();
		
		//preguntas
		ArrayList<Pregunta> preguntas = parser.parsear("files/preguntasGIFT.txt");
		
		
		//System.out.println(gson.toJson(p) + "\n");
		
		JuegoConsola juegoConsola = new JuegoConsola(preguntas);
		juegoConsola.jugar();
		
	}

}
