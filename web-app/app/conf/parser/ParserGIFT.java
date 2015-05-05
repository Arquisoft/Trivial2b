package conf.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.Pregunta;
import model.PreguntaMulti;

public class ParserGIFT {
	
	private final static int OPCIONES = 4;
	
	public static ArrayList<Pregunta> parsear(String archivo) throws IOException {
		
		FileReader reader = new FileReader(new File(archivo));
		BufferedReader buffer = new BufferedReader(reader);
		
		ArrayList<Pregunta> preguntas = new ArrayList<>();

		String id = "";
		int correcta = 0;
		String pregunta = "";
		String[] respuestas = new String[OPCIONES];
		String[] contestacion = new String[OPCIONES];
		
		String linea;
		int cont = 0;
		while((linea = buffer.readLine()) != null) {
			if (linea.contains("::")) {
				id = linea.split("::")[1];
				pregunta = linea.split("::")[2].replace("{", "");
			} else if (linea.contains("~")) {
				respuestas[cont] = (linea.split("~")[1]).split("#")[0];
				contestacion[cont] = (linea.split("~")[1]).split("#")[1];
				cont++;
			} else if (linea.contains("=")) {
				respuestas[cont] = (linea.split("=")[1]).split("#")[0];
				contestacion[cont] = (linea.split("=")[1]).split("#")[1];
				correcta = cont++;					
			} else if (linea.equals("}")) {
				cont = 0;
				preguntas.add(new PreguntaMulti(id, pregunta, respuestas, contestacion, correcta));
				respuestas = new String[OPCIONES];
				contestacion = new String[OPCIONES];
			} else {}
		}
		
		buffer.close();
		return preguntas; 
	}

}
