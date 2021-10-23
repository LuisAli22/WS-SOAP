package sr.puc.server.ws.soap.a5;
 
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import ar.learsoft.com.soap.ws.VerificadorDelServicioAFIP;


 
//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL)
public interface PersonaServiceA5{
 
	@WebMethod 
	public VerificadorDelServicioAFIP dummy();
	
	

}