package org.atrzaska.ebiznes.ps7.api;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.atrzaska.ebiznes.ps7.Config;

public class ApacheLogParser {

	/**
	 * Apache log.
	 */
	protected ApacheLog apacheLog;

	/**
	 * Session list.
	 */
	protected List<Session> sessions = new ArrayList<>();

	/**
	 * User list.
	 */
	protected UserList userList = new UserList();

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

            // get session
			Session session = user.getCurrentSession(record.getDate());
			session.addRecord(record);
		}
	}

	public void saveCsv(String path) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Config.outputCsv))) {
            for (int i = 0; i < userList.numUsers(); i++) {
                User user = userList.getUser(i);
                
                String userId = "\"" + user.getIp() + " " + user.getBrowserInfo() + "\"";
                
                String line = userId + "," + user.getSessionTime() + "," + user.getPagesVisited() + "," +
                    user.getAverageTimePerPage() + ",\"" + user.getMostVisitedResource() + "\"\n";
                
                if(user.getPagesVisited() > 1) {
                    writer.write(line);
                }
            }
        }
	}
}
