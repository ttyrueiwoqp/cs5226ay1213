package com.nus.cs.domain;

import java.util.List;

public class DebugTO {
	private boolean success;
	private List<String> header;
	private List<List<String>> table;
	private String error;
	
	public List<String> getHeader() {
		return header;
	}
	
	public void setHeader(List<String> header) {
		this.header = header;
	}
	
	public boolean getSuccess() {
		return success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public String getError() {
		return error;
	}
	
	public void setError(String error) {
		this.error = error;
	}
	
	public List<List<String>> getTable() {
		return table;
	}
	
	public void setTable(List<List<String>> table) {
		this.table = table;
	}
	
}
