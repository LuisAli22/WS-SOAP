package ar.com.learsoft.soap.ws.persistence;

import ar.com.learsoft.soap.ws.core.domain.model.Log;

public class LogDaoImpl implements LogDao {

	public LogDaoImpl() {
		AfipCheckerCreateStatement afipCheckerCreateStatement = 
				new AfipCheckerCreateStatement();
		executeSqlStatement(afipCheckerCreateStatement);
	}

	@Override
	public void save(Log log) {
		AfipCheckerUpdateStatement afipCheckerUpdateStatement = 
				new AfipCheckerUpdateStatement(log);
		executeSqlStatement(afipCheckerUpdateStatement);
	}

	private void executeSqlStatement(Statement statement) {
		statement.prepare();
		statement.executeAndClose();
	}

}
