<<<<<<< HEAD
<<<<<<< HEAD
package es.uniovi.asw.trivial.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			ps.setObject(2, usuario.getContrasena());
		
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

	@Override
	public Usuario login(String login, String password) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Usuario user = null;
		
		try {
			ps = con.prepareStatement(Conf.get("SQL_USUARIO_LOGIN"));
			
			ps.setString(1, login);
			ps.setString(2, password);
		
			rs = ps.executeQuery();
			
			if(rs.next()) {
				user = new Usuario(rs.getString(1), rs.getString(2));
			}
			
			ps.close();			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		}
		finally  {
			Jdbc.close(ps, con);
		}
		
		return user;
	}

	@Override
	public Usuario findByLogin(String login) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Usuario user = null;
		
		try {
			ps = con.prepareStatement(Conf.get("SQL_FIND_USER_BYLOGIN"));
			
			ps.setString(1, login);
			
		
			rs = ps.executeQuery();
			
			if(rs.next()) {
				user = new Usuario(rs.getString(1), rs.getString(2));
			}
			
			ps.close();			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		}
		finally  {
			Jdbc.close(ps, con);
		}
		return user;
	}

}
=======
package es.uniovi.asw.trivial.persistence.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
=======
package es.uniovi.asw.trivial.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
>>>>>>> parent of 718e7d1... a

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
			ps.setObject(2, usuario.getContrasena());
		
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

	@Override
	public Usuario login(String login, String password) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Usuario user = null;
		
		try {
			ps = con.prepareStatement(Conf.get("SQL_USUARIO_LOGIN"));
			
			ps.setString(1, login);
			ps.setString(2, password);
		
			rs = ps.executeQuery();
			
			if(rs.next()) {
				user = new Usuario(rs.getString(1), rs.getString(2));
			}
			
			ps.close();			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		}
		finally  {
			Jdbc.close(ps, con);
		}
		
		return user;
	}

	@Override
	public Usuario findByLogin(String login) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Usuario user = null;
		
		try {
			ps = con.prepareStatement(Conf.get("SQL_FIND_USER_BYLOGIN"));
			
			ps.setString(1, login);
			
		
			rs = ps.executeQuery();
			
			if(rs.next()) {
				user = new Usuario(rs.getString(1), rs.getString(2));
			}
			
			ps.close();			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Invalid SQL or database schema", e);
		}
		finally  {
			Jdbc.close(ps, con);
		}
		return user;
	}

<<<<<<< HEAD
	public String recuperaDatos() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		String estado="";
		
		try {
			// En una implementaciï¿½ï¿½n mï¿½ï¿½s sofisticada estas constantes habrï¿½ï¿½a 
			// que sacarlas a un sistema de configuraciï¿½ï¿½n: 
			// xml, properties, descriptores de despliege, etc 
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";

			// Obtenemos la conexiï¿½ï¿½n a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			ps = con.prepareStatement(Conf.get("findPartidas"));
			
			rs = ps.executeQuery();
			while (rs.next()) {
				Calendar c=Calendar.getInstance();
				c.setTimeInMillis((long) rs.getDouble("FECHA"));
				estado+="Partida:   "+rs.getInt("ID_PARTIDA")+" , Jugador:   "+rs.getString("LOGIN")+" , Fecha:   "+c.getTime().toString()+" \n";
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally  {
			if (rs != null) {try{ rs.close(); } catch (Exception ex){}};
			if (ps != null) {try{ ps.close(); } catch (Exception ex){}};
			if (con != null) {try{ con.close(); } catch (Exception ex){}};
		}
		
		return estado;
	}

	public int findIdByLogin(String login) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		int estado=-1;
		
		try {
			// En una implementaci��n m��s sofisticada estas constantes habr��a 
			// que sacarlas a un sistema de configuraci��n: 
			// xml, properties, descriptores de despliege, etc 
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";

			// Obtenemos la conexi��n a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			ps = con.prepareStatement(Conf.get("findUsuarioByLogin"));
			ps.setString(1, login);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				estado=rs.getInt("ID");
			}
	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally  {
			if (rs != null) {try{ rs.close(); } catch (Exception ex){}};
			if (ps != null) {try{ ps.close(); } catch (Exception ex){}};
			if (con != null) {try{ con.close(); } catch (Exception ex){}};
		}
		
		return estado;
	}

	public int getIdUltima() {

		int id=-1;
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		
		try {
			// En una implementaci��n m��s sofisticada estas constantes habr��a 
			// que sacarlas a un sistema de configuraci��n: 
			// xml, properties, descriptores de despliege, etc 
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";

			// Obtenemos la conexi��n a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			ps = con.prepareStatement(Conf.get("ultimaPartida"));
			
			rs=ps.executeQuery();
			if(rs.next())
				id=rs.getInt("ID_PARTIDA");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally  {
			if (ps != null) {try{ ps.close(); } catch (Exception ex){}};
			if (rs != null) {try{ rs.close(); } catch (Exception ex){}};
			if (con != null) {try{ con.close(); } catch (Exception ex){}};
		}
		return id;
	}

	public void saveJuega(int id, int idUser) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		Connection con = null;
		
		try {

			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";

			// Obtenemos la conexi��n a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			ps = con.prepareStatement(Conf.get("insertaJuega"));
			ps.setInt(1,id);
			ps.setInt(2,idUser);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally  {
			if (ps != null) {try{ ps.close(); } catch (Exception ex){}};
			if (con != null) {try{ con.close(); } catch (Exception ex){}};
		}
		
	}
	
	public void insertarPartida() {
		// TODO Auto-generated method stub
				PreparedStatement ps = null;
				Connection con = null;
				
				try {
					// En una implementaci��n m��s sofisticada estas constantes habr��a 
					// que sacarlas a un sistema de configuraci��n: 
					// xml, properties, descriptores de despliege, etc 
					String SQL_DRV = "org.hsqldb.jdbcDriver";
					String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";

					// Obtenemos la conexi��n a la base de datos.
					Class.forName(SQL_DRV);
					con = DriverManager.getConnection(SQL_URL, "sa", "");
					ps = con.prepareStatement(Conf.get("crearPartida"));
					ps.setDouble(1, System.currentTimeMillis());
					
					ps.executeUpdate();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally  {
					if (ps != null) {try{ ps.close(); } catch (Exception ex){}};
					if (con != null) {try{ con.close(); } catch (Exception ex){}};
				}
		
	}

}
>>>>>>> origin/master
=======
}
>>>>>>> parent of 718e7d1... a
