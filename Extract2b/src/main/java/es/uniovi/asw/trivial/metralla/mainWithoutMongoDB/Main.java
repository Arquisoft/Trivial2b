package es.uniovi.asw.trivial.metralla.mainWithoutMongoDB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import es.uniovi.asw.trivial.business.juego.JuegoConsola;
import es.uniovi.asw.trivial.conf.parser.ParserGIFT;
import es.uniovi.asw.trivial.model.Pregunta;

public class Main {

	public static void main(String[] args) throws IOException {
		run();
	}

	public static int run() throws IOException {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(
				System.in));

		System.out.println("Introduzca la ruta del fichero: ");
		String ruta = entrada.readLine();

		int contador = 0;
		// Preguntas
		ArrayList<Pregunta> preguntas;
		if (ruta.toLowerCase().endsWith(".gift")) {
			preguntas = parserGIFTtoPregunta(ruta);
			
			// Juego
			JuegoConsola juegoConsola = new JuegoConsola(preguntas);
			contador = juegoConsola.jugar();
//			ParserToJSON j 	= new ParserToJSON();
//			j.generateJson(preguntas, "Prueba");
		} else {
			System.err.println("No se ha podido cargar el archivo(debe ser formato gift)");
			System.out.println("El programa se cerrará");
		}
		
		return contador;
	}
	
	public static ArrayList<Pregunta> parserGIFTtoPregunta(String ruta) throws IOException{
		return ParserGIFT.parsear(ruta);
	}

}
