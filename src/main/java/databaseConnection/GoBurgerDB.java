package databaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GoBurgerDB {

	public Connection conexion;
	
	public Connection conectar() throws SQLException {
		
	
		String url = "";
		String usuario = "";
		String pass = "";
		
	
			url = "jdbc:mysql://localhost:3306/goburgertpv";
			usuario = "root";
			pass = "";
			
			
			conexion = DriverManager.getConnection(url, usuario, pass);
			return conexion;
	}	
}
