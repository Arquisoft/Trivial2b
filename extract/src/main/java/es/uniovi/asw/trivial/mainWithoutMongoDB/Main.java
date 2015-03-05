package es.uniovi.asw.trivial.mainWithoutMongoDB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import es.uniovi.asw.trivial.juego.JuegoConsola;
import es.uniovi.asw.trivial.model.Pregunta;
import es.uniovi.asw.trivial.parser.ParserGIFT;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Introduzca la ruta del fichero: ");
		String ruta = entrada.readLine();
		
		//parseadores
		ParserGIFT gift;
//		ParserXMLtoJSON xml;
//		ParserToJSON json;
		
		//Preguntas
		ArrayList<Pregunta> preguntas;
		if (ruta.toLowerCase().endsWith(".gift")) {
			gift = new ParserGIFT();
			preguntas = gift.parsear(ruta);
		} else {
			preguntas = new ArrayList<Pregunta>();
		}
		
		//Juego				
		JuegoConsola juegoConsola = new JuegoConsola(preguntas);
		juegoConsola.jugar();
		
	}

}
