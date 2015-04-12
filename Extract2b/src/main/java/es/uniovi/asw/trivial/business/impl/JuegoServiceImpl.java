package es.uniovi.asw.trivial.business.impl;

import java.util.List;

import es.uniovi.asw.trivial.business.JuegoService;
import es.uniovi.asw.trivial.model.Pregunta;
import es.uniovi.asw.trivial.persistence.JuegoGateway;
import es.uniovi.asw.trivial.persistence.impl.JuegoGatewayImpl;

public class JuegoServiceImpl implements JuegoService {

	@Override
	public List<Pregunta> getPreguntasCollection(String collection) {
		JuegoGateway j = new JuegoGatewayImpl();
		return j.getPreguntasCollection(collection);
	}

}
