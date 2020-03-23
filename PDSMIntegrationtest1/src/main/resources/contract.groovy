
import org.springframework.cloud.contract.spec.Contract
Contract.make{
description description: "should return response"
request{

url url:"/api/hello"
}
response{
status status:201
}
}