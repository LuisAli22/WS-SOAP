package ar.com.learsoft.soap.ws.conecction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class DataSource {
	private static DataSource instance;
	private Connection connection;
	private DataSource() {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			javax.sql.DataSource ds = (javax.sql.DataSource) envCtx.lookup("jdbc/soap_db");
			Connection adminConnection= ds.getConnection();
			String sql = "CREATE CACHED TABLE IF NOT EXISTS AFIP_CHECKER "
					+"(ID BIGINT not NULL, "
					+ " APP_SERVER VARCHAR(255), " 
					+ " AUTH_SERVER VARCHAR(255), " 
					+ " DB_SERVER VARCHAR(255), "
					+ " PRIMARY KEY ( ID ))";
			PreparedStatement statement = adminConnection.prepareStatement(sql);
			statement.execute();
			adminConnection.commit();
			statement.close();
			adminConnection.close();

		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
	}
	public static DataSource getInstance() {
		if (instance == null) {
			instance = new DataSource();
		}
		return instance;
	}
	
	public Connection getConnection() {
		try {
			 Context initCtx=  new InitialContext();
			 Context envCtx = (Context) initCtx.lookup("java:comp/env");
			 javax.sql.DataSource ds = (javax.sql.DataSource) envCtx.lookup("jdbc/soap_db");
			 connection= ds.getConnection();
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
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
