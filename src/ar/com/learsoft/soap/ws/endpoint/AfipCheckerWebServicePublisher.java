package ar.com.learsoft.soap.ws.endpoint;

import javax.xml.ws.Endpoint;
import ar.com.learsoft.soap.ws.AfipServiceChecker;
import ar.com.learsoft.soap.ws.utils.Definitions;

/*Programa principal que levanta la interfaz del web service
 * en http://localhost:8080/ws/afipchecker*/
public class AfipCheckerWebServicePublisher {
	public static void main(String[] args) {
		AfipServiceChecker afipServiceChecker = new AfipServiceChecker();
		Endpoint.publish(Definitions.AFIP_CHECKER_ADDRESS, afipServiceChecker);
	}
}
