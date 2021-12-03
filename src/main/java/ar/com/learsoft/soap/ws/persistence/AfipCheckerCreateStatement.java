package ar.com.learsoft.soap.ws.persistence;

import java.sql.SQLException;
import java.util.List;

import ar.com.learsoft.soap.ws.utils.Definitions.AfipChecker;
import static ar.com.learsoft.soap.ws.utils.Definitions.AfipChecker.*;

import ar.com.learsoft.soap.ws.utils.Definitions.DatabaseType;
import static ar.com.learsoft.soap.ws.utils.Definitions.*;

public class AfipCheckerCreateStatement extends Statement {

	public AfipCheckerCreateStatement() {
		super(CREATE_STATEMENT+SPACE+TABLENAME.toString()
			+SPACE+OPEN_PARENTHESIS);
	}
	
	@Override
	public void execute() throws SQLException {
		preparedStatement.execute();
		
	}
	@Override
	protected void setPreparedStatementParameters() throws SQLException {}

	@Override
	protected void appendStatementBody(DatabaseType dataType, 
									AfipChecker currentField, 
									List<AfipChecker> afipCheckerFields) {
		sqlStatement+= (currentField.toString()+SPACE
						+dataType.toString()+COMMA);
	}

	@Override
	protected void appendStatementEnd() {
		sqlStatement+= (SPACE+PRIMARYKEYLABEL+SPACE+OPEN_PARENTHESIS
						+AfipChecker.IDENTIFIER_FIELD.toString()+SPACE
						+CLOSE_PARENTHESIS+CLOSE_PARENTHESIS);
	}

}
