package ar.com.learsoft.soap.ws.conecction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private Connection dBConecction = null;

    // JDBC URL de la BD y nombre del Driver
    private final String DB_URL = "jdbc:h2:file:~/data/soap_db";
    private final String JDBC_DRIVER = "org.h2.Driver";

    // Credencial de la BD
    private final String USER = "sql";
    private final String PASS = "sql";

    public void connectionWithDataBase() throws Exception {
        try {
            Class.forName(JDBC_DRIVER);
            setdBConecction(DriverManager.getConnection(DB_URL, USER, PASS));

        } catch (Exception e) {
            throw e;

        }

    }

    public void disconnectionWithDataBase() throws SQLException {
        if (dBConecction != null) {
            if (!getdBConecction().isClosed()) {
                getdBConecction().close();

            }
        }
    }

    public Connection getdBConecction() {
        return dBConecction;
    }

    public void setdBConecction(Connection dBConecction) {
        this.dBConecction = dBConecction;
    }
}