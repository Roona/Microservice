# WeatherAPI
Weather API Repo : [https://github.com/hrusikeshj/WeatherAPI.git]
About this API : 
This API has been built on Sprint Boot application and Spring Restful API. In controller layer it will accept ZipCode as input and pass to 
service layer and service will call existing external weather api [https://api.openweathermap.org/data/2.5/forecast] to get the response for next 5 days weather prediction. From which 
service will filter for OneDay next to current day.

Java version used : 1.8
In built Tomcat server and application can be accessed from Tomcat defaulyt port : {8080}. 
Application root context : [weatherapi]
Request:
City zipCode to the service url. http://localhost:8080/weatherapi/{zipCode}
Response : 
Response is a well formatted JSON which will contains each three hours weather results.

For more information here is the api swagger links :
[http://localhost:8080/swagger-ui.html]
[http://localhost:8080/v2/api-docs]


