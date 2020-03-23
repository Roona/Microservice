import org.springframework.cloud.contract.spec.Contract
Contract.make{
request{
method 'GET'
urlPath("/api/hclfe/asset_inquiry"){
queryParameters {
parameter 'serial_number': equalTo("1N1G9Z2")
parameter 'meter_number': equalTo("987654")
}
}


headers {
			header 'user': 'fdx_nexus_asset_integration'
			header 'password' : 'RHe2hWlTO4SjhNir7WTrvRa4x'
			contentType('application/json')
		}
}
response{
status 200
body(file("response1.json"))
headers {
			contentType('application/json')
		}
}
}