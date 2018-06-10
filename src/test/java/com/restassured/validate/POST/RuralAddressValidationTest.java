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

public class RuralAddressValidationTest extends AppTestBaseRest15 {
	
	@Test
	public void validateRuralAddressSameExact() throws Exception {
    	Gson jsonPayload = new Gson();
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(2)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("QC")
    			.municipalityname("FOXWORTH")
    			.routename("RR0004")
    			.ruralidentifiercd(1)
    			.Site(99)
    			.Compartment(99)
    			.Concession(99)
    			.Lot(99)
    			.note("this is rural")
    			.build();
    
		int recordID = Utility.queryAddressCreation(pojo);

    
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
	public void validateRuralAddressDifferentPostalCd() throws Exception {
    	Gson jsonPayload = new Gson();
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(2)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("QC")
    			.municipalityname("Foxworth")
    			.routename("RR0004")
    			.ruralidentifiercd(1)
    			.Site(99)
    			.Compartment(99)
    			.Concession(99)
    			.Lot(99)
    			.note("this is rural")
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
	public void validateRuralAddressDifferentRuralIDCd() throws Exception {
    	Gson jsonPayload = new Gson();
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(2)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("QC")
    			.municipalityname("Foxworth")
    			.routename("RR0004")
    			.ruralidentifiercd(1)
    			.Site(99)
    			.Compartment(99)
    			.Concession(99)
    			.Lot(99)
    			.note("this is rural")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

    
    	 
 
    	 pojo.setRuralIdentifierCd(2);
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
    	 pojo.setRuralIdentifierCd(1);
    	try {
    		//Validate the record with assertions against DB
			Utility.queryUnacceptableAd(recordID, this::assertUnacceptableAdd, pojo);
			
			
		
		} finally {
			//Delete the record
			Utility.queryUnacceptableAdDelete(recordID);
		}

    	
    }
	@Test
	public void validateRuralAddressDifferentRouteName() throws Exception {
    	Gson jsonPayload = new Gson();
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(2)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("QC")
    			.municipalityname("Foxworth")
    			.routename("RR0004")
    			.ruralidentifiercd(1)
    			.Site(99)
    			.Compartment(99)
    			.Concession(99)
    			.Lot(99)
    			.note("this is rural")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

    
    	 
 
    	 pojo.setRouteName("RR0054");
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
    	 
    	 pojo.setRouteName("RR0004");

    	try {
    		//Validate the record with assertions against DB
			Utility.queryUnacceptableAd(recordID, this::assertUnacceptableAdd, pojo);
			
			
		
		} finally {
			//Delete the record
			Utility.queryUnacceptableAdDelete(recordID);
		}

    	
    }
	@Test
    public void validateRuralAddressMissingReqFields() throws Exception {
    	Gson jsonPayload = new Gson();
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(2)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("QC")
    			.municipalityname("Youvile")
    			.routename("RR0006")
    			.ruralidentifiercd(1)
    			.Site(59)
    			.Compartment(60)
    			.Concession(61)
    			.Lot(62)
    			.note("this is rural")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

    	 
         String postalcd2 = Utility.generateUnacceptableAddPostalCd();

    	 final UnacceptableAddPojo pojo2 = new UnacceptableAddBuilder()
    			.addresstypecode(2)
     			.entirepostalcodeInd(false)
     			.postalcode(postalcd2)
     			.provincecode("QC")
     			.municipalityname("Mart")
     			.routename("RR0009")
     			.ruralidentifiercd(1)
     			.Site(60)
     			.Compartment(61)
     			.Concession(62)
     			.Lot(63)
     			.InstallationName("STNBRB")
     			.note("this is rural")
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
