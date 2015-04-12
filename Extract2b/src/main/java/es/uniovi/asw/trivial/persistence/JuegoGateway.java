package es.uniovi.asw.trivial.persistence;

import java.util.List;

import es.uniovi.asw.trivial.model.Pregunta;

public interface JuegoGateway {
	
	List<Pregunta> getPreguntasCollection(String collection);

}
