package ar.com.learsoft.soap.ws.persistence;

import ar.com.learsoft.soap.ws.afipclient.DummyReturn;

public class DummyReturnDaoImpl implements DummyReturnDao {

	public DummyReturnDaoImpl() {
		AfipCheckerCreateStatement afipCheckerCreateStatement = 
				new AfipCheckerCreateStatement();
		executeSqlStatement(afipCheckerCreateStatement);
	}

	@Override
	public void save(DummyReturn dummyReturn) {
		AfipCheckerUpdateStatement afipCheckerUpdateStatement = 
				new AfipCheckerUpdateStatement(dummyReturn);
		executeSqlStatement(afipCheckerUpdateStatement);
	}

	private void executeSqlStatement(Statement statement) {
		statement.prepare();
		statement.executeAndClose();
	}

}
