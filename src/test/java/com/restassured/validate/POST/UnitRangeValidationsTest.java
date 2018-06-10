package com.restassured.validate.POST;

import static io.restassured.RestAssured.given;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.restassured.pojo.UnacceptableAddBuilder;
import com.restassured.pojo.UnacceptableAddPojo;
import com.restassured.util.Utility;

public class UnitRangeValidationsTest extends AppTestBaseRest15 {

	@Test
    public void validateCivicAddressUnitNbrWithinRange() throws Exception {
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

    	 
    	 
    	 pojo.setUnitNbr("15");
    	 String payload = jsonPayload.toJson(pojo);
    	 JsonObject jsonObject = jsonPayload.fromJson(payload, JsonObject.class);
    	 jsonObject.remove("entireUnitRangeInd");
    	 jsonObject.remove("notes");
    	 jsonObject.remove("entirePostalCodeInd");
    	 jsonObject.remove("toUnitNbr");

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
    public void validateCivicAddressUnitNbrBeforeRange() throws Exception {
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

    
    	 
    	 
    	 pojo.setUnitNbr("5");
    	 String payload = jsonPayload.toJson(pojo);
    	 JsonObject jsonObject = jsonPayload.fromJson(payload, JsonObject.class);
    	 jsonObject.remove("entireUnitRangeInd");
    	 jsonObject.remove("notes");
    	 jsonObject.remove("entirePostalCodeInd");
    	 jsonObject.remove("toUnitNbr");

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
    public void validateCivicAddressUnitNbrAfterRange() throws Exception {
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

    	 
    	 
    	 pojo.setUnitNbr("30");
    	 String payload = jsonPayload.toJson(pojo);
    	 JsonObject jsonObject = jsonPayload.fromJson(payload, JsonObject.class);
    	 jsonObject.remove("entireUnitRangeInd");
    	 jsonObject.remove("notes");
    	 jsonObject.remove("entirePostalCodeInd");
    	 jsonObject.remove("toUnitNbr");

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
    public void validateCivicAddressEntrieunitrangeindSame() throws Exception {
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
    			.EntireUnitRangeInd(true)
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
    public void validateCivicAddressEntrieunitrangeindSetUnitNbr() throws Exception {
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
    			.EntireUnitRangeInd(true)
    			.note("this is civic address")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

    	 
    	 
    	 pojo.setUnitNbr("31");
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
    	 
    //	 pojo.setUnitNbr(null);

    	try {
    		//Validate the record with assertions against DB
			Utility.queryUnacceptableAd(recordID, this::assertUnacceptableAdd, pojo);
			
		} finally {
			//Delete the record
			Utility.queryUnacceptableAdDelete(recordID);
		}

    	
    }
	@Test
    public void validateCivicAddressEntrieunitrangeindDifferentPostalCd() throws Exception {
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
    			.EntireUnitRangeInd(true)
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
    public void validateCivicAddressEntrieunitrangeindDifferentStreetNbr() throws Exception {
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
    			.EntireUnitRangeInd(true)
    			.note("this is civic address")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

    
    	 
    	 
    	 pojo.setStreetNbr(666);
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
    	 
    	 pojo.setStreetNbr(999);
    	try {
    		//Validate the record with assertions against DB
			Utility.queryUnacceptableAd(recordID, this::assertUnacceptableAdd, pojo);
			
		} finally {
			//Delete the record
			Utility.queryUnacceptableAdDelete(recordID);
		}

    	
    }
	@Test
    public void validateCivicAddressEntrieunitrangeindDifferentStreetName() throws Exception {
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
    			.EntireUnitRangeInd(true)
    			.note("this is civic address")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

    
    	 
    	 
    	 pojo.setStreetName("Hamilton");
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
    	 pojo.setStreetName("McDonald");
   
    	try {
    		//Validate the record with assertions against DB
			Utility.queryUnacceptableAd(recordID, this::assertUnacceptableAdd, pojo);
			
		} finally {
			//Delete the record
			Utility.queryUnacceptableAdDelete(recordID);
		}

    	
    }
}
