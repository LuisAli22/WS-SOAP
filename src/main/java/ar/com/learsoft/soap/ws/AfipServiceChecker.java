package ar.com.learsoft.soap.ws;

import java.net.MalformedURLException;
import java.net.URL;

import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import ar.com.learsoft.soap.ws.afipclient.DummyReturn;
import ar.com.learsoft.soap.ws.core.domain.model.DummyLog;
import ar.com.learsoft.soap.ws.core.domain.model.Log;
import ar.com.learsoft.soap.ws.persistence.LogDao;
import ar.com.learsoft.soap.ws.persistence.LogDaoImpl;
import sr.puc.server.ws.soap.a5.PersonaServiceA5Endpoint;
import static ar.com.learsoft.soap.ws.utils.Definitions.*;

@WebService
public class AfipServiceChecker implements ServiceChecker {
	private URL wsdlDocumentLocationUrl;
	private QName personaServiceA5QualifiedName;
	private QName personaServiceA5EndpointQualifiedName;
	private Service afipWebServerClientView;
	private PersonaServiceA5Endpoint personaServiceA5Endpoint;
	private LogDao logDao;

	public AfipServiceChecker() {
		try {
			this.setWebServerClientView();
			this.setPersonaA5Endpoint();
			logDao= new LogDaoImpl();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	private void setWebServerClientView() throws MalformedURLException {
			wsdlDocumentLocationUrl = new URL(PADRONAFIPPERSONA5WSDLURL);
			personaServiceA5QualifiedName = new QName(
											PERSONAA5TARGETNAMESPACEURI,
											PERSONAA5TARGETNAMESPACEELEMENT);
			afipWebServerClientView = Service.create(
											wsdlDocumentLocationUrl, 
											personaServiceA5QualifiedName);
	}
	private void setPersonaA5Endpoint() {
		personaServiceA5EndpointQualifiedName = new QName(
										PERSONAA5TARGETNAMESPACEURI, 
										PERSONAA5PORTTARGETNAMESPACEELEMENT);
		personaServiceA5Endpoint = afipWebServerClientView.getPort(
										personaServiceA5EndpointQualifiedName, 
										PersonaServiceA5Endpoint.class);
	}

	private String getThreeServersStatusResponse(Log log) {
		boolean appServerOk = (OK_STATUS.equals(log.getAppserver()));
		boolean dbServerOk = (OK_STATUS.equals(log.getAuthserver()));
		boolean authServerOk = (OK_STATUS.equals(log.getDbserver()));
		boolean threeServersOk = (appServerOk)
									&&(dbServerOk)
									&&(authServerOk);
		return (threeServersOk)?(OK_STATUS):(FAILED_STATUS);
	}

	@Override
	public String getStatus() {
		DummyReturn dummyReturn = personaServiceA5Endpoint.dummy();
		DummyLog dummyLog=new DummyLog(dummyReturn);
		logDao.save(dummyLog);
		String threeServersStatusResponse = 
				getThreeServersStatusResponse(dummyLog); 
		return threeServersStatusResponse;
	}

}
