package org.atrzaska.ebiznes.ps7.api;

import java.util.ArrayList;
import java.util.Date;
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
		this.country = this.calculateCountry(ip);
	}

	private String calculateCountry(String ip) {
		String topLevelDomain = ip.toLowerCase().substring(ip.lastIndexOf(".") + 1);

		if(topLevelDomain.equalsIgnoreCase("com")) {
			return "?";
		}
		if(topLevelDomain.equalsIgnoreCase("net")) {
			return "?";
		}
		if(topLevelDomain.equalsIgnoreCase("org")) {
			return "?";
		}
		if(topLevelDomain.equalsIgnoreCase("unr")) {
			return "?";
		}
		if(topLevelDomain.equalsIgnoreCase("edu")) {
			return "?";
		}

		return topLevelDomain;
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
        int timeDifference = 999999999;

        if(lastVisit != null) {
            timeDifference = (int) DateUtils.getDateDiff(lastVisit, currentDate, TimeUnit.MINUTES);
        }

		// bumb visit date
        this.setLastVisit(currentDate);

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

		return sessions.get(getSessions().size() -1);
	}

    /**
     * @return the sessionTime
     */
    public int getSessionTime() {
        int val = 0;

        for (Session session : sessions) {
            val += session.getDuration();
        }

        return val;
    }


    /**
     * @return the pagesVisited
     */
    public int numPagesVisited() {
        int val = 0;

        for (Session session : sessions) {
            val += session.getPagesVisited();
        }

        return val;
    }

    /**
     * @return the averageTimePerPage
     */
    public int getAverageTimePerPage() {
        int val = 0;

        for (Session session : sessions) {
            val += session.getTimePerPage();
        }

        return val / sessions.size();
    }

    /**
     * @return the mostVisitedResource
     */
    public Resource getMostVisitedResource() {
    	return new Resource(sessions.get(0).getMostVisitedResource());
    }

    public int numSessions() {
        return sessions.size();
    }

    /**
     * @param sessions the sessions to set
     */
    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    /**
     * @return the lastVisit
     */
    public Date getLastVisit() {
        return lastVisit;
    }

    /**
     * @param lastVisit the lastVisit to set
     */
    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }

    @Override
	public String toString() {
    	return ip + " " + browserInfo;
    }
}
