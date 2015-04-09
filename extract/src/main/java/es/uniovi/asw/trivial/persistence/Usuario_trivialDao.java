package es.uniovi.asw.trivial.persistence;

import javax.swing.JTextField;

import es.uniovi.asw.trivial.persistence.exception.NoExisteUsuarioException;


public interface Usuario_trivialDao {
	
	/**
	 * Nos dice si existe o no un usuario, y si la contraseña es correcta
	 * @param login del usuario que queremos comprobar
	 * @return true en caso de exita. False si no.
	 * @throws NoExisteUsuarioException Si el usuario no existe
	 */
	boolean findByLogin(String login,String pass) throws NoExisteUsuarioException;
	
	void registro(String nombre, String pass);

	
	int findIdByLogin(String login);
}
