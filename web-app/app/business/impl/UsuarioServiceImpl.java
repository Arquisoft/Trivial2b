package business.impl;

import model.Usuario;
import persistence.UsuarioGateway;
import persistence.impl.UsuarioGatewayImpl;
import business.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService{

	@Override
	public String newUsuario(String login, String password) {
		Usuario u = new Usuario(login, password);
		UsuarioGateway uG = new UsuarioGatewayImpl();
		return uG.newUsuario(u);
	}

	@Override
	public Usuario login(String login, String password) {
		UsuarioGateway uG = new UsuarioGatewayImpl();
		return uG.login(login, password);
	}

	@Override
	public Usuario findByLogin(String login) {
		UsuarioGateway uG = new UsuarioGatewayImpl();
		return uG.findByLogin(login);
	}

}
