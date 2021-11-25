package ar.com.learsoft.soap.ws.conecction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private final String DB_URL = "jdbc:h2:file:~/data/soap_db;";//+ "INIT=CREATE SCHEMA IF NOT EXISTS SOAP_DB\\;" +"SET SCHEMA SOAP_DB";
    private final String JDBC_DRIVER = "org.h2.Driver";
    private final String USER = "sql";
    private final String PASS = "sql";
    private static ConnectionFactory instance;
    private Connection connection;

    private ConnectionFactory() {
    	connection=null;
    }

	public static ConnectionFactory getInstance() {
		if (instance == null) {
			instance = new ConnectionFactory();
		}
		return instance;
	}

	public void disconnect() {
		if (connection != null) {
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

    public Connection getConnection() {
    	if (connection==null) {
    		try {
                Class.forName(JDBC_DRIVER);
                connection= DriverManager.getConnection(DB_URL, USER, PASS);

            } catch (SQLException sqle){
                System.out.println("SQLState: " 
                        + sqle.getSQLState());
                     System.out.println("SQLErrorCode: " 
                        + sqle.getErrorCode());
                     sqle.printStackTrace();
            }catch (Exception e) {
            	 e.printStackTrace();
            }
    	}
		return connection;
    }
}