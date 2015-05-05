package business;

import model.Usuario;

public interface UsuarioService {
	
	String newUsuario(String login, String password);
	Usuario login(String login, String password);
	Usuario findByLogin(String login);

}
