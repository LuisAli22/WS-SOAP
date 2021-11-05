package ar.com.learsoft.soap.ws.conecction;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import ar.com.learsoft.soap.ws.afipclient.DummyReturn;

public class DummyReturnDAO extends DBConnection implements DAODummyReturn {

	private Long time() {
		String time2 = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis()));
		Long time = Long.parseLong(time2);
		return time;

	}

	@Override
	public void saveDB(DummyReturn dummy) throws Exception {
		try {
			this.connectionWithDataBase();
			PreparedStatement stmn = this.getdBConecction().prepareStatement(
					"INSERT INTO AFIP_CHECKER(ID, APP_SERVER, AUTH_SERVER, DB_SERVER) VALUES (?,?,?,?)");
			stmn.setLong(1, this.time());
			stmn.setString(2, dummy.getAppserver());
			stmn.setString(3, dummy.getAuthserver());
			stmn.setString(4, dummy.getDbserver());
			stmn.executeUpdate();
			stmn.close();
		} catch (Exception e) {
			throw e;
		} finally {
			this.disconnectionWithDataBase();
		}
	}

}
