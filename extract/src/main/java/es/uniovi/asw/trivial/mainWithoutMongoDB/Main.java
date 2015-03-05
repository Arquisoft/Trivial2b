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
		run();
	}

	public static int run() throws IOException {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(
				System.in));

		System.out.println("Introduzca la ruta del fichero: ");
		String ruta = entrada.readLine();

		// parseadores
		// ParserXMLtoJSON xml;
		// ParserToJSON json;

		int contador = 0;
		// Preguntas
		ArrayList<Pregunta> preguntas;
		if (ruta.toLowerCase().endsWith(".gift")) {
			preguntas = parserGIFTtoPregunta(ruta);
			
			// Juego
			JuegoConsola juegoConsola = new JuegoConsola(preguntas);
			contador = juegoConsola.jugar();
		} else {
			System.err.println("No se ha podido cargar el archivo(debe ser formato gift)");
		}
		
		return contador;
	}
	
	public static ArrayList<Pregunta> parserGIFTtoPregunta(String ruta) throws IOException{
		ParserGIFT gift = new ParserGIFT();
		return gift.parsear(ruta);
	}

}
