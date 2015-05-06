package business.juego;

import java.util.List;
import java.util.Map;
import java.util.Random;

import model.Pregunta;
import model.Usuario;

public class ControladorJuego {
	
	Map<String, List<Pregunta>> preguntas;
	Usuario usuario;
	
	public ControladorJuego(Map<String, List<Pregunta>> preguntas, Usuario usuario) {
		this.preguntas = preguntas;
		this.usuario = usuario;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public Map<String, List<Pregunta>> getPreguntas() {
		return preguntas;
	}
	
	public Pregunta obtenerPreguntaAleatoriaCategoria(String categoria) {
		Random r = new Random();
		return preguntas.get(categoria).
				get(r.nextInt(preguntas.get(categoria).size()));
	}

}
