package main;

import java.io.IOException;
import java.util.ArrayList;

import parser.ParserGIFT;
import preguntas.Pregunta;

import com.google.gson.Gson;

public class main {

	public static void main(String[] args) throws IOException {
		ParserGIFT parser = new ParserGIFT();
		ArrayList<Pregunta> preguntas = parser.parsear("preguntasGIFT.txt");
		Gson gson = new Gson();
		for (Pregunta p: preguntas) {
			System.out.println(p.toStringDebug());
			System.out.println(gson.toJson(p) + "\n");
		}
	}

}
