package ar.com.learsoft.soap.ws.conecction;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;

import ar.com.learsoft.soap.ws.afipclient.DummyReturn;

public class DummyReturnDaoImpl implements DummyReturnDao {
	private DataSource dataSource;
    private Long getCurrentInstant() {
		Instant instant = Instant.now();
		return instant.toEpochMilli();
	}
    public DummyReturnDaoImpl() {
		dataSource= DataSource.getInstance();
	}
    @Override
    public void save(DummyReturn dummyReturn){  
    	Connection connection= dataSource.getConnection();
        try {
			PreparedStatement stmn = connection.prepareStatement(
			        "INSERT INTO AFIP_CHECKER(ID, APP_SERVER, AUTH_SERVER, DB_SERVER) VALUES (?,?,?,?)");
			stmn.setLong(1, this.getCurrentInstant());
			stmn.setString(2, dummyReturn.getAppserver());
			stmn.setString(3, dummyReturn.getAuthserver());
			stmn.setString(4, dummyReturn.getDbserver());
			stmn.executeUpdate();
			stmn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
        dataSource.disconnect();
    }


}
