package org.atrzaska.ebiznes.ps7.api;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.atrzaska.ebiznes.ps7.Config;
import org.atrzaska.ebiznes.util.DateUtils;

public class User {
	
	/**
	 * User id.
	 */
	private String ip;
	
	/**
	 * Browser info.
	 */
	private String browserInfo;

	/**
	 * Country name.
	 */
	private String country;

	/**
	 * Session list.
	 */
	private List<Session> sessions = new ArrayList<>();
	
	/**
	 * Last visit.
	 */
	private Date lastVisit;
	
	
	public User(String ip, String browserInfo) {
		this.ip = ip;
		this.browserInfo = browserInfo;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getBrowserInfo() {
		return browserInfo;
	}

	public void setBrowserInfo(String browserInfo) {
		this.browserInfo = browserInfo;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public Session getCurrentSession(Date currentDate) {
		// calculate time difference
		int timeDifference = (int) DateUtils.getDateDiff(lastVisit, currentDate, TimeUnit.MINUTES);

		// bumb visit date
		this.lastVisit = currentDate;

		if(timeDifference < Config.sessionLength) {
			// session still active, get last session
			return this.getLastSession();
		} else {
			// session expired, create new one
			return this.createNewSession();
		}
	}

	private Session createNewSession() {
		Session session = new Session();
		sessions.add(session);
		return session;
	}

	private Session getLastSession() {
		if(sessions.isEmpty()) {
			return this.createNewSession();
		}
	
		return sessions.get(sessions.size() -1);
	}
}
