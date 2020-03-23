/*package com.demo.api3.controller;

import static com.toomuchcoding.jsonassert.JsonAssertion.assertThatJson;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.assertj.core.api.BDDAssertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerRule;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.demo.api3.API3AppApplication;
import com.demo.api3.request.model.Asset_Inquiry_Model;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes={API3AppApplication.class})
@AutoConfigureWireMock(port=8878)
@AutoConfigureStubRunner(ids="com.demo:PDSMIntegration:+:stubs:8090",
stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class TestContract {

	 WireMockServer wireMockServer;
	 
	 //Test with virtual service using wiremock - scenario stub is not available and API is not ready
	 
		@Test
		public void test_should_return_response() throws JsonParseException, JsonMappingException, IOException{
			int randomServerPort=8878;
			 final String baseUrl2 = "http://localhost:"+randomServerPort+"/api/hclfe/asset_inquiry";
			 String testUrl;
			// System.out.println(WireMock.listAllStubMappings());;
			WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/api/hclfe/asset_inquiry"))
					 .willReturn(WireMock.aResponse().withStatus(201)
							 .withBodyFile("response.json")));
			RestTemplate rt = new RestTemplate();
			ResponseEntity<String> response =  rt.getForEntity(baseUrl2,String.class);
			
			ObjectMapper mapper = new ObjectMapper();
			String jsonInString1 =  response.getBody().toString();
			System.out.println(jsonInString1);
			Asset_Inquiry_Model model = mapper.readValue(jsonInString1, Asset_Inquiry_Model.class);
			BDDAssertions.then(response.getStatusCodeValue()).isEqualTo(201);
			assertEquals(model.getMeter_inquiry().getMeter_Number(),"987654");
			
		}

	
	//Download and test against stub
		
		@Test
		public void test_should_return_response_integration(){
			int randomServerPort=8090;
			 final String baseUrl2 = "http://localhost:"+randomServerPort+"/api/hclfe/asset_inquiry";
			 String testUrl;
		
			RestTemplate rt = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("user", "fdx_nexus_asset_integration");
			headers.set("password", "RHe2hWlTO4SjhNir7WTrvRa4x");
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl2)
			        .queryParam("serial_number", "1N1G9Z2")
			         .queryParam("meter_number", "987654");
			HttpEntity entity = new HttpEntity(headers);
			ResponseEntity<String> response =  rt.exchange(builder.toUriString(),HttpMethod.GET,entity,String.class);
			BDDAssertions.then(response.getStatusCodeValue()).isEqualTo(200);
			DocumentContext parsedJson = JsonPath.parse(response.getBody().toString());
			assertThatJson(parsedJson).field("['meter_inquiry']").field("['company']").isEqualTo("");
			assertThatJson(parsedJson).field("['serial_inquiry']").field("['comments']").isEqualTo("Created1");
			assertThatJson(parsedJson).field("['meter_inquiry']").field("['serial_number']").isEqualTo("suri");
			assertThatJson(parsedJson).field("['meter_inquiry']").field("['hardware_Support_Group']").isEqualTo("FXG_SPT_US_GroundFieldEUC");
			assertThatJson(parsedJson).field("['meter_inquiry']").field("['model']").isEqualTo("HP EliteBook 840 G3");
			assertThatJson(parsedJson).field("['meter_inquiry']").field("['fedex_Part_Number']").isEqualTo("");
			assertThatJson(parsedJson).field("['meter_inquiry']").field("['meter_Number']").isEqualTo("987654");
			assertThatJson(parsedJson).field("['serial_inquiry']").field("['hardware_Support_Group']").isEqualTo("");
			assertThatJson(parsedJson).field("['serial_inquiry']").field("['meter_Number']").isEqualTo("");
			assertThatJson(parsedJson).field("['serial_inquiry']").field("['serial_number']").isEqualTo("1N1G9Z2");
			assertThatJson(parsedJson).field("['meter_inquiry']").field("['ci_Name']").isEqualTo("");
			assertThatJson(parsedJson).field("['serial_inquiry']").field("['asset_Tag']").isEqualTo("1N1G9Z2");
			assertThatJson(parsedJson).field("['serial_inquiry']").field("['assigned_To']").isEqualTo("");
			assertThatJson(parsedJson).field("['serial_inquiry']").field("['owned_By']").isEqualTo("");
			assertThatJson(parsedJson).field("['meter_inquiry']").field("['assigned_To']").isEqualTo("Yvette Murray");
			assertThatJson(parsedJson).field("['meter_inquiry']").field("['display_name']").isEqualTo("5CG7200L8Z - HP EliteBook 840 G3");
			assertThatJson(parsedJson).field("['serial_inquiry']").field("['location']").isEqualTo("CANEQ-00000000-ASSET MANAGEMENT LOC");
			assertThatJson(parsedJson).field("['serial_inquiry']").field("['fedex_Part_Number']").isEqualTo("");
			assertThatJson(parsedJson).field("['serial_inquiry']").field("['model']").isEqualTo("HP EliteBook x360 1030 G2");
			assertThatJson(parsedJson).field("['meter_inquiry']").field("['asset_Tag']").isEqualTo("5CG7200L8Z");
			assertThatJson(parsedJson).field("['serial_inquiry']").field("['company']").isEqualTo("");
			assertThatJson(parsedJson).field("['meter_inquiry']").field("['owned_By']").isEqualTo("Michael Anthony Andrejco");
			assertThatJson(parsedJson).field("['serial_inquiry']").field("['display_name']").isEqualTo("1N1G9Z2 - HP EliteBook x360 1030 G2");
			assertThatJson(parsedJson).field("['serial_inquiry']").field("['ci_Name']").isEqualTo("HP EliteBook x360 1030 G2");
			assertThatJson(parsedJson).field("['meter_inquiry']").field("['location']").isEqualTo("FGOSS-00000090-FDX GRD/OSS PITTSBURGH");
			assertThatJson(parsedJson).field("['meter_inquiry']").field("['comments']").isEqualTo("Created1");
			
		}
		
}
*/