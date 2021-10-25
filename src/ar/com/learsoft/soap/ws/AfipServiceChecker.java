package ar.com.learsoft.soap.ws;

import java.net.MalformedURLException;

import javax.jws.WebService;

import ar.com.learsoft.soap.ws.afipclient.Afip;

@WebService(endpointInterface = "ar.com.learsoft.soap.ws.ServiceChecker")
public class AfipServiceChecker implements ServiceChecker{

	@Override
	public boolean isServiceUp(){
		boolean serviceWorkingProperly= false;
		try {
			Afip afip = new Afip();
			serviceWorkingProperly= afip.getStatus();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return serviceWorkingProperly;
	}

}
