package ar.learsoft.com.soap.ws;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;



 @XmlAccessorType(XmlAccessType.FIELD)
@XmlType (name = "VerificadorDelServicioAFIP") 
public class VerificadorDelServicioAFIP {
	@XmlElement(name = "appserver")
	protected String appServer;
	@XmlElement(name = "authserver")
	protected String authServer;
	@XmlElement(name = "dbserver")
	protected String dBServer;
	
	
	
	public String getAppServer() {
		return appServer;
	}
	public void setAppServer(String appServer) {
		this.appServer = appServer;
	}
	public String getAuthServer() {
		return authServer;
	}
	public void setAuthServer(String authServer) {
		this.authServer = authServer;
	}
	public String getdBServer() {
		return dBServer;
	}
	public void setdBServer(String dBServer) {
		this.dBServer = dBServer;
	}
	@Override
	public String toString() {
		return "AppServer=" + appServer +"\nAuthServer=" + authServer + "\nDBServer=" + dBServer;
	}
	
	
	
}
