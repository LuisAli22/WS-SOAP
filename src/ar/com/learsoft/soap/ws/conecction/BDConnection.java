package ar.com.learsoft.soap.ws.conecction;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class BDConnection {

	protected Connection bDConecction = null;
	
	
	
	//JDBC URL de la BD y nombre del Driver
	private final String DB_URL = "jdbc:h2:file:~/data/soap_db";
	private final String JDBC_DRIVER = "org.h2.Driver";
	
	// Credencial de la BD
	private final String USER = "sql";
	private final String PASS = "sql";
	
	
	public void conectarDB() throws Exception {
		try {
			Class.forName(JDBC_DRIVER);
			bDConecction = DriverManager.getConnection(DB_URL, USER, PASS);
			
		} catch (Exception e) {
			throw e;
			
		}
		
	}
	public void desconectarBD() throws SQLException {
		if (bDConecction != null) {
			if(!bDConecction.isClosed()) {
				bDConecction.close();

		}
	}
}
}

