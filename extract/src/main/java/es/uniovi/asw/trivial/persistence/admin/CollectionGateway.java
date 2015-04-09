package es.uniovi.asw.trivial.persistence.admin;

import java.util.ArrayList;

public interface CollectionGateway {

	void newCollection(ArrayList<String> json, String collection);
	void removeAll();
	
}
