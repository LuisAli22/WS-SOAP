package ar.com.learsoft.soap.ws.afipclient;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import ar.com.learsoft.soap.ws.utils.Definitions;
import sr.puc.server.ws.soap.a5.PersonaServiceA5;


 
public class Afip{
	private URL url;
	private QName qname;
	private QName qname2;
	private Service service;
	private PersonaServiceA5 serviceOperation;
	
	public Afip() throws MalformedURLException {
		url = new URL("https://awshomo.afip.gov.ar/sr-padron/webservices/personaServiceA5?WSDL");
		qname = new QName("http://a5.soap.ws.server.puc.sr/", "PersonaServiceA5");
		qname2 = new QName("http://a5.soap.ws.server.puc.sr/", "PersonaServiceA5Port");
		service = Service.create(url, qname);
		serviceOperation = service.getPort(qname2, PersonaServiceA5.class);
	}
	private boolean isStatusOk(String serverType) {
		return serverType.equals(Definitions.OK_STATUS);
	}
	private boolean applicationDatabaseAndAuthenticationAreOk() {
		AfipXmlFieldsMapper afipXmlFieldsMapper = serviceOperation.dummy();
		String appServer= afipXmlFieldsMapper.getAppServer();
		String dbServer= afipXmlFieldsMapper.getdBServer();
		String authServer= afipXmlFieldsMapper.getAuthServer();
		return (isStatusOk(appServer) &&
				isStatusOk(dbServer)&&
				isStatusOk(authServer));
	}
	public String getStatus(){
		String currentServiceStatus= Definitions.FAILED_STATUS;
		if (this.applicationDatabaseAndAuthenticationAreOk()){
			currentServiceStatus= Definitions.OK_STATUS;
		}
		return currentServiceStatus; 
	}

}