package com.fedex.demo;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.api3.API3AppApplication;
import com.demo.api3.controller.API3Controller;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=API3AppApplication.class)
public class BaseClass {
	//Inject your controller
	@Autowired
	API3Controller controller;
	
	@Before
	public void setup(){
		RestAssuredMockMvc.standaloneSetup(controller);
	}

}
