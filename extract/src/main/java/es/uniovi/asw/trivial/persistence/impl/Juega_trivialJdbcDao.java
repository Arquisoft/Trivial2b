package es.uniovi.asw.trivial.persistence.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import es.uniovi.asw.trivial.business.conf.Conf;
import es.uniovi.asw.trivial.persistence.Juega_trivialDao;


public class Juega_trivialJdbcDao implements Juega_trivialDao{

	@Override
	public void save(int idpartida, int idUsuario) {
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
					ps.setInt(1,idpartida);
					ps.setInt(2,idUsuario);
					
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

	public String recuperaDatos() {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		String estado="";
		
		try {
			// En una implementaci��n m��s sofisticada estas constantes habr��a 
			// que sacarlas a un sistema de configuraci��n: 
			// xml, properties, descriptores de despliege, etc 
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/localDB";

			// Obtenemos la conexi��n a la base de datos.
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

	

}
