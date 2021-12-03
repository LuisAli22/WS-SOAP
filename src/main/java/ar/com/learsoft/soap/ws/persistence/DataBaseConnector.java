package ar.com.learsoft.soap.ws.persistence;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import static ar.com.learsoft.soap.ws.utils.Definitions.*;


public class DataBaseConnector {
	private volatile static DataBaseConnector instance;
	private Connection connection;
	private DataBaseConnector() {}
	public static DataBaseConnector getInstance() {
		if (instance == null) {
			synchronized(DataBaseConnector.class) {
				instance = new DataBaseConnector();
			}
		}
		return instance;
	}
	
	public Connection getConnection() {
		try {
			 Context initialContext=  new InitialContext();
			 Context environmentContext = 
				(Context) initialContext.lookup(JNDI_COMPONENTS_ENVIRONMENT);
			 DataSource dataSource = 
					 (DataSource) environmentContext.lookup(SOAP_DB_RESOURCE);
			 connection= dataSource.getConnection();
			 connection.setAutoCommit(true);
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
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
}
