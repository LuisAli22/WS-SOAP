package ar.com.learsoft.soap.ws.persistence;

import java.sql.SQLException;
import java.time.Instant;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.google.common.collect.ImmutableMap;

import ar.com.learsoft.soap.ws.afipclient.DummyReturn;
import ar.com.learsoft.soap.ws.core.domain.model.Log;
import ar.com.learsoft.soap.ws.utils.Definitions.AfipChecker;
import static ar.com.learsoft.soap.ws.utils.Definitions.AfipChecker.*;

import ar.com.learsoft.soap.ws.utils.Definitions.DatabaseType;
import static ar.com.learsoft.soap.ws.utils.Definitions.*;

public class AfipCheckerUpdateStatement extends Statement{
	private Map<AfipChecker, ?> afipResponseValues;
	TreeMap<DatabaseType, Collection<AfipChecker>> afipCheckerTable;
	private int fieldIndex;
	private String valuesFlags;
	public AfipCheckerUpdateStatement(Log log) {
		super(INSERT_STATEMENT+SPACE+TABLENAME.toString()
			+SPACE+OPEN_PARENTHESIS);
		this.valuesFlags=VALUES_STATEMENT+SPACE+OPEN_PARENTHESIS;
		this.afipResponseValues= 
				ImmutableMap.of(
						IDENTIFIER_FIELD,
						log.getTimestamp(),
						APPLICATION_SERVER_FIELD, 
						log.getAppserver(),
						AUTHENTICATION_SERVER_FIELD,
						log.getAuthserver(),
						DATABASE_SERVER_FIELD,
						log.getDbserver());
		this.fieldIndex=INITIAL_INDEX;
		afipCheckerTable= new TreeMap<>(AFIP_CHECKER_TABLE.asMap());
	}

	private boolean checkLastDataType(DatabaseType currentDataType){
		DatabaseType lastDataType= this.afipCheckerTable.lastKey();
		return (lastDataType==currentDataType);
	}
	private boolean checkLastField(AfipChecker currentField,
									List<AfipChecker> fields) {
		int currentFieldIndex= fields.indexOf(currentField);
		int lastFieldIndex= fields.size()-INDEX_OFFSET_FROM_SIZE;
		return (currentFieldIndex == lastFieldIndex);
	}
	private void appendToValuesFlagsAndsqlStatement(String sqlConcat, 
													String valuesConcat) {
		this.sqlStatement+=sqlConcat;
		this.valuesFlags+=valuesConcat;
	}	
	@Override
	public void execute() throws SQLException {
		preparedStatement.executeUpdate();
	}
	
	private void setFieldValues(DatabaseType currentDataType, 
								List<AfipChecker> fields) throws SQLException {
		for(AfipChecker currentField: fields) {
			this.fieldIndex++;
			setCurrentField(currentDataType, currentField);
		}	
	}
	private void setIdentifierToPreparedStatement(
								AfipChecker currentField) throws SQLException {
		long fieldValue= (long) this.afipResponseValues.get(currentField);
		preparedStatement.setLong(this.fieldIndex, fieldValue);	
	}
	private void setAfipResponseValueToPreparedStatement(
								AfipChecker currentField) throws SQLException {
		String fieldValue=(String) this.afipResponseValues.get(currentField);
		preparedStatement.setString(this.fieldIndex, fieldValue);
	}
	private void setCurrentField(DatabaseType currentDataType, 
								AfipChecker currentField) throws SQLException {
		if (currentDataType== DatabaseType.BIGINTNOTNULL) {
			this.setIdentifierToPreparedStatement(currentField);
		}else {
			this.setAfipResponseValueToPreparedStatement(currentField);
		}
		
	}
	@Override
	protected void setPreparedStatementParameters() throws SQLException {
		for(DatabaseType currentDataType: AFIP_CHECKER_TABLE.keySet()) { 
			List<AfipChecker> fields = AFIP_CHECKER_TABLE.get(currentDataType);
			setFieldValues(currentDataType, fields);
		}
	}
	private boolean isLastField(DatabaseType dataType, 
								AfipChecker currentField, 
								List<AfipChecker> afipCheckerFields) {
		boolean isLastField= checkLastField(currentField, afipCheckerFields);
		boolean isLastDataType= checkLastDataType(dataType);
		return (!isLastDataType) || (! isLastField);
	}
	@Override
	protected void appendStatementBody(DatabaseType dataType, 
										AfipChecker currentField, 
										List<AfipChecker> afipCheckerFields) {
		this.appendToValuesFlagsAndsqlStatement(currentField.toString(),
												QUESTION_MARK);
		if (this.isLastField(dataType, currentField, afipCheckerFields)){
			this.appendToValuesFlagsAndsqlStatement(COMMA, COMMA);
		}
		
	}
	@Override
	protected void appendStatementEnd() {
		this.appendToValuesFlagsAndsqlStatement(CLOSE_PARENTHESIS,
												CLOSE_PARENTHESIS);
		sqlStatement+=(SPACE+valuesFlags);
		
	}

}
