package es.uniovi.asw.trivial;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import es.uniovi.asw.trivial.mainWithoutMongoDB.Main;
import es.uniovi.asw.trivial.model.Pregunta;
import es.uniovi.asw.trivial.model.PreguntaMulti;

public class ExtractorTest {

	@Test
	public void testPreguntas() throws IOException {
		ArrayList<Pregunta> preguntas = Main
				.parserGIFTtoPregunta("files/preguntasGIFT.gift");
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

		Pregunta pregunta0 = new PreguntaMulti(
				"1",
				" Cual de los elementos indicados no es un elemento de HTML5?",
				respuestas, contestacion, 0);
		assertEquals(preguntas.get(0), pregunta0);
		
		
		

		respuestas = new String[4];
		respuestas[0] = "Comentarios ";
		respuestas[1] = "Entidades ";
		respuestas[2] = "Instrucciones de procesamiento ";
		respuestas[3] = "Atributos ";

		contestacion = new String[4];
		contestacion[0] = " Incorrecto.";
		contestacion[1] = " Incorrecto.";
		contestacion[2] = " Correcto!";
		contestacion[3] = " Incorrecto.";

		Pregunta pregunta1 = new PreguntaMulti(
				"2",
				" Indica, cual de las siguientes estructuras de SGML no se utiliza en HTML4",
				respuestas, contestacion, 2);
		assertEquals(preguntas.get(1), pregunta1);
		
		
		

		respuestas = new String[4];
		respuestas[0] = "section ";
		respuestas[1] = "div ";
		respuestas[2] = "nav ";
		respuestas[3] = "aside ";

		contestacion = new String[4];
		contestacion[0] = " Incorrecto.";
		contestacion[1] = " Incorrecto.";
		contestacion[2] = " Incorrecto.";
		contestacion[3] = " Correcto!";

		Pregunta pregunta2 = new PreguntaMulti(
				"3",
				" Indicar el elemento de HTML5 mas apropiado para ubicar enlaces externos (articulos o sitios recomendados, redes sociales, etc.)",
				respuestas, contestacion, 3);
		assertEquals(preguntas.get(2), pregunta2);
		
		
		
		
		respuestas = new String[4];
		respuestas[0] = "summary ";
		respuestas[1] = "border ";
		respuestas[2] = "rowspan ";
		respuestas[3] = "colspan ";

		contestacion = new String[4];
		contestacion[0] = " Correcto!";
		contestacion[1] = " Incorrecto.";
		contestacion[2] = " Incorrecto.";
		contestacion[3] = " Incorrecto.";

		Pregunta pregunta3 = new PreguntaMulti(
				"4",
				" Cual de los atributos de tabla indicados a continuacion no existe en HTML5",
				respuestas, contestacion, 0);
		assertEquals(preguntas.get(3), pregunta3);
		
		
		
		
		respuestas = new String[4];
		respuestas[0] = "\"textarea\" ";
		respuestas[1] = "\"hidden\" ";
		respuestas[2] = "\"submit\" ";
		respuestas[3] = "\"checkbox\" ";

		contestacion = new String[4];
		contestacion[0] = " Correcto!";
		contestacion[1] = " Incorrecto.";
		contestacion[2] = " Incorrecto.";
		contestacion[3] = " Incorrecto.";

		Pregunta pregunta4 = new PreguntaMulti(
				"5",
				" Indica cual de los siguientes valores no es valido para el atributo type de un input",
				respuestas, contestacion, 0);
		assertEquals(preguntas.get(4), pregunta4);
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
