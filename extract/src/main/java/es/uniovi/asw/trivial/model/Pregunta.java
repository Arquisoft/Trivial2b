package es.uniovi.asw.trivial.model;

public interface Pregunta {

	String toStringDebug();

	
	
	String getPregunta();
	String[] getRespuestas();
	String[] getContestacion();
	int getCorrecta();

	
}
