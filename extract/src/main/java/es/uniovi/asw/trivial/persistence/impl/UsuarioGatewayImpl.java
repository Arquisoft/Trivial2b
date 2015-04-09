package es.uniovi.asw.trivial.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import es.uniovi.asw.trivial.conf.conectionHSQLDB.Conf;
import es.uniovi.asw.trivial.conf.conectionHSQLDB.util.Jdbc;
import es.uniovi.asw.trivial.model.Usuario;
import es.uniovi.asw.trivial.persistence.UsuarioGateway;
import es.uniovi.asw.trivial.persistence.exception.PersistenceException;

public class UsuarioGatewayImpl implements UsuarioGateway{
	
	private Connection con;

	public UsuarioGatewayImpl() {
		try {
			con = Jdbc.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String newUsuario(Usuario usuario){
		PreparedStatement ps = null;
//		int rows = 0;
		
		try {
			ps = con.prepareStatement(Conf.get("SQL_USUARIO_SAVE"));
			
			ps.setString(1, usuario.getLogin());
			ps.setString(2, usuario.getContrasena());
		
			ps.executeUpdate();
//			rows = ps.executeUpdate();
//			if (rows != 1) {
//				throw new AlreadyPersistedException("InfoUsuario " + usuario + " already persisted");
//			} 
			
			 ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		}
		finally  {
			Jdbc.close(ps, con);
		}
		
		return "Nuevo usuario añadido";
		
	}

}
