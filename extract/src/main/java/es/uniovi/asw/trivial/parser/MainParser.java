package es.uniovi.asw.trivial.parser;

public class MainParser {

	/*
	 * Main para parsear los fichero GIFT y XML a JSON creando sus respectivos
	 * ficheros JSON en la carpeta files
	 */
	public static void main(String[] args) {
		new ParserXMLtoJSON("files/preguntasXML.xml");
		System.out.println("Parser de XML a JSON completado. (Almacenandose "
				+ "como fichero en files con el nombre preguntasFromXML.json)");
	}

}
