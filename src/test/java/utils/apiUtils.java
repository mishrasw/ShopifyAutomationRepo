package utils;

import static io.restassured.RestAssured.given;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class apiUtils {
	
	
	 public static Response getRequestToEndpointUrlToFetchResponse(String requestType,String url, String requestBody) {

		 RestAssured.defaultParser = Parser.JSON;
		 Response response;
		 switch(requestType.trim().toUpperCase()) {
		 case "GET":
			 response = given().headers("Content-Type", ContentType.JSON).
             when().get(url).
             then().contentType(ContentType.JSON).extract().response();
			 break;
		 case "POST":
			 response =given().headers("Content-Type", ContentType.JSON).
			 body(requestBody).
             when().post(url).
             then().contentType(ContentType.JSON).extract().response();
			 break;
		 default : 
			 response = given().headers("Content-Type", ContentType.JSON).
             when().get(url).
             then().contentType(ContentType.JSON).extract().response();
			 break;
		 
	 }
		 return response;
	        
	 }
	 public int getNumberofChildNodes(Response response,String jsonPath) {
		
		 ResponseBody bdy = response.getBody();
	     JsonPath j = response.jsonPath();
	     List<String> nodeParams = j.get(jsonPath);
	     return nodeParams.size();
		 
	 }
	 
}
