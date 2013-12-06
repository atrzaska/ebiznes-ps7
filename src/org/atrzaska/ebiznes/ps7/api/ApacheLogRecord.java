package org.atrzaska.ebiznes.ps7.api;

import java.util.Date;

import org.atrzaska.ebiznes.util.DateUtils;

public class ApacheLogRecord {
	private String ip;

	private Date date;

	private String resource;
	private String responseCode;
	private String unk1;
	private String referingSite;
	private String browserInfo;

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

		this.date = DateUtils.parseDate(year, month, day, hour, minute, second);

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isWebPage() {
        String val = resource.toLowerCase();

    	if(val.contains("css")) { return false; }
    	if(val.contains("js")) { return false; }
    	if(val.contains("gif")) { return false; }
    	if(val.contains("jpg")) { return false; }
    	if(val.contains("jpeg")) { return false; }
    	if(val.contains("png")) { return false; }
    	if(val.contains("pdf")) { return false; }
    	if(val.contains("ppt")) { return false; }
    	if(val.contains("ico")) { return false; }

		return true;
	}

    public boolean isSpider() {
    	return !this.isHuman();
    }

	public boolean isHuman() {
    	String val = browserInfo.toLowerCase();

    	if (val.contains("spider")) { return false; }
    	if(val.contains("bot")) { return false; }
    	if(val.contains("slurp")) { return false; }
    	if(val.contains("mozilla")) { return true; }
    	if (val.contains("msie")) { return true; }

    	return false;
    }

	@Override
	public String toString() {
		return ip + " " + date + " " + resource + " " + responseCode + " " + unk1 + " " + referingSite + " " + browserInfo;

	}
}
