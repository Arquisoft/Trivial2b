package business.impl;

import java.util.List;

import model.Pregunta;
import persistence.JuegoGateway;
import persistence.impl.JuegoGatewayImpl;
import business.JuegoService;

public class JuegoServiceImpl implements JuegoService {

	@Override
	public List<Pregunta> getPreguntasCollection(String collection) {
		JuegoGateway j = new JuegoGatewayImpl();
		return j.getPreguntasCollection(collection);
	}

}
