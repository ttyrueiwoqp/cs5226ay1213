package com.nus.cs.domain;

public class DBTO {
	
	private String startTime;
	private String endTime;
	private double avgValue;
	private String otherData;
	private int x;
	private int y;
	
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
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}