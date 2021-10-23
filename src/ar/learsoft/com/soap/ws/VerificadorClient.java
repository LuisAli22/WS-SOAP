package ar.learsoft.com.soap.ws;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import sr.puc.server.ws.soap.a5.PersonaServiceA5;



 
public class VerificadorClient{
 
	public static void main(String[] args) throws Exception {
 
		URL url = new URL("https://awshomo.afip.gov.ar/sr-padron/webservices/personaServiceA5?WSDL");
 
        QName qname = new QName("http://a5.soap.ws.server.puc.sr/", "PersonaServiceA5");
        QName qname2 = new QName("http://a5.soap.ws.server.puc.sr/" , "PersonaServiceA5Port");
 
        Service service = Service.create(url, qname);
 
        PersonaServiceA5 serviceOperation = service.getPort( qname2 , PersonaServiceA5.class);
        System.out.println(serviceOperation.dummy());
        
        
    }
 
}