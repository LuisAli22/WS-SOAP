package ar.com.learsoft.soap.ws.persistence;

import static ar.com.learsoft.soap.ws.utils.Definitions.AFIP_CHECKER_TABLE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import ar.com.learsoft.soap.ws.utils.Definitions.AfipChecker;
import ar.com.learsoft.soap.ws.utils.Definitions.DatabaseType;

public abstract class Statement {
	protected DataBaseConnector dataBaseConnector;
	protected Connection connection;
	protected PreparedStatement preparedStatement;
	protected String sqlStatement;
	public Statement(String sqlStatementInitial){
		this.dataBaseConnector= DataBaseConnector.getInstance();
		this.sqlStatement= sqlStatementInitial;
	}
	protected abstract void appendStatementBody(DatabaseType dataType, 
										AfipChecker currentField, 
										List<AfipChecker> afipCheckerfields);
	protected abstract void appendStatementEnd();
	protected abstract void setPreparedStatementParameters() throws SQLException;
	public abstract void execute() throws SQLException;
	protected String getSqlStatement() {
		for(DatabaseType dataType: AFIP_CHECKER_TABLE.keySet()) {
			List<AfipChecker> afipCheckerFields=
											AFIP_CHECKER_TABLE.get(dataType);
			for(AfipChecker currentField: afipCheckerFields) {
				appendStatementBody(dataType, currentField, afipCheckerFields);
			}
		}
		appendStatementEnd();
		return sqlStatement;
	}
	public void executeAndClose() {
		try {
			this.execute();
			preparedStatement.close();
			dataBaseConnector.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void prepare() {
		String sqlStatement= getSqlStatement();
		try {
			Connection adminConnection= dataBaseConnector.getConnection();
			preparedStatement= adminConnection.prepareStatement(sqlStatement);
			setPreparedStatementParameters();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
