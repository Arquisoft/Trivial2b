package es.uniovi.asw.trivial.persistence;

import es.uniovi.asw.trivial.model.Usuario;

public interface UsuarioGateway {
	
	String newUsuario(Usuario usuario);
	Usuario login(String login, String password);

}
