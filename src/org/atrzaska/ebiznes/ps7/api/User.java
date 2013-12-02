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

        if(getLastVisit() != null) {
            timeDifference = (int) DateUtils.getDateDiff(getLastVisit(), currentDate, TimeUnit.MINUTES);
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
		getSessions().add(session);
		return session;
	}

	private Session getLastSession() {
		if(getSessions().isEmpty()) {
			return this.createNewSession();
		}
	
		return getSessions().get(getSessions().size() -1);
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
    public int getPagesVisited() {
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
//        int val = 0;
//        
//        for (Session session : sessions) {
//            val += session.getTimePerPage();
//        }
//    
//        return val;
    
        return null;
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
}
