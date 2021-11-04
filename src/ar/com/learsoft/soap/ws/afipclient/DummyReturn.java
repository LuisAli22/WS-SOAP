
package ar.com.learsoft.soap.ws.afipclient;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import ar.com.learsoft.soap.ws.conecction.BDConnection;
import ar.com.learsoft.soap.ws.conecction.DAODummyReturn;

/**
 * <p>
 * Clase Java para dummyReturn complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dummyReturn">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="appserver" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="authserver" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dbserver" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dummyReturn", propOrder = { "appserver", "authserver", "dbserver" })
public class DummyReturn extends BDConnection implements DAODummyReturn {

	protected String appserver;
	protected String authserver;
	protected String dbserver;

	/**
	 * Obtiene el valor de la propiedad appserver.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAppserver() {
		return appserver;
	}

	/**
	 * Define el valor de la propiedad appserver.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setAppserver(String value) {
		this.appserver = value;
	}

	/**
	 * Obtiene el valor de la propiedad authserver.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAuthserver() {
		return authserver;
	}

	/**
	 * Define el valor de la propiedad authserver.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setAuthserver(String value) {
		this.authserver = value;
	}

	/**
	 * Obtiene el valor de la propiedad dbserver.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDbserver() {
		return dbserver;
	}

	/**
	 * Define el valor de la propiedad dbserver.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setDbserver(String value) {
		this.dbserver = value;
	}

	private Long time() {
		String time2 = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis()));
		Long time = Long.parseLong(time2);
		return time;

	}

	@Override
	public void saveDB() throws Exception {
		try {
			this.conectarDB();
			PreparedStatement stmn = this.bDConecction.prepareStatement(
					"INSERT INTO AFIP_CHECKER(ID, APP_SERVER, AUTH_SERVER, DB_SERVER) VALUES (?,?,?,?)");
			stmn.setLong(1, this.time());
			stmn.setString(2, appserver);
			stmn.setString(3, authserver);
			stmn.setString(4, dbserver);
			stmn.executeUpdate();
			stmn.close();
		} catch (Exception e) {
			throw e;
		} finally {
			this.desconectarBD();
		}
	}

}
