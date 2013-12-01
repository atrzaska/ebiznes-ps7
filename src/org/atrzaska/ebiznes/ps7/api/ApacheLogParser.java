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
		this.apacheLog = log;

		this.parse();
	}

	private void parse() {
		for (int i = 0; i < apacheLog.numRecords(); i++) {
			ApacheLogRecord record = apacheLog.getRecord(i);

			String ip = record.getIp();
			String browserInfo = record.getBrowserInfo();

			// get user
			User user = userList.getUser(ip, browserInfo);

			Session session = user.getCurrentSession(record.getDate());
			session.addRecord(record);
		}
	}

	public void saveCsv(String path) {
		
	}
}
