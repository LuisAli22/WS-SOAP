package ar.com.learsoft.soap.ws.core.domain.model;

import java.time.Instant;

public class DummyLog implements Log{
	Dummy dummy;

	public DummyLog(Dummy dummy) {
		this.dummy = dummy;
	}

	@Override
	public String getAppserver() {
		return dummy.getAppserver();
	}

	@Override
	public String getAuthserver() {
		return dummy.getAuthserver();
	}

	@Override
	public String getDbserver() {
		return dummy.getDbserver();
	}

	@Override
	public long getTimestamp() {
		Instant instant = Instant.now();
		return instant.toEpochMilli();
	}

}
