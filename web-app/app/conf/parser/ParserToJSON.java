package conf.parser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Pregunta;

import com.google.gson.Gson;

public class ParserToJSON {
	
	static Gson gson;
	
	public ParserToJSON() {
		gson = new Gson();
	}
	
	private static ArrayList<String> toJson(ArrayList<Pregunta> preguntas) {
		gson = new Gson();
		ArrayList<String> preguntasJson = new ArrayList<>();
		for (Pregunta p: preguntas)
			preguntasJson.add(gson.toJson(p));
		return preguntasJson;
	}
	
	public static void generateJson(ArrayList<Pregunta> preguntas, String nombre) throws IOException {

		File file = new File("src/main/java/es/uniovi/asw/trivial/resources/" + nombre + ".json");
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		ArrayList<String> json = toJson(preguntas);
		
		String fichero = "";
		for (String s: json)
			fichero += s + "\n";
		bw.write(fichero);
		bw.close();
	}
	
	public static ArrayList<String> stringJson(ArrayList<Pregunta> preguntas){
		
		return toJson(preguntas);
		
	}

}
