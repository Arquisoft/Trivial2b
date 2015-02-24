package es.uniovi.asw.trivial;


public class Extractor {

	public void usage() {
		System.out.println("Wellcome to Trivial Extractor");
		new ParserXMLtoJSON("files/preguntasXML.xml");
	}

	public int run(String[] args) {
		if (args.length == 0) {
			usage();
			return 0;
		}
		return -1;
	}

	public static void main(String[] args) {
		new Extractor().run(args);
	}
}
