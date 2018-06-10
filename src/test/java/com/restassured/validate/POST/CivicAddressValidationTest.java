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

public class CivicAddressValidationTest extends AppTestBaseRest15 {
	@Test
    public void validateCivicAddressSingleDifferentPostalCd() throws Exception {
    	Gson jsonPayload = new Gson();
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(1)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("ON")
    			.municipalityname("Bollywood")
    			.streetnbr(999)
    			.streetname("McDonald")
    			.StreetNbrSuffix("4")
    			.StreetTypeCd(11)
    			.StreetDirectionCd(5)
    			.EntireUnitRangeInd(false)
    			.UnitNbr("10")
    			.note("this is civic address")
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
    public void validateCivicAddressSingleDifferentStreetName() throws Exception {
    	Gson jsonPayload = new Gson();
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(1)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("ON")
    			.municipalityname("Bollywood")
    			.streetnbr(999)
    			.streetname("McDonald")
    			.StreetNbrSuffix("4")
    			.StreetTypeCd(11)
    			.StreetDirectionCd(5)
    			.EntireUnitRangeInd(false)
    			.UnitNbr("10")
    			.note("this is civic address")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

	
    	 
    	 pojo.setStreetName("Etibicoke");
    	 String payload = jsonPayload.toJson(pojo);
    	 JsonObject jsonObject = jsonPayload.fromJson(payload, JsonObject.class);
    	 //These fields were removed as they are not required for validations but required for creation
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
    	 
    	 pojo.setStreetName("McDonald");

    	try {
    		//Validate the record with assertions against DB
			Utility.queryUnacceptableAd(recordID, this::assertUnacceptableAdd, pojo);
			
		} finally {
			//Delete the record
			Utility.queryUnacceptableAdDelete(recordID);
		}

    	
    }
	@Test
    public void validateCivicAddressSingleDifferentUnitNbr() throws Exception {
    	Gson jsonPayload = new Gson();
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(1)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("ON")
    			.municipalityname("Bollywood")
    			.streetnbr(999)
    			.streetname("McDonald")
    			.StreetNbrSuffix("4")
    			.StreetTypeCd(11)
    			.StreetDirectionCd(5)
    			.EntireUnitRangeInd(false)
    			.UnitNbr("10")
    			.note("this is civic address")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

		
    	 
    	 pojo.setUnitNbr("11A");
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
    	 
    	 pojo.setUnitNbr("10");

    	try {
    		//Validate the record with assertions against DB
			Utility.queryUnacceptableAd(recordID, this::assertUnacceptableAdd, pojo);
			
		} finally {
			//Delete the record
			Utility.queryUnacceptableAdDelete(recordID);
		}

    	
    }
	@Test
    public void validateCivicAddressSingleSameExact() throws Exception {
    	Gson jsonPayload = new Gson();
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(1)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("ON")
    			.municipalityname("Bollywood")
    			.streetnbr(999)
    			.streetname("McDonald")
    			.StreetNbrSuffix("4")
    			.StreetTypeCd(11)
    			.StreetDirectionCd(5)
    			.EntireUnitRangeInd(false)
    			.UnitNbr("10")
    			.note("this is civic address")
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
    public void validateCivicAddressRangeToUnitNbr() throws Exception {
    	Gson jsonPayload = new Gson();
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(1)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("ON")
    			.municipalityname("Bollywood")
    			.streetnbr(999)
    			.streetname("McDonald")
    			.StreetNbrSuffix("4")
    			.StreetTypeCd(11)
    			.StreetDirectionCd(5)
    			.EntireUnitRangeInd(false)
    			.UnitNbr("10")
    			.ToUnitNbr("25")
    			.note("this is civic address")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

		
    	
    	pojo.setToUnitNbr("45");
    	pojo.setEntirePostalCodeInd(false);
    	
    	 String payload = jsonPayload.toJson(pojo);
    	 JsonObject jsonObject = jsonPayload.fromJson(payload, JsonObject.class);
    	 jsonObject.remove("entireUnitRangeInd");
    	 jsonObject.remove("notes");
    	 jsonObject.remove("entirePostalCodeInd");
    	 payload = jsonObject.toString();
    	 
    	 String ResponseBody = given().baseUri(BASE_URI2)
     	.contentType("application/json")
     	.body(payload)
     	.auth().basic("userName", "pwd")
     	.when()
     	.post()
     	.then()
    	.assertThat().statusCode(400).and()
        .extract().body().asString();
         Assert.assertTrue(ResponseBody.contains("schemaValidation"));
         Assert.assertTrue(ResponseBody.contains("Schema validation failed: $.toUnitNbr: is not defined in the schema and the schema does not allow additional properties"));
    	
         pojo.setToUnitNbr("25");
    	try {
    		//Validate the record with assertions against DB
			Utility.queryUnacceptableAd(recordID, this::assertUnacceptableAdd, pojo);
			
		} finally {
			//Delete the record
			Utility.queryUnacceptableAdDelete(recordID);
		}
	}

	@Test
    public void validateCivicAddressMissingReqFields() throws Exception {
    	Gson jsonPayload = new Gson();
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(1)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("ON")
    			.municipalityname("Bollywood")
    			.streetnbr(999)
    			.streetname("McDonald")
    			.StreetNbrSuffix("4")
    			.StreetTypeCd(11)
    			.StreetDirectionCd(5)
    			.EntireUnitRangeInd(false)
    			.UnitNbr("10")
    			.ToUnitNbr("25")
    			.note("this is civic address")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

		
    	 
    	 final UnacceptableAddPojo pojo2 = new UnacceptableAddBuilder()
       			.addresstypecode(1)
       			.entirepostalcodeInd(false)
       			.postalcode("K1Y 2P9")
       			.provincecode("BC")
       			.municipalityname("AppleWayR")
       			.streetnbr(1241)
       			.streetname("Minnie")
       			.StreetNbrSuffix("4")
       			.StreetTypeCd(11)
       			.StreetDirectionCd(5)
       			.EntireUnitRangeInd(false)
       			.UnitNbr("20")
       			.note("this is Civc2")
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
         Assert.assertTrue(ResponseBody.contains("\"Schema validation failed: $.postalCode: is missing but it is required, $.municipality: is missing but it is required, $.provinceCode: is missing but it is required\",\"params\":[\"$.postalCode: is missing but it is required, $.municipality: is missing but it is required, $.provinceCode: is missing but it is required"));
  
    	
    
    	try {
    		//Validate the record with assertions against DB
			Utility.queryUnacceptableAd(recordID, this::assertUnacceptableAdd, pojo);
			
		} finally {
			//Delete the record
			Utility.queryUnacceptableAdDelete(recordID);
		}
	}
    	
}

