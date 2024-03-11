package com.Base;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//successfully run

public class FirstpostRequest extends Baseclass {
	@Test 
	void TC01() {

     String jsonRequestBodyAsString= "{\"email\": \"admin@gmail.com\",\"password\":\"Admin@123\"}";

     RestAssured.baseURI= login_url;
	
	 RequestSpecification rescheck = RestAssured.given();
	 rescheck.contentType(ContentType.JSON);
	 rescheck.body(jsonRequestBodyAsString);
	 
	 Response response = rescheck.post();
	 System.out.println(response.getBody().asPrettyString());
	 System.out.println(response.body());
	
}
}