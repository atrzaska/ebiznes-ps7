package org.atrzaska.ebiznes.ps7.api;

import java.util.ArrayList;
import java.util.List;

public class User {
	/**
	 * User id.
	 */
	private int id;

	/**
	 * Session list.
	 */
	private List<Session> sessions = new ArrayList<>();
	
	public User(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Session> getSessions() {
		return sessions;
	}
}
