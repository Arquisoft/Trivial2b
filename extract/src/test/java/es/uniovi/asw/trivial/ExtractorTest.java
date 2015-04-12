package es.uniovi.asw.trivial;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import es.uniovi.asw.trivial.metralla.mainWithoutMongoDB.Main;
import es.uniovi.asw.trivial.model.Pregunta;
import es.uniovi.asw.trivial.model.PreguntaMulti;

public class ExtractorTest {
	
	@Test
	public void testPreguntaPrimera() throws IOException {
		ArrayList<Pregunta> preguntas = Main
				.parserGIFTtoPregunta("src/test/java/resources/preguntasGIFT.gift");
		
		System.out.println("Cargado fichero de pruebas preguntasGIFT\n");
		
		String[] respuestas = new String[4];
		respuestas[0] = "center ";
		respuestas[1] = "audio ";
		respuestas[2] = "footer ";
		respuestas[3] = "source ";

		String[] contestacion = new String[4];
		contestacion[0] = " Correcto!";
		contestacion[1] = " Incorrecto.";
		contestacion[2] = " Incorrecto.";
		contestacion[3] = " Incorrecto.";
		
		System.out.println("Prueba sobre la primera pregunta del fichero");

		Pregunta pregunta0 = new PreguntaMulti(
				"1",
				" Cual de los elementos indicados no es un elemento de HTML5?",
				respuestas, contestacion, 0);
		assertEquals(preguntas.get(0), pregunta0);
		
		System.out.println("Primera pregunta guardada en formato intermedio");
		System.out.println("Formato de pregunta con datos extraidos:");
		System.out.println(preguntas.get(0).toStringDebug());
	}
	
	@Test
	public void testPreguntaSegunda() throws IOException {
		ArrayList<Pregunta> preguntas = Main
				.parserGIFTtoPregunta("src/test/java/resources/preguntasGIFT.gift");
		
		System.out.println("Cargado fichero de pruebas preguntasGIFT\n");
		
		String[] respuestas = new String[4];
		respuestas[0] = "Comentarios ";
		respuestas[1] = "Entidades ";
		respuestas[2] = "Instrucciones de procesamiento ";
		respuestas[3] = "Atributos ";

		String[] contestacion = new String[4];
		contestacion[0] = " Incorrecto.";
		contestacion[1] = " Incorrecto.";
		contestacion[2] = " Correcto!";
		contestacion[3] = " Incorrecto.";
		
		System.out.println("Prueba sobre la segunda pregunta del fichero");

		Pregunta pregunta1 = new PreguntaMulti(
				"2",
				" Indica, cual de las siguientes estructuras de SGML no se utiliza en HTML4",
				respuestas, contestacion, 2);
		assertEquals(preguntas.get(1), pregunta1);
		
		System.out.println("Segunda pregunta guardada en formato intermedio");
		System.out.println("Formato de pregunta con datos extraidos:");
		System.out.println(preguntas.get(1).toStringDebug());
		
	}
	
	@Test
	public void testPreguntaTercera() throws IOException {
		ArrayList<Pregunta> preguntas = Main
				.parserGIFTtoPregunta("src/test/java/resources/preguntasGIFT.gift");
		
		System.out.println("Cargado fichero de pruebas preguntasGIFT\n");
		
		String[] respuestas = new String[4];
		respuestas[0] = "section ";
		respuestas[1] = "div ";
		respuestas[2] = "nav ";
		respuestas[3] = "aside ";

		String[] contestacion = new String[4];
		contestacion[0] = " Incorrecto.";
		contestacion[1] = " Incorrecto.";
		contestacion[2] = " Incorrecto.";
		contestacion[3] = " Correcto!";
		
		System.out.println("Prueba sobre la tercera pregunta del fichero");

		Pregunta pregunta2 = new PreguntaMulti(
				"3",
				" Indicar el elemento de HTML5 mas apropiado para ubicar enlaces externos (articulos o sitios recomendados, redes sociales, etc.)",
				respuestas, contestacion, 3);
		assertEquals(preguntas.get(2), pregunta2);	
		
		System.out.println("Tercera pregunta guardada en formato intermedio");
		System.out.println("Formato de pregunta con datos extraidos:");
		System.out.println(preguntas.get(2).toStringDebug());
		
	}
	
	@Test
	public void testPreguntaCuarta() throws IOException {
		ArrayList<Pregunta> preguntas = Main
				.parserGIFTtoPregunta("src/test/java/resources/preguntasGIFT.gift");
		
		System.out.println("Cargado fichero de pruebas preguntasGIFT\n");
		
		String[] respuestas = new String[4];
		respuestas[0] = "summary ";
		respuestas[1] = "border ";
		respuestas[2] = "rowspan ";
		respuestas[3] = "colspan ";

		String[] contestacion = new String[4];
		contestacion[0] = " Correcto!";
		contestacion[1] = " Incorrecto.";
		contestacion[2] = " Incorrecto.";
		contestacion[3] = " Incorrecto.";
		
		System.out.println("Prueba sobre la cuarta pregunta del fichero");

		Pregunta pregunta3 = new PreguntaMulti(
				"4",
				" Cual de los atributos de tabla indicados a continuacion no existe en HTML5",
				respuestas, contestacion, 0);
		assertEquals(preguntas.get(3), pregunta3);	
		
		System.out.println("Cuarta pregunta guardada en formato intermedio");
		System.out.println("Formato de pregunta con datos extraidos:");
		System.out.println(preguntas.get(3).toStringDebug());
		
	}
	
	@Test
	public void testPreguntaQuinta() throws IOException {
		ArrayList<Pregunta> preguntas = Main
				.parserGIFTtoPregunta("src/test/java/resources/preguntasGIFT.gift");
		
		System.out.println("Cargado fichero de pruebas preguntasGIFT\n");
		
		String[] respuestas = new String[4];
		respuestas[0] = "\"textarea\" ";
		respuestas[1] = "\"hidden\" ";
		respuestas[2] = "\"submit\" ";
		respuestas[3] = "\"checkbox\" ";

		String[] contestacion = new String[4];
		contestacion[0] = " Correcto!";
		contestacion[1] = " Incorrecto.";
		contestacion[2] = " Incorrecto.";
		contestacion[3] = " Incorrecto.";
		
		System.out.println("Prueba sobre la quinta pregunta del fichero");

		Pregunta pregunta4 = new PreguntaMulti(
				"5",
				" Indica cual de los siguientes valores no es valido para el atributo type de un input",
				respuestas, contestacion, 0);
		assertEquals(preguntas.get(4), pregunta4);
		
		System.out.println("Quinta pregunta guardada en formato intermedio");
		System.out.println("Formato de pregunta con datos extraidos:");
		System.out.println(preguntas.get(4).toStringDebug());
	}

	
//	@Test
//	public void preguntasCorrectas() throws IOException, InterruptedException {
//		Main main = new Main();
//		ByteArrayInputStream in = new ByteArrayInputStream("files/preguntasGIFT.gift".getBytes());
//		System.setIn(in);
//		main.run();
//		Thread.sleep(5000);
//		in = new ByteArrayInputStream("My string".getBytes());
//		System.setIn(in);
//		
//	}

}
