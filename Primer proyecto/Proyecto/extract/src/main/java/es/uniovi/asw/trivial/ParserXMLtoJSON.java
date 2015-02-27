package es.uniovi.asw.trivial;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import org.json.JSONObject;
import org.json.XML;

public class ParserXMLtoJSON {

	public ParserXMLtoJSON(String nameXML) {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(nameXML)));
			String line;
			StringBuilder sb = new StringBuilder();

			while ((line = br.readLine()) != null) {
				sb.append(line.trim());
			}
			br.close();

			JSONObject xmlJSONObj = XML.toJSONObject(sb.toString());
			String jsonPrettyPrintString = xmlJSONObj.toString(4);
			
			File file = new File("files/preguntas.json");
 
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(jsonPrettyPrintString);
			bw.close();
 
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
