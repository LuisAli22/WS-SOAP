package ar.com.learsoft.soap.ws.conecction;

import java.security.Timestamp;
import java.util.List;

import ar.com.learsoft.soap.ws.afipclient.DummyReturn;

public interface DAODummyReturn {

	public void create () throws Exception;
	public List<DummyReturn> list() throws Exception;
}
