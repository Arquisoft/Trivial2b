package preguntas;


public class PreguntaMulti implements Pregunta{
	
	private int id;
	private String pregunta;
	private String[] respuestas;
	private String[] contestacion;
	private int correcta;
	
	public PreguntaMulti(int id, String pregunta, String[] respuestas, String[] contestacion, int correcta) {
		this.id = id;
		this.pregunta = pregunta;
		this.respuestas = respuestas;
		this.correcta = correcta;
		this.contestacion = contestacion;
	}
	
	public String toString() {
		String p = "-";
		p += this.id + ". " + this.pregunta + "\n";
		for (int i = 0; i < this.respuestas.length; i++) 
			p += "\t-" + i + ") " + this.respuestas[i] + "\n";
		return p;		
	}
	
	public String toStringDebug() {
		String p = "-";
		p += this.id + "." + this.pregunta + "\n";
		for (int i = 0; i < this.respuestas.length; i++) 
			p += "\t- " + i + ") " + this.respuestas[i] + "--> " + this.contestacion[i] + "\n";
		p += "La respuesta correcta es la: " + this.correcta + ". ";
		p += this.respuestas[this.correcta] + "--> " + this.contestacion[correcta] + "\n";
		return p;		
	}

}
