package org.atrzaska.ebiznes.ps7.api;

import java.util.ArrayList;
import java.util.List;

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
	 * Session list.
	 */
	private List<Session> sessions = new ArrayList<>();
	
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

	public List<Session> getSessions() {
		return sessions;
	}
}
