package com.example.demo.controller;

import java.util.Date;

public class DeviceContext {

	
	Long id;
    String macAdress;
    String timestamp;
	
	  public String getMacAdress() {
		return macAdress;
	}
	public void setMacAdress(String macAdress) {
		this.macAdress = macAdress;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public Long getId() {
		return id;
	}
	
	
	
}
