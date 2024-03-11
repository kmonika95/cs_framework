package com.Base;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//successfully run

public class PostRequestDeptUpdate extends Baseclass{
	@Test 
	void TC03() {
		
		RestAssured.baseURI= dept_update_url+ "/26";

		JSONObject jsonData = new JSONObject();
		//jsonData.put("deptId", "26");
		jsonData.put("deptName", "qa");
		
	    String AuthToken = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBnbWFpbC5jb20iLCJleHAiOjE3MDk3MzcxNjcsImlhdCI6MTcwOTcwMTE2N30.3IJHb2-y90BguEggCEzGfIm5EC-vlKw2W6-B9YeSqH4";
		   
	    RequestSpecification requestspec = RestAssured.given().header("Authorization",AuthToken).
	    contentType(ContentType.JSON).body(jsonData.toJSONString());
	    
	 // perform post request
		Response response= requestspec.post();
		
		// print status line
		//Assert.assertEquals(response.statusCode(),200);
		response.then().statusCode(200).log().all();
}
}