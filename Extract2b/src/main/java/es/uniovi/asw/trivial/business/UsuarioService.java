package es.uniovi.asw.trivial.business;

import es.uniovi.asw.trivial.model.Usuario;

public interface UsuarioService {
	
	String newUsuario(String login, String password);
	Usuario login(String login, String password);
	Usuario findByLogin(String login);

}
