package org.atrzaska.ebiznes.ps7.api;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.atrzaska.ebiznes.ps7.Config;
import org.atrzaska.ebiznes.util.DateUtils;

public class Session {
	private int id;

	/**
	 * Session time in seconds.
	 */
	private int duration;

	/**
	 * Number of Pages Visited;
	 */
	private int pagesVisited;

	/**
	 * Average time spent on one page.
	 */
	private int timePerPage;

	/**
	 * Most visited resource.
	 */
	private String mostVisitedResource;

	/**
	 * Session start resource.
	 */
	private String startResource;
	
	/**
	 * Start date.
	 */
	private Date startDate;
	
	/**
	 * End date.
	 */
	private Date endDate;
	
	/**
	 * Session end resource.
	 */
	private String endResource;

	/**
	 * Session records.
	 */
	private List<ApacheLogRecord> records = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getPagesVisited() {
		return pagesVisited;
	}

	public void setPagesVisited(int pagesVisited) {
		this.pagesVisited = pagesVisited;
	}

	public int getTimePerPage() {
		return timePerPage;
	}

	public void setTimePerPage(int timePerPage) {
		this.timePerPage = timePerPage;
	}

	public String getMostVisitedResource() {
		return mostVisitedResource;
	}

	public void setMostVisitedResource(String mostVisitedResource) {
		this.mostVisitedResource = mostVisitedResource;
	}

	public String getStartResource() {
		return startResource;
	}

	public void setStartResource(String startResource) {
		this.startResource = startResource;
	}

	public String getEndResource() {
		return endResource;
	}

	public void setEndResource(String endResource) {
		this.endResource = endResource;
	}

	public List<ApacheLogRecord> getRecords() {
		return records;
	}

	public void addRecord(ApacheLogRecord record) {
		this.records.add(record);
		this.update();
	}

	private void update() {
		ApacheLogRecord firstRecord = records.get(0);
		ApacheLogRecord lastRecord = records.get(records.size() - 1);
		this.startResource = firstRecord.getResource();
		this.endResource = lastRecord.getResource();
		this.startDate = firstRecord.getDate();
		this.endDate = this.calculateEndDate();
		this.duration = (int) DateUtils.getDateDiff(startDate, endDate, TimeUnit.SECONDS);
		this.mostVisitedResource = this.calculateMostVisitedResource();
		this.pagesVisited = this.numPagesVisited();
		this.timePerPage = this.calculateTimePerPage();
	}

	public int numPagesVisited() {
		return records.size();
	}
	
	private int calculateTimePerPage() {
		int diff = (int) DateUtils.getDateDiff(startDate, endDate, TimeUnit.SECONDS);
		return diff / numPagesVisited(); 
	}

	private String calculateMostVisitedResource() {
		Map<String, Integer> helpMap = new HashMap<>();
		int currentMax = 0;
		String mostVisitedResourceName = "";
		
		for (ApacheLogRecord record: records) {
			String resourceName = record.getResource();
			
			Integer count = helpMap.get(resourceName);
	
			if(count == null) {
				count = 0;
			}
	
			count++;
			helpMap.put(resourceName, count);
		
			if(count > currentMax) {
				currentMax = count;
				mostVisitedResourceName = resourceName;
			}
		}
	
		return mostVisitedResourceName;
	}

	protected Date calculateEndDate() {
		ApacheLogRecord lastRecord = records.get(records.size() - 1);
		
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(lastRecord.getDate());
		calendar.add(Calendar.MINUTE, Config.sessionLength);
	
		return calendar.getTime();
	}
}
