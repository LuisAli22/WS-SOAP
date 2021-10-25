package ar.com.learsoft.soap.ws;

import java.net.MalformedURLException;

import javax.jws.WebService;

import ar.com.learsoft.soap.ws.afipclient.Afip;
import ar.com.learsoft.soap.ws.utils.Definitions;

@WebService(endpointInterface = "ar.com.learsoft.soap.ws.ServiceChecker")
public class AfipServiceChecker implements ServiceChecker{

	@Override
	public String getStatus(){
		String serviceStatus= Definitions.FAILED_STATUS;
		try {
			Afip afip = new Afip();
			serviceStatus= afip.getStatus();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return serviceStatus;
	}

}
