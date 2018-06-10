package com.restassured.create.POST;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.io.InputStream;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.internal.util.IOUtils;

public class SchemaValidationsTest extends AppTestBaseRest17 {
	
	public void setJiraTestCaseParamters() {
		// This should be mapped to existing JIRA issue
		// If test case is created already in JIRA update issueID to use "id" of test case
		this.issueID = "109726"; // This is the ID for JIRA issue ISPT4-47
		this.desc = "Schema Validation Test";
	}
	
	@Test
	public void schemaValidation() throws IOException {
		
		
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("addressTypeCd","1");
		jsonObject.addProperty("postalCode",12345);
		jsonObject.addProperty("provinceCode",6);
		jsonObject.addProperty("municipality","string with more than 30 characters shouldnt be accepted ");
		jsonObject.addProperty("streetNbr","888");
		jsonObject.addProperty("streetName","string with more than 30 characters shouldnt be accepted ");
		jsonObject.addProperty("streetNbrSuffix",4);
		jsonObject.addProperty("streetTypeCd","abcd");
		jsonObject.addProperty("streetDirectionCd","abcd");
		jsonObject.addProperty("ruralIdentifierCd","lolol");
		jsonObject.addProperty("routeName","SS00000000000000000000001");
		jsonObject.addProperty("site","SS01");
		jsonObject.addProperty("compartment","SS01");
		jsonObject.addProperty("concession","jk");
		jsonObject.addProperty("lot","nm");
		jsonObject.addProperty("installationName",19);
		jsonObject.addProperty("poBoxNbr","string with more than 35 characters shouldnt be accepted ");
		jsonObject.addProperty("notes","string with more than 35 characters shouldnt be accepted Hello");

		String payload = jsonObject.toString();
	
	
	
	 InputStream input =given().baseUri(BASE_URI)
	.contentType("application/json")
	.body(payload)
	.auth().basic("userName", "pwd")
	.when()
	.post()
	.then()
	.assertThat().statusCode(400).and()
	.extract().asInputStream();
	 String actualtext = new String(IOUtils.toByteArray(input));
	 System.out.println(actualtext);
     Assert.assertTrue(actualtext.contains("Schema validation failed: $.streetName: may only be 35 characters long, $.notes: may only be 50 characters long, $.postalCode: integer found, string expected, $.routeName: may only be 20 characters long, $.streetNbrSuffix: integer found, string expected, $.compartment: string found, integer expected, $.lot: string found, integer expected, $.installationName: integer found, string expected, $.streetNbr: string found, integer expected, $.addressTypeCd: string found, integer expected, $.streetDirectionCd: string found, integer expected, $.entirePostalCodeInd: is missing but it is required, $.site: string found, integer expected, $.poBoxNbr: string found, integer expected, $.postalCode: does not match the regex pattern ^[A-Za-z][0-9][A-Za-z]([ -])?[0-9][A-Za-z][0-9]$, $.concession: string found, integer expected, $.streetTypeCd: string found, integer expected, $.municipality: may only be 30 characters long, $.provinceCode: integer found, string expected, $.ruralIdentifierCd: string found, integer expected"));
	 // Uncomment for demo
     Assert.assertFalse(true);
	}

}
