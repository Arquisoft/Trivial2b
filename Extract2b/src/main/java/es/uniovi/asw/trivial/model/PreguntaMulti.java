package es.uniovi.asw.trivial.model;

import java.util.Arrays;

public class PreguntaMulti implements Pregunta {

	private String id;
	private String pregunta;
	private String[] respuestas;
	private String[] contestacion;
	private int correcta;

	public PreguntaMulti(String id, String pregunta, String[] respuestas,
			String[] contestacion, int correcta) {
		this.id = id;
		this.pregunta = pregunta;
		this.respuestas = respuestas;
		this.correcta = correcta;
		this.contestacion = contestacion;
	}

	public String getPregunta() {
		return pregunta;
	}
	
	public String[] getRespuestas() {
		return respuestas;
	}
	
	public String[] getContestacion() {
		return contestacion;
	}

	public int getCorrecta() {
		return correcta;
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
			p += "\t- " + i + ") " + this.respuestas[i] + "--> "
					+ this.contestacion[i] + "\n";
		p += "La respuesta correcta es la: " + this.correcta + ". ";
		p += this.respuestas[this.correcta] + "--> "
				+ this.contestacion[correcta] + "\n";
		return p;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(contestacion);
		result = prime * result + correcta;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((pregunta == null) ? 0 : pregunta.hashCode());
		result = prime * result + Arrays.hashCode(respuestas);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PreguntaMulti other = (PreguntaMulti) obj;
		if (!Arrays.equals(contestacion, other.contestacion))
			return false;
		if (correcta != other.correcta)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pregunta == null) {
			if (other.pregunta != null)
				return false;
		} else if (!pregunta.equals(other.pregunta))
			return false;
		if (!Arrays.equals(respuestas, other.respuestas))
			return false;
		return true;
	}	

}
