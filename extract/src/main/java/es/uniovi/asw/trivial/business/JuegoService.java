package es.uniovi.asw.trivial.business;

import java.util.List;

import es.uniovi.asw.trivial.model.Pregunta;

public interface JuegoService {
	
	List<Pregunta> getPreguntasCollection(String collection);

}
