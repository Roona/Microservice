package com.demo.api3.request.model;

import java.io.Serializable;

import com.demo.api3.response.model.Asset_Inquiry_FS_Response;

public class Asset_Inquiry_Model implements Serializable{
	private Meter_inquiry meter_inquiry ;
	private Serial_inquiry serial_inquiry;

	public Serial_inquiry getSerial_inquiry() {
		return serial_inquiry;
	}
	public void setSerial_inquiry(Serial_inquiry serial_inquiry) {
		this.serial_inquiry = serial_inquiry;
	}
	public Meter_inquiry getMeter_inquiry() {
		return meter_inquiry;
	}
	public void setMeter_inquiry(Meter_inquiry meter_inquiry) {
		this.meter_inquiry = meter_inquiry;
	}
	
	


	
}
