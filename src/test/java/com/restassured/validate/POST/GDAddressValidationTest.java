package com.restassured.validate.POST;

import static io.restassured.RestAssured.given;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.restassured.pojo.UnacceptableAddBuilder;
import com.restassured.pojo.UnacceptableAddPojo;
import com.restassured.util.Utility;

public class GDAddressValidationTest extends AppTestBaseRest15 {
	
	@Test
	public void validateGDAddressSameExact() throws Exception {
		
    	Gson jsonPayload = new Gson();
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(4)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("QC")
    			.municipalityname("UTAH")
    			.InstallationName("ABCD")
    			.note("THIS IS GD")
    			.build();
    	

		int recordID = Utility.queryAddressCreation(pojo);

    
    	String payload = jsonPayload.toJson(pojo);

    	 //need to ask why to remove entirunitrangeind when not setting in payload
    	 JsonObject jsonObject = jsonPayload.fromJson(payload, JsonObject.class);
    	 jsonObject.remove("notes");
    	 jsonObject.remove("entirePostalCodeInd");
    	 jsonObject.remove("entireUnitRangeInd");
    	 jsonObject.remove("installationName");

    	 payload = jsonObject.toString();
    	 
    	 given().baseUri(BASE_URI2)
      	.contentType("application/json")
      	.body(payload)
      	.auth().basic("userName", "pwd")
      	.when()
      	.post()
      	.then()
      	.assertThat().statusCode(200).and()
     	.body("valid", Matchers.equalTo(new Boolean(false)) );
   
    	try {
    		//Validate the record with assertions against DB
			Utility.queryUnacceptableAd(recordID, this::assertUnacceptableAdd, pojo);
			
			
		
		} finally {
			//Delete the record
			Utility.queryUnacceptableAdDelete(recordID);
		}   
    	
    }
	@Test
	public void validateGDAddressDifferentPostalCd() throws Exception {
		
    	Gson jsonPayload = new Gson();
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(4)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("QC")
    			.municipalityname("Utah")
    			.InstallationName("ABCD")
    			.note("this is GD Ad1")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

		
    	 
    	 //need to ask why to remove entirunitrangeind when not setting in payload
         String postalcd2 = Utility.generateUnacceptableAddPostalCd();

    	 pojo.setPostalCode(postalcd2);
    	 String payload = jsonPayload.toJson(pojo);
    	 JsonObject jsonObject = jsonPayload.fromJson(payload, JsonObject.class);
    	 jsonObject.remove("entireUnitRangeInd");
    	 jsonObject.remove("notes");
    	 jsonObject.remove("entirePostalCodeInd");
    	 jsonObject.remove("installationName");

    	 payload = jsonObject.toString();
    	 
    	 given().baseUri(BASE_URI2)
     	.contentType("application/json")
     	.body(payload)
     	.auth().basic("userName", "pwd")
     	.when()
     	.post()
     	.then()
     	.assertThat().statusCode(200).and()
     	.body("valid", Matchers.equalTo(new Boolean(true)) );
    	 pojo.setPostalCode(postalcd);
   
    	try {
    		//Validate the record with assertions against DB
			Utility.queryUnacceptableAd(recordID, this::assertUnacceptableAdd, pojo);
			
			
		
		} finally {
			//Delete the record
			Utility.queryUnacceptableAdDelete(recordID);
		}   
    	
    }
	@Test
    public void validateGDAddressMissingReqFields() throws Exception {
    	Gson jsonPayload = new Gson();
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(4)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("QC")
    			.municipalityname("Utah")
    			.InstallationName("GDSTN")
    			.note("this is GD Ad1")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

		
    	 
    	 final UnacceptableAddPojo pojo2 = new UnacceptableAddBuilder()
    			 .addresstypecode(4)
     			.entirepostalcodeInd(false)
     			.postalcode("Z1X 3Y0")
     			.provincecode("NB")
     			.municipalityname("Goodreach")
     			.InstallationName("GDSTN1")
     			.note("this is GD Ad2")
     			.build();
       	
       	String payload2 = jsonPayload.toJson(pojo2);

     	 JsonObject jsonObject = jsonPayload.fromJson(payload2, JsonObject.class);
     	 jsonObject.remove("entireUnitRangeInd");
     	 jsonObject.remove("notes");
     	 jsonObject.remove("entirePostalCodeInd");
     	 jsonObject.remove("postalCode");
     	 jsonObject.remove("provinceCode");
     	 jsonObject.remove("municipality");
    	 jsonObject.remove("installationName");

     	 payload2 = jsonObject.toString();
     	 
     	 String ResponseBody= given().baseUri(BASE_URI2)
      	.contentType("application/json")
      	.body(payload2)
      	.auth().basic("userName", "pwd")
      	.when()
      	.post()
      	.then()
      	.assertThat().statusCode(400).and()
        .extract().body().asString();
         Assert.assertTrue(ResponseBody.contains("schemaValidation"));
         Assert.assertTrue(ResponseBody.contains("Schema validation failed: $.postalCode: is missing but it is required, $.municipality: is missing but it is required, $.provinceCode: is missing but it is required"));
   
    	
    
    	try {
    		//Validate the record with assertions against DB
			Utility.queryUnacceptableAd(recordID, this::assertUnacceptableAdd, pojo);
			
		} finally {
			//Delete the record
			Utility.queryUnacceptableAdDelete(recordID);
		}
	}

}
