package org.atrzaska.ebiznes.ps7.api;

import java.util.ArrayList;
import java.util.List;

public class ApacheLogParser {
	private ApacheLog apacheLog;
	private List<Session> sessions = new ArrayList<>();

	public ApacheLogParser(ApacheLog log) {
		this.apacheLog = apacheLog;

		this.parse(log);
	}

	private void parse(ApacheLog log) {
		for (int i = 0; i < apacheLog.getRecords().size(); i++) {
			
		}
	}
}
