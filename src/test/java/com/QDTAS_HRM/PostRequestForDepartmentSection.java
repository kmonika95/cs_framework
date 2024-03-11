package com.QDTAS_HRM;

import java.io.IOException;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


 public class PostRequestForDepartmentSection extends Baseclass {
	
	String AuthToken = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBnbWFpbC5jb20iLCJleHAiOjE3MTAxNjk1NzQsImlhdCI6MTcxMDEzMzU3NH0.JtsUA5m3kyNsubDxE0TfBAbNynWa3TOJiLSeTBXVYRk";

	@Test(priority = 1)
	void generateToken() {
		String jsonRequestBodyAsString = "{\"email\": \"admin@gmail.com\",\"password\":\"Admin@123\"}";
		RestAssured.baseURI = login_url;
		RequestSpecification rescheck = RestAssured.given();
		rescheck.contentType(ContentType.JSON);
		rescheck.body(jsonRequestBodyAsString);
		 Response response = rescheck.post();
		 System.out.println(response.getBody().asPrettyString());
		 System.out.println(response.body());}

	@Test(priority = 2, dataProvider = "empDataProvider", dataProviderClass = com.Utility.DataDrivenTestingUsingExcel.class)
	void addDepatment(String deptId, String name) {
		RestAssured.baseURI = dept_add_url;
		JSONObject jsonData = new JSONObject();
		jsonData.put("deptId", deptId);
		jsonData.put("deptName", name);
		RequestSpecification requestspec = RestAssured.given().header("Authorization", AuthToken)
		.contentType(ContentType.JSON).body(jsonData.toJSONString());
		// perform get request
		Response response = requestspec.post();
		// print status line
		Assert.assertEquals(response.statusCode(), 201);
		response.then().statusCode(201).log().all();}
	
	@Test(priority = 3)//, dataProvider ="empDataProviderUpdate", dataProviderClass = ExcelUtils.class)
	void  updateDepatment() throws IOException {
		RestAssured.baseURI = dept_update_url + "/26";
	JSONObject jsonData = new JSONObject();
		jsonData.put("deptName", "HR");
		// jsonData.put("deptId", "26");
	//jsonData.put("deptName" , name1);
		RequestSpecification requestspec = RestAssured.given().header("Authorization", AuthToken)
				.contentType(ContentType.JSON).body(jsonData.toJSONString());
		// perform post request
		Response response = requestspec.post();
		// print status line
		// Assert.assertEquals(response.statusCode(),200);
		response.then().statusCode(200).log().all();}

	@Test(priority = 4)
	void getAllEmpByDeptId() {
		RestAssured.baseURI = all_emp_dept_url + "/22";

		RequestSpecification requestspec = RestAssured.given().header("Authorization", AuthToken)
				.contentType(ContentType.JSON);

		// perform post request
		Response response = requestspec.post();

		// print status line
		Assert.assertEquals(response.statusCode(), 200);
		response.then().statusCode(200).log().all();
	}

	@Test(priority = 5)
	void AllDept() {
		RestAssured.baseURI = all_dept_url;

		RequestSpecification requestspec = RestAssured.given().header("Authorization", AuthToken)
				.contentType(ContentType.JSON);

		// perform post request
		Response response = requestspec.post();

		// print status line
		Assert.assertEquals(response.statusCode(), 200);
		response.then().statusCode(200).log().all();
	}

	@Test(priority = 6)
	void deleteDepartment() {
		RestAssured.baseURI = dept_delete_url + "/24";

		RequestSpecification requestspec = RestAssured.given().header("Authorization", AuthToken)
				.contentType(ContentType.JSON);

		// perform post request
		Response response = requestspec.post();

		// print status line
		// Assert.assertEquals(response.statusCode(),200);
		response.then().statusCode(200).log().all();
	}
}
