package com.restassured.create.POST;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeSuite;

import com.restassured.zapi.ZapiTestBase;

public class AppTestBaseRest17 extends ZapiTestBase {
	
	public void setJiraStoryID() {
		this.storyID = "109705"; // ISPT4-26
	}

	@BeforeSuite
    public void testhealthcheck() {
    	given().baseUri(BASE_URI).request().auth().basic("userName", "pwd").expect().statusCode(200);
    }

}

