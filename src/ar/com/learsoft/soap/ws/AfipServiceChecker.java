package ar.com.learsoft.soap.ws;

import javax.jws.WebService;

import ar.com.learsoft.soap.ws.afipclient.Afip;

@WebService(endpointInterface = "ar.com.learsoft.soap.ws.ServiceChecker")
public class AfipServiceChecker implements ServiceChecker {
	private Afip afip;

	/*
	 * PRE: Ninugna POS: Crea una instancia de Afip para comunicarse con el servicio
	 * correspondiente y realizar consultas (Afip tiene el rol de cliente en este
	 * caso)
	 */
	public AfipServiceChecker() {
		afip = new Afip();
	}

	/*
	 * PRE: Ninguna POS: Devuelve el estado del servicio de afip, pudiendo el mismo
	 * ser OK o ERROR.
	 */
	@Override
	public String getStatus() {
		try {
			return afip.getStatus();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
