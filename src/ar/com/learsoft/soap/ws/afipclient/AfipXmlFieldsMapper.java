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
	
	
	public String getAppServer() {
		return appServer;
	}
	
	public String getAuthServer() {
		return authServer;
	}
	
	public String getdBServer() {
		return dBServer;
	}
	
	@Override
	public String toString() {
		return "AppServer=" + appServer +"\nAuthServer=" + authServer + "\nDBServer=" + dBServer;
	}
	
	
	
}
