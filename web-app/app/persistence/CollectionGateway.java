package persistence;

import java.util.ArrayList;

public interface CollectionGateway {

	String newCollection(ArrayList<String> json, String collection);
	String removeAll();
	
}
