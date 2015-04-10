package es.uniovi.asw.trivial.business.juego;

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
			String solucion;
			while (!isNum(solucion = entrada.readLine())
					|| Integer.parseInt(solucion) > p
							.getContestacion().length - 1
					|| Integer.parseInt(solucion) < 0)
				System.out.println("Debe introducir un valor entre 0 y "
						+ (p.getContestacion().length - 1)
						+ ". Escoja la respuesta: ");
			System.out.println(p.getContestacion()[Integer.parseInt(solucion)]);
			if (Integer.parseInt(solucion) == p.getCorrecta()) {
				contador++;
			}
		}
		System.out.println("\nHa acertado: " + contador + " de "
				+ this.preguntas.size() + " preguntas.");

		return contador;
	}
	
	private boolean isNum(String num) {
		try {
			Integer.parseInt(num);
			return true;
		} catch (Exception e){
			return false;
		}
	}

}
