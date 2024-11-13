package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MiConexion {

	public static void main(String[] args) {

		// Antes de la direccion, debes poner antes jdbc:mysql://
		// El puerto es 3306
		String url = "jdbc:mysql://dns11036.phdns11.es:3306/ad2425_jgarcia";
		String usuario = "jgarcia";
		String contrasennia = "12345";

		try {
			// No olvides el Class para establecer la conexion
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, usuario, contrasennia);
			
			
			System.out.println("Conexión exitosa");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}
