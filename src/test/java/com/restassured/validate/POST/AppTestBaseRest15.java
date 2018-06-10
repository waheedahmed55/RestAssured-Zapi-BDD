package com.restassured.validate.POST;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeSuite;

import com.restassured.util.AppTestBase;

public class AppTestBaseRest15 extends AppTestBase {

	@BeforeSuite
	public void testhealthcheck()
	{
		
    	given().baseUri(BASE_URI2).request().auth().basic("userName", "pwd").expect().statusCode(200);

	}
}
