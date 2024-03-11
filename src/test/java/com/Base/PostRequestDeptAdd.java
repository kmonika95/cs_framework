package com.Base;

import org.testng.Assert;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.simple.JSONObject;

//successfully run

public class PostRequestDeptAdd extends Baseclass{
@Test 
void TC02() {
	
	RestAssured.baseURI= dept_add_url;
	
	JSONObject jsonData = new JSONObject();
	jsonData.put("deptId", "26");
	jsonData.put("deptName", "Finance");
	
    String AuthToken = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBnbWFpbC5jb20iLCJleHAiOjE3MDk3MzcxNjcsImlhdCI6MTcwOTcwMTE2N30.3IJHb2-y90BguEggCEzGfIm5EC-vlKw2W6-B9YeSqH4";
   
    RequestSpecification requestspec = RestAssured.given().header("Authorization",AuthToken).
    contentType(ContentType.JSON).body(jsonData.toJSONString());
    
    //perform get request
    Response response= requestspec.post();
    
    String responseBodyString = response.getBody().asString();
    System.out.println("Response Body: " +responseBodyString);
   
	// print status line
	Assert.assertEquals(response.statusCode(),201);
	response.then().statusCode(201).log().all();
	
	//String responseBodyString = response.getBody().asString();
//	response.then().statusCode(201).log().all();
	//System.out.println("Response Body: " + responseBodyString);

	
    
}
}
