package com.nus.cs.domain;

public class DBTO {
	
	private String startTime;
	private String endTime;
	private double avgValue;
	private String otherData;
	private String interval;
	
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public double getAvgValue() {
		return avgValue;
	}
	public void setAvgValue(double avgValue) {
		this.avgValue = avgValue;
	}
	public String getOtherData() {
		return otherData;
	}
	public void setOtherData(String otherData) {
		this.otherData = otherData;
	}
	public String getInterval() {
		return interval;
	}
	public void setInterval(String interval) {
		this.interval = interval;
	}
	
}