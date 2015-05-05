package model;

public interface Pregunta {

	String toStringDebug();	
	String getPregunta();
	String[] getRespuestas();
	String[] getContestacion();
	int getCorrecta();

	
}
