package org.atrzaska.ebiznes.ps7.api;

import java.util.ArrayList;
import java.util.List;

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
	 * Country name.
	 */
	private String country;

	/**
	 * Most visited resource.
	 */
	private ApacheLog mostVisitedResource;

	/**
	 * Session start resource.
	 */
	private ApacheLog startResource;
	
	/**
	 * Session end resource.
	 */
	private ApacheLog endResource;

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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public ApacheLog getMostVisitedResource() {
		return mostVisitedResource;
	}

	public void setMostVisitedResource(ApacheLog mostVisitedResource) {
		this.mostVisitedResource = mostVisitedResource;
	}

	public ApacheLog getStartResource() {
		return startResource;
	}

	public void setStartResource(ApacheLog startResource) {
		this.startResource = startResource;
	}

	public ApacheLog getEndResource() {
		return endResource;
	}

	public void setEndResource(ApacheLog endResource) {
		this.endResource = endResource;
	}

	public List<ApacheLogRecord> getRecords() {
		return records;
	}
}
