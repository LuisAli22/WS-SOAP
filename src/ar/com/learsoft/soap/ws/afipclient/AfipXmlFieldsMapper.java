package ar.com.learsoft.soap.ws.afipclient;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType (name = "AfipXmlFieldsMapper") 
public class AfipXmlFieldsMapper {
	@XmlElement(name = "appserver")
	protected String appServer;
	@XmlElement(name = "authserver")
	protected String authServer;
	@XmlElement(name = "dbserver")
	protected String dBServer;
	
	/* PRE: Ninguna
	 * POS: Devuelve el valor del atributo appServer obtenido como
	 * respuesta del servicio de afip
	 * */
	public String getAppServerStatus() {
		return appServer;
	}
	
	/* PRE: Ninguna
	 * POS: Devuelve el valor del atributo authServer obtenido como
	 * respuesta del servicio de afip
	 * */
	public String getAuthServerStatus() {
		return authServer;
	}
	
	/* PRE: Ninguna
	 * POS: Devuelve el valor del atributo dbServer obtenido como
	 * respuesta del servicio de afip
	 * */
	public String getdBServerStatus() {
		return dBServer;
	}
	
	@Override
	public String toString() {
		return "AppServer=" + appServer +"\nAuthServer=" + authServer + "\nDBServer=" + dBServer;
	}
	
	
	
}
