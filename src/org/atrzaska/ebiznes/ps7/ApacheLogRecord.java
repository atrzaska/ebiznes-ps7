package org.atrzaska.ebiznes.ps7;

public class ApacheLogRecord {
	String ip;
	String day;
	String month;
	String year;
	String hour;
	String minute;
	String second;
	String resource;
	String responseCode;
	String unk1;
	String referingSite;
	String browserInfo;
	
	public ApacheLogRecord(String ip,
			String day,
			String month,
			String year,
			String hour,
			String minute,
			String second,
			String resource,
			String responoseCode,
			String unk1,
			String referingSite,
			String browserInfo) {
		
		this.ip = ip;
		this.day = day;
		this.month = month;
		this.year = year;
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		this.resource = resource;
		this.responseCode = responoseCode;
		this.unk1 = unk1;
		this.referingSite = referingSite;
		this.browserInfo = browserInfo;
	}
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	public String getMinute() {
		return minute;
	}
	public void setMinute(String minute) {
		this.minute = minute;
	}
	public String getSecond() {
		return second;
	}
	public void setSecond(String second) {
		this.second = second;
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getUnk1() {
		return unk1;
	}
	public void setUnk1(String unk1) {
		this.unk1 = unk1;
	}
	public String getReferingSite() {
		return referingSite;
	}
	public void setReferingSite(String referingSite) {
		this.referingSite = referingSite;
	}
	public String getBrowserInfo() {
		return browserInfo;
	}
	public void setBrowserInfo(String browserInfo) {
		this.browserInfo = browserInfo;
	}

	public String toString() {
		return ip + " " + day + "/" + month + "/" + year + " " + hour +":" + minute + ":" + second
				+ " " + resource + " " + responseCode + " " + unk1 + " " + referingSite + " " + browserInfo;
		
	}
}
