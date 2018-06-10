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

public class POBoxAddressValidationTest extends AppTestBaseRest15{
	
	@Test
	public void validatePOBoxAddressSameExact() throws Exception {

    	Gson jsonPayload = new Gson();
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(3)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("NL")
    			.municipalityname("LoydFord")
    			.PoBoxNbr(909)
    			.note("this is pobox")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

    
    	String payload = jsonPayload.toJson(pojo);

    	 
    	 JsonObject jsonObject = jsonPayload.fromJson(payload, JsonObject.class);
    	 jsonObject.remove("notes");
    	 jsonObject.remove("entirePostalCodeInd");
    	 jsonObject.remove("entireUnitRangeInd");
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
	public void validatePOBoxAddressDifferentPostalCd() throws Exception {

	
    	Gson jsonPayload = new Gson();
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(3)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("AL")
    			.municipalityname("Yop")
    			.PoBoxNbr(1947)
    			.note("this is pobox12")
    			.build();
		int recordID = Utility.queryAddressCreation(pojo);

    
    	 
    	 
         String postalcd2 = Utility.generateUnacceptableAddPostalCd();

    	 pojo.setPostalCode(postalcd2);
    	 String payload = jsonPayload.toJson(pojo);
    	 JsonObject jsonObject = jsonPayload.fromJson(payload, JsonObject.class);
    	 jsonObject.remove("entireUnitRangeInd");
    	 jsonObject.remove("notes");
    	 jsonObject.remove("entirePostalCodeInd");
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
	public void validatePOBoxAddressDifferentPOBox() throws Exception {

	
    	Gson jsonPayload = new Gson();
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(3)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("BC")
    			.municipalityname("Hiep")
    			.PoBoxNbr(1945)
    			.note("this is POB-V")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

    	 
    	 
    	 pojo.setPoBoxNbr(1958);
    	 String payload = jsonPayload.toJson(pojo);
    	 JsonObject jsonObject = jsonPayload.fromJson(payload, JsonObject.class);
    	 jsonObject.remove("entireUnitRangeInd");
    	 jsonObject.remove("notes");
    	 jsonObject.remove("entirePostalCodeInd");
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
    	 pojo.setPoBoxNbr(1945);
   
    	try {
    		//Validate the record with assertions against DB
			Utility.queryUnacceptableAd(recordID, this::assertUnacceptableAdd, pojo);
			
			
	
		} finally {
			//Delete the record
			Utility.queryUnacceptableAdDelete(recordID);
		}   
    	
    }
	@Test
    public void validatePOBoxAddressMissingReqFields() throws Exception {
    	Gson jsonPayload = new Gson();
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(3)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("BC")
    			.municipalityname("Hiep")
    			.PoBoxNbr(1945)
    			.InstallationName("H1B")
    			.note("this is POB-V")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

    	 
    	 
    	 final UnacceptableAddPojo pojo2 = new UnacceptableAddBuilder()
    			 .addresstypecode(3)
     			.entirepostalcodeInd(false)
     			.postalcode("N8J 3O9")
     			.provincecode("BC")
     			.municipalityname("Hut")
     			.PoBoxNbr(1942)
     			.InstallationName("H1BL")
     			.note("this is POB-VI")
     			.build();
       	
       	String payload2 = jsonPayload.toJson(pojo2);

     	 JsonObject jsonObject = jsonPayload.fromJson(payload2, JsonObject.class);
     	 jsonObject.remove("entireUnitRangeInd");
     	 jsonObject.remove("notes");
     	 jsonObject.remove("entirePostalCodeInd");
     	 jsonObject.remove("postalCode");
     	 jsonObject.remove("provinceCode");
     	 jsonObject.remove("municipality");
     	
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
         Assert.assertTrue(ResponseBody.contains("Schema validation failed: $.postalCode: is missing but it is required, $.municipality: is missing but it is required, $.provinceCode: is missing but it is required, $.installationName: is not defined in the schema and the schema does not allow additional properties"));
    	
    	
    
    	try {
    		//Validate the record with assertions against DB
			Utility.queryUnacceptableAd(recordID, this::assertUnacceptableAdd, pojo);
			
		} finally {
			//Delete the record
			Utility.queryUnacceptableAdDelete(recordID);
		}
	}

}
