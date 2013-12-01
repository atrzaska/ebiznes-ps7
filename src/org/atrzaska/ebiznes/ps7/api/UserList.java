package org.atrzaska.ebiznes.ps7.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserList {
	private List<User> users = new ArrayList<>();

	private Map<String, User> userMap = new HashMap<>();

	public User getUser(String ip, String browserInfo) {
		String id = ip + browserInfo;
		
		User user = userMap.get(id);

		if(user == null) {
			user = new User(ip, browserInfo);
			userMap.put(id, user);
			users.add(user);
		}

		return user;
	}

	public List<User> getUsers() {
		return users;
	}
}
