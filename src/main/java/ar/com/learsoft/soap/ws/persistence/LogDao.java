package ar.com.learsoft.soap.ws.persistence;

import ar.com.learsoft.soap.ws.core.domain.model.Log;

public interface LogDao {
	public abstract void save(Log Log);
}
