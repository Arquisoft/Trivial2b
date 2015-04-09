package es.uniovi.asw.trivial.persistence.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.uniovi.asw.trivial.business.conf.Conf;
import es.uniovi.asw.trivial.persistence.Partida_trivialDao;



public class Partida_trivialJdbcDao implements Partida_trivialDao{

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

}
