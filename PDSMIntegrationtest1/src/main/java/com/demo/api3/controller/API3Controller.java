package com.demo.api3.controller;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.api3.request.model.Asset_Inquiry_Model;
import com.demo.api3.request.model.Meter_inquiry;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@RestController
@RequestMapping("/api")
public class API3Controller {

	Logger logger = LoggerFactory.getLogger(API3Controller.class);
/*
	@PostMapping(value = "/test2")
	public Asset_Inquiry_FS_Response assetInquiryBO(
			@RequestBody String serial_number)
			throws IOException {
		Asset_Inquiry_FS_Response asset_inquiry_FS_response = new Asset_Inquiry_FS_Response();
		asset_inquiry_FS_response.setSerial_number(serial_number);
		asset_inquiry_FS_response.setLocation_code("CANEQ");
	    asset_inquiry_FS_response.setModel_category("computers");
		return asset_inquiry_FS_response;
	}

	@RequestMapping(path = "/test3")
	public Asset_Inquiry_FS_Response assetInquiryPV(@RequestBody Asset_Inquiry_Request asset_inquiry_request)
			 {
	
		Asset_Inquiry_FS_Response asset_inquiry_FS_response = new Asset_Inquiry_FS_Response();
		asset_inquiry_FS_response.setSerial_number(asset_inquiry_request.getSerial_number());
		asset_inquiry_FS_response.setLocation_code("CANEQ");
	    asset_inquiry_FS_response.setModel_category("computers");
		return asset_inquiry_FS_response;
	}*/
/*	
	@RequestMapping(path = "/test3")
	public void mockDataGenerator()
			 {
	
		Asset_Inquiry_FS_Response asset_inquiry_FS_response = new Asset_Inquiry_FS_Response();
		asset_inquiry_FS_response.setSerial_number(asset_inquiry_request.getSerial_number());
		asset_inquiry_FS_response.setLocation_code("CANEQ");
	    asset_inquiry_FS_response.setModel_category("computers");
		return asset_inquiry_FS_response;
	}*/
	
@RequestMapping("/hello")
	
	public String hellonew(){
	
		
	
		return "Hello" ;
		
	}

@RequestMapping("/hclfe/asset_inquiry")

public Asset_Inquiry_Model hellonew1() throws JsonParseException, JsonMappingException, IOException{
	ObjectMapper mapper = new ObjectMapper();
	Asset_Inquiry_Model model = mapper.readValue(new File("C:\\Workspace\\AOP\\PDSMIntegrationtest1\\src\\test\\resources\\contracts\\response2.json"), Asset_Inquiry_Model.class);
System.out.println("testing controller");
	return model;
	
}
@RequestMapping("/hclfe/asset_inquiry1")

public Meter_inquiry hellonew2() throws JsonParseException, JsonMappingException, IOException{
	ObjectMapper mapper = new ObjectMapper();
	Meter_inquiry model = mapper.readValue(new File("C:\\Workspace\\AOP\\PDSMIntegrationtest1\\src\\test\\resources\\contracts\\response3.json"), Meter_inquiry.class);
System.out.println("testing controller");
	return model;
	
}
}
