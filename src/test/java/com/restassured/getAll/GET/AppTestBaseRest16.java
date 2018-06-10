package com.restassured.getAll.GET;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeSuite;

import com.restassured.util.AppTestBase;

public class AppTestBaseRest16 extends AppTestBase{
	
	@BeforeSuite
	public void testhealthcheck()
	{
		
    	given().baseUri(BASE_URI).request().auth().basic("userName", "pwd").expect().statusCode(200);

	}

}
