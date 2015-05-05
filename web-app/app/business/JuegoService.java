package business;

import java.util.List;

import model.Pregunta;

public interface JuegoService {
	
	List<Pregunta> getPreguntasCollection(String collection);

}
