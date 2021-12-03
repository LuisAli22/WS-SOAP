package ar.com.learsoft.soap.ws.utils;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ListMultimap;

public class Definitions {
	public static final String OK_STATUS = "OK";
	public static final String FAILED_STATUS = "ERROR";
	public static final String AFIP_CHECKER_ADDRESS= "http://localhost:8080/ws/afipchecker";
	public static final String PRIMARYKEYLABEL="PRIMARY KEY";
	public enum AfipChecker {
		TABLENAME("AFIP_CHECKER"),
		IDENTIFIER_FIELD("ID"), 
		APPLICATION_SERVER_FIELD("APP_SERVER"), 
		AUTHENTICATION_SERVER_FIELD("AUTH_SERVER"), 
		DATABASE_SERVER_FIELD("DB_SERVER");
		private String value;
		private AfipChecker(String value) {
			this.value= value;
		}
		@Override
		public String toString() {
			return this.value;
		}
	};
	public enum DatabaseType {
		BIGINTNOTNULL("BIGINT not null"),
		VARCHAR255("VARCHAR(255)");
		private String value;
		private DatabaseType(String value) {
			this.value= value;
		}
		@Override
		public String toString() {
			return this.value;
		}
	};
	public static final ListMultimap<DatabaseType, AfipChecker> AFIP_CHECKER_TABLE= 
			new ImmutableListMultimap.Builder<DatabaseType, AfipChecker>()
				.put(DatabaseType.BIGINTNOTNULL, 
						AfipChecker.IDENTIFIER_FIELD)
				.putAll(DatabaseType.VARCHAR255,
						AfipChecker.APPLICATION_SERVER_FIELD,
						AfipChecker.AUTHENTICATION_SERVER_FIELD,
						AfipChecker.DATABASE_SERVER_FIELD)
				.build(); 
	public static final String JNDI_COMPONENTS_ENVIRONMENT= "java:comp/env";
	public static final String SOAP_DB_RESOURCE= "jdbc/soap_db";
	public static final String EMPTY_STRING = "";
	public static final long INITIAL_TABLE_LONG_VALUE = 0;
	public static final int INITIAL_INDEX = 0;
	public static final int INDEX_OFFSET_FROM_SIZE=1;
	public static final String INSERT_STATEMENT="INSERT INTO";
	public static final String CREATE_STATEMENT="CREATE CACHED TABLE IF NOT EXISTS";
	public static final String SPACE=" ";
	public static final String COMMA=",";
	public static final String QUESTION_MARK="?";
	public static final String OPEN_PARENTHESIS="(";
	public static final String CLOSE_PARENTHESIS=")";
	public static final String VALUES_STATEMENT="VALUES";
}
