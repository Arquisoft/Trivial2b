package persistence;

import model.Usuario;

public interface UsuarioGateway {
	
	String newUsuario(Usuario usuario);
	Usuario login(String login, String password);
	Usuario findByLogin(String login);

}
