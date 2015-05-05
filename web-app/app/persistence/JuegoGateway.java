package persistence;

import java.util.List;

import model.Pregunta;

public interface JuegoGateway {
	
	List<Pregunta> getPreguntasCollection(String collection);

}
