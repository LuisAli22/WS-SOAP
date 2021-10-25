package ar.com.learsoft.soap.ws.endpoint;
import javax.xml.ws.Endpoint;

import ar.com.learsoft.soap.ws.AfipServiceChecker;
public class AfipCheckerWebServicePublisher {
	public static void main(String[] args) {
		   Endpoint.publish("http://localhost:8080/ws/afipchecker", new AfipServiceChecker());
	    }
}
