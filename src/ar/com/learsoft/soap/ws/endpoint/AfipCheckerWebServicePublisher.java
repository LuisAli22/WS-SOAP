package ar.com.learsoft.soap.ws.endpoint;
import javax.xml.ws.Endpoint;

import ar.com.learsoft.soap.ws.AfipServiceChecker;
import ar.com.learsoft.soap.ws.utils.Definitions;
public class AfipCheckerWebServicePublisher {
	public static void main(String[] args) {
		   Endpoint.publish(Definitions.AFIP_CHECKER_ADDRESS, new AfipServiceChecker());
	    }
}
