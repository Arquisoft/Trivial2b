package es.uniovi.asw.trivial.conf.parser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

import es.uniovi.asw.trivial.model.Pregunta;

public class ParserToJSON {
	
	Gson gson;
	
	public ParserToJSON() {
		gson = new Gson();
	}
	
	private ArrayList<String> toJson(ArrayList<Pregunta> preguntas) {
		ArrayList<String> preguntasJson = new ArrayList<>();
		for (Pregunta p: preguntas)
			preguntasJson.add(gson.toJson(p));
		return preguntasJson;
	}
	
	public void generateJson(ArrayList<Pregunta> preguntas) throws IOException {
		
		File file = new File("files/preguntasFromIntermedio.json");
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		ArrayList<String> json = toJson(preguntas);
		
		String fichero = "";
		for (String s: json)
			fichero += s + "\n";
		bw.write(fichero);
		bw.close();
	}

}
