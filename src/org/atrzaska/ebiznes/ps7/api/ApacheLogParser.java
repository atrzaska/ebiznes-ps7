package org.atrzaska.ebiznes.ps7.api;

import java.util.ArrayList;
import java.util.List;

public class ApacheLogParser {

	/**
	 * Apache log.
	 */
	private ApacheLog apacheLog;

	/**
	 * Session list.
	 */
	private List<Session> sessions = new ArrayList<>();

	/**
	 * User list.
	 */
	private UserList userList = new UserList();

	public ApacheLogParser(ApacheLog log) {
		this.apacheLog = apacheLog;

		this.parse(log);
	}

	private void parse(ApacheLog log) {
		for (int i = 0; i < apacheLog.getRecords().size(); i++) {
			ApacheLogRecord record = apacheLog.getRecords().get(i);

			String ip = record.getIp();
			String browserInfo = record.getBrowserInfo();

			// get user
			User user = userList.getUser(ip, browserInfo);

		}
	}
}
