package es.uniovi.asw.trivial.juego;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import es.uniovi.asw.trivial.model.Pregunta;

public class JuegoConsola {

	private ArrayList<Pregunta> preguntas;
	private int contador;
	private BufferedReader entrada;

	public JuegoConsola(ArrayList<Pregunta> preguntas) {
		this.preguntas = preguntas;
		this.contador = 0;
		this.entrada = new BufferedReader(new InputStreamReader(System.in));
	}

	public int jugar() throws NumberFormatException, IOException {
		for (Pregunta p : this.preguntas) {
			System.out.println(p.toString());
			System.out.println("Escoja la respuesta: ");
			int solucion = Integer.parseInt(entrada.readLine());
			System.out.println(p.getContestacion()[solucion]);
			if (solucion == p.getCorrecta()) {
				contador++;
			}
		}
		System.out.println("\nHa acertado: " + contador + " de "
				+ this.preguntas.size() + " preguntas.");
		
		return contador;
	}

}
