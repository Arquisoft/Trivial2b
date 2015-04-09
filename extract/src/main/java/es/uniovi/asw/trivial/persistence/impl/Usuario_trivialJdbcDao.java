package es.uniovi.asw.trivial.persistence.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;

import es.uniovi.asw.trivial.business.conf.Conf;
import es.uniovi.asw.trivial.persistence.Usuario_trivialDao;
import es.uniovi.asw.trivial.persistence.exception.NoExisteUsuarioException;


public class Usuario_trivialJdbcDao implements Usuario_trivialDao {

	public boolean findByLogin(String login, String pass) throws NoExisteUsuarioException {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rs = null;
		PreparedStatement ps2 = null;
		ResultSet rs2 = null;
		Connection con = null;
		boolean estado=false;
		
		try {
			// En una implementaci��n m��s sofisticada estas constantes habr��a 
			// que sacarlas a un sistema de configuraci��n: 
			// xml, properties, descriptores de despliege, etc 
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";

			// Obtenemos la conexi��n a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			ps = con.prepareStatement(Conf.get("findUsuario"));
			ps.setString(1, login);
			
			rs = ps.executeQuery();
			if (!rs.next()) {
				throw new NoExisteUsuarioException();
			}
			
			ps2 = con.prepareStatement(Conf.get("findUsuarioPass"));
			ps2.setString(1, login);
			ps2.setString(2,pass);
			
			rs2 = ps2.executeQuery();
			if (rs2.next()) {
				estado=true;
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
			if (rs2 != null) {try{ rs2.close(); } catch (Exception ex){}};
			if (ps2 != null) {try{ ps2.close(); } catch (Exception ex){}};
			if (con != null) {try{ con.close(); } catch (Exception ex){}};
		}
		
		return estado;
	}

	public void registro(String nombre, String pass) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		Connection con = null;
		
		try {

			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";

			// Obtenemos la conexi��n a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			ps = con.prepareStatement(Conf.get("crearUsuario"));
			ps.setString(1, nombre);
			ps.setString(2, pass);
			
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
						estado=rs.getInt("ID_USUARIO");
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

}
