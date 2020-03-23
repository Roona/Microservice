package com.demo.api3.response.model;

import java.io.Serializable;

public class Asset_Inquiry_FS_Response implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String status;
	private String serial_number;
	
	private String model_category;
	private String location_code;
	public String getStatus() {
		return status;
	}
	public String getModel_category() {
		return model_category;
	}
	public void setModel_category(String model_category) {
		this.model_category = model_category;
	}
	public String getLocation_code() {
		return location_code;
	}
	public void setLocation_code(String location_code) {
		this.location_code = location_code;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSerial_number() {
		return serial_number;
	}
	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
