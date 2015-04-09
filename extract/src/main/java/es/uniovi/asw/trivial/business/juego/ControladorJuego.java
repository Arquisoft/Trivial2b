package es.uniovi.asw.trivial.business.juego;

import java.util.List;
import java.util.Map;

import es.uniovi.asw.trivial.model.Pregunta;
import es.uniovi.asw.trivial.model.Usuario;

public class ControladorJuego {
	
	Map<String, List<Pregunta>> preguntas;
	List<Usuario> usuarios;
	
	public ControladorJuego(Map<String, List<Pregunta>> preguntas, List<Usuario> usuarios) {
		this.preguntas = preguntas;
		this.usuarios = usuarios;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public Map<String, List<Pregunta>> getPreguntas() {
		return preguntas;
	}

}
