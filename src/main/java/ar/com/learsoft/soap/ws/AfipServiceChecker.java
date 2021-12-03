package ar.com.learsoft.soap.ws;

import java.net.MalformedURLException;
import java.net.URL;

import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import ar.com.learsoft.soap.ws.afipclient.DummyReturn;
import ar.com.learsoft.soap.ws.persistence.DummyReturnDao;
import ar.com.learsoft.soap.ws.persistence.DummyReturnDaoImpl;
import ar.com.learsoft.soap.ws.utils.Definitions;
import sr.puc.server.ws.soap.a5.PersonaServiceA5;

@WebService
public class AfipServiceChecker implements ServiceChecker {
	private URL url;
	private QName qname;
	private QName qname2;
	private Service service;
	private PersonaServiceA5 personaServiceA5AfipProxy;
	DummyReturnDao dummyReturnDao;

	/*
	 * PRE: Ninugna POS: Crea una instancia de Afip para comunicarse con el servicio
	 * correspondiente y realizar consultas (Afip tiene el rol de cliente en este
	 * caso)
	 */
	public AfipServiceChecker() {
		try {
			url = new URL("https://awshomo.afip.gov.ar/sr-padron/webservices/personaServiceA5?WSDL");
			qname = new QName("http://a5.soap.ws.server.puc.sr/", "PersonaServiceA5");
			qname2 = new QName("http://a5.soap.ws.server.puc.sr/", "PersonaServiceA5Port");
			service = Service.create(url, qname);
			personaServiceA5AfipProxy = service.getPort(qname2, PersonaServiceA5.class);
			dummyReturnDao= new DummyReturnDaoImpl();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * PRE. Recibe una cadena (serverStatus) con el valor devuelto por el proxy que
	 * comunica con el servivio de afip. POS: Devuelve True si el estado es OK sino
	 * False.
	 */
	private boolean isStatusOk(String serverType) {
		return serverType.equals(Definitions.OK_STATUS);
	}

	/*
	 * Crea una instancia (DummyReturnDAO) para comunicarse con la base de datos y
	 * guarda los datos del estado del servicio en la misma.
	 */
	private void saveInDateBase(DummyReturn dummyReturn) {
		dummyReturnDao.save(dummyReturn);
	}
	/*
	 * PRE: Ninguna POS: Devuelve True si el estado de los tres servicios
	 * (appServer, authServer y dbServer) es OK, sino False.
	 */
	private boolean applicationDatabaseAndAuthenticationAreOk() throws Exception {
		DummyReturn dummyReturn = personaServiceA5AfipProxy.dummy();
		this.saveInDateBase(dummyReturn);
		String appServerStatus = dummyReturn.getAppserver();
		String dbServerStatus = dummyReturn.getAuthserver();
		String authServerStatus = dummyReturn.getDbserver();
		return (isStatusOk(appServerStatus) && isStatusOk(dbServerStatus) && isStatusOk(authServerStatus));
	}


	/*
	 * PRE: Ninguna POS: Devuelve OK si los tres servicios (appServer, authServer y
	 * dbServer) estan funcionando, sino ERROR (como cadena).
	 */
	@Override
	public String getStatus() throws Exception {
		String currentServiceStatus = Definitions.FAILED_STATUS;
		if (this.applicationDatabaseAndAuthenticationAreOk()) {
			currentServiceStatus = Definitions.OK_STATUS;
		}
		return currentServiceStatus;
	}

}
