package com.restassured.update.PUT;

import static io.restassured.RestAssured.given;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.restassured.pojo.UnacceptableAddBuilder;
import com.restassured.pojo.UnacceptableAddPojo;
import com.restassured.util.Utility;

public class MandatoryFieldsValidationsTest extends AppTestBaseRest18{
	
	@Test
    public void updateCivicAddressMandatoryFieldsPostalCodeMissing() throws Exception {
    	Gson jsonPayload = new Gson();
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(1)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("AB")
    			.municipalityname("Foxwood")
    			.streetnbr(963)
    			.streetname("Sparks")
    			.StreetNbrSuffix("4")
    			.StreetTypeCd(11)
    			.StreetDirectionCd(5)
    			.EntireUnitRangeInd(true)
    			.note("this is hospistal")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

		
    
    	 
   

    	pojo.setPostalCode(null);
    	String  payload = jsonPayload.toJson(pojo);
    	 
    	 String ResponseBody = given().baseUri(BASE_URI+"/"+recordID)
    	.contentType("application/json")
    	.body(payload)
       	.auth().basic("userName", "pwd")
       	.when()
       	.put()
       	.then()
       	.assertThat().statusCode(400).and()
        .extract().body().asString();
         Assert.assertTrue(ResponseBody.contains("schemaValidation"));
         Assert.assertTrue(ResponseBody.contains("Schema validation failed: $.postalCode: is missing but it is required"));
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
    public void updateCivicAddressMandatoryFieldsMissing() throws Exception {
    	Gson jsonPayload = new Gson();
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(1)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("AB")
    			.municipalityname("Foxwood")
    			.streetnbr(963)
    			.streetname("Sparks")
    			.StreetNbrSuffix("4")
    			.StreetTypeCd(11)
    			.StreetDirectionCd(5)
    			.EntireUnitRangeInd(true)
    			.note("this is hospistal")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

    	 
   

       	pojo.setStreetNbr(null);
    	pojo.setStreetName(null);
    	pojo.setMunicipality(null);
    	pojo.setProvinceCode(null);
    	 
    	String payload = jsonPayload.toJson(pojo);
    	 
    	 given().baseUri(BASE_URI+"/"+recordID)
     	.contentType("application/json")
     	.body(payload)
     	.auth().basic("userName", "pwd")
     	.when()
     	.put()
     	.then()
     	.assertThat().statusCode(400).and()
    	.body("code", Matchers.hasItem(Matchers.equalTo("303")) ).and()
    	.body("desc", Matchers.hasItem(Matchers.equalTo("Street number required")))
    	.body("code", Matchers.hasItem(Matchers.equalTo("304")) ).and()
     	.body("desc", Matchers.hasItem(Matchers.equalTo("Street name required")))
     	.body("code", Matchers.hasItem(Matchers.equalTo("307")) ).and()
     	.body("desc", Matchers.hasItem(Matchers.equalTo("Municipality required")))
     	.body("code", Matchers.hasItem(Matchers.equalTo("308")) ).and()
     	.body("desc", Matchers.hasItem(Matchers.equalTo("Province required")));
    	 
    	 pojo.setStreetNbr(963);
    	 pojo.setStreetName("Sparks");
    	 pojo.setMunicipality("Foxwood");
    	 pojo.setProvinceCode("AB");
    	 
    	try {
    		//Validate the record with assertions against DB
			Utility.queryUnacceptableAd(recordID, this::assertUnacceptableAdd, pojo);
			
		} finally {
			//Delete the record
			Utility.queryUnacceptableAdDelete(recordID);
		}

    	
    }
	@Test
	public void updateRuralAddressMandatoryFieldsPostalCodeMissing() throws Exception {
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
    			.InstallationName("STNBRB")
    			.note("this is rural")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

    
    	 
    	 
    	 pojo.setPostalCode(null);
    	String payload = jsonPayload.toJson(pojo);
    	 
    	 String ResponseBody = given().baseUri(BASE_URI+"/"+recordID)
    	.contentType("application/json")
    	.body(payload)
       	.auth().basic("userName", "pwd")
       	.when()
       	.put()
       	.then()
       	.assertThat().statusCode(400).and()
        .extract().body().asString();
         Assert.assertTrue(ResponseBody.contains("schemaValidation"));
         Assert.assertTrue(ResponseBody.contains("Schema validation failed: $.postalCode: is missing but it is required"));
    	 
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
	public void updateRuralAddressMandatoryFieldsMissing() throws Exception {
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
    			.InstallationName("STNBRB")
    			.note("this is rural")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

		
   
    	
    	 pojo.setRuralIdentifierCd(null);
    	 pojo.setRouteName(null);
    	 pojo.setMunicipality(null);
    	 pojo.setProvinceCode(null);
    	 String payload = jsonPayload.toJson(pojo);
    	 
    	 given().baseUri(BASE_URI+"/"+recordID)
     	.contentType("application/json")
     	.body(payload)
     	.auth().basic("userName", "pwd")
     	.when()
     	.put()
     	.then()
     	.assertThat().statusCode(400).and()
    	.body("code", Matchers.hasItem(Matchers.equalTo("305")) ).and()
    	.body("desc", Matchers.hasItem(Matchers.equalTo("Route name required")))
    	.body("code", Matchers.hasItem(Matchers.equalTo("306")) ).and()
     	.body("desc", Matchers.hasItem(Matchers.equalTo("Rural identifier required")))
     	.body("code", Matchers.hasItem(Matchers.equalTo("307")) ).and()
     	.body("desc", Matchers.hasItem(Matchers.equalTo("Municipality required")))
     	.body("code", Matchers.hasItem(Matchers.equalTo("308")) ).and()
     	.body("desc", Matchers.hasItem(Matchers.equalTo("Province required")));
    	 
    	 pojo.setRouteName("RR0004");
    	 pojo.setRuralIdentifierCd(1);
    	 pojo.setMunicipality("Foxworth");
    	 pojo.setProvinceCode("QC");

   
    	try {
    		//Validate the record with assertions against DB
			Utility.queryUnacceptableAd(recordID, this::assertUnacceptableAdd, pojo);
			
			
		
		} finally {
			//Delete the record
			Utility.queryUnacceptableAdDelete(recordID);
		}

    	
    }
	@Test
	public void updateGDAddressMandatoryFieldsPostalCodeMissing() throws Exception {
		
    	Gson jsonPayload = new Gson();
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(4)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("BC")
    			.municipalityname("HillTop")
    			.InstallationName("STNGD")
    			.note("this is GD Ad")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

		
    	 
    
    	 pojo.setPostalCode(null);
    	String payload = jsonPayload.toJson(pojo);
         String ResponseBody = given().baseUri(BASE_URI+"/"+recordID)
       	.contentType("application/json")
       	.body(payload)
       	.auth().basic("userName", "pwd")
       	.when()
       	.put()
       	.then()
       	.assertThat().statusCode(400).and()
        .extract().body().asString();
         Assert.assertTrue(ResponseBody.contains("schemaValidation"));
         Assert.assertTrue(ResponseBody.contains("Schema validation failed: $.postalCode: is missing but it is required"));
 
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
	public void updateGDAddressMandatoryFieldsMissing() throws Exception {
		
    	Gson jsonPayload = new Gson();
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(4)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("BC")
    			.municipalityname("HillTop")
    			.InstallationName("STNGD")
    			.note("this is GD Ad")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

		
    	 
    	
    	 pojo.setInstallationName(null);
    	 pojo.setMunicipality(null);
    	 pojo.setProvinceCode(null);
    	 
    	 String payload = jsonPayload.toJson(pojo);
    	 given().baseUri(BASE_URI+"/"+recordID)
       	.contentType("application/json")
       	.body(payload)
       	.auth().basic("userName", "pwd")
       	.when()
       	.put()
       	.then()
       	.assertThat().statusCode(400).and()
    	.body("code", Matchers.hasItem(Matchers.equalTo("310")) ).and()
    	.body("desc", Matchers.hasItem(Matchers.equalTo("Delivery installation name required")))
     	.body("code", Matchers.hasItem(Matchers.equalTo("307")) ).and()
     	.body("desc", Matchers.hasItem(Matchers.equalTo("Municipality required")))
     	.body("code", Matchers.hasItem(Matchers.equalTo("308")) ).and()
     	.body("desc", Matchers.hasItem(Matchers.equalTo("Province required")));
    	 
    	 pojo.setInstallationName("STNGD");
    	 pojo.setMunicipality("HillTop");
    	 pojo.setProvinceCode("BC");
   
    	try {
    		//Validate the record with assertions against DB
			Utility.queryUnacceptableAd(recordID, this::assertUnacceptableAdd, pojo);
			
			
		
		} finally {
			//Delete the record
			Utility.queryUnacceptableAdDelete(recordID);
		}   
    	
    }
	@Test
	public void updatePOBoxAddressMandatoryFieldsPostalCodeMissing() throws Exception {
		
		
    	Gson jsonPayload = new Gson();
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(3)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("NL")
    			.municipalityname("LoydFord")
    			.PoBoxNbr(909)
    			.InstallationName("STNPOB")
    			.note("this is pobox")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

		
    	 
    	 
    	 pojo.setPostalCode(null);
    	 
    	 String payload = jsonPayload.toJson(pojo);
    	 String ResponseBody = given().baseUri(BASE_URI+"/"+recordID)
    		    	.contentType("application/json")
    		    	.body(payload)
    		       	.auth().basic("userName", "pwd")
    		       	.when()
    		       	.put()
    		       	.then()
    		       	.assertThat().statusCode(400).and()
    		        .extract().body().asString();
    		         Assert.assertTrue(ResponseBody.contains("schemaValidation"));
    		         Assert.assertTrue(ResponseBody.contains("Schema validation failed: $.postalCode: is missing but it is required"));
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
	public void updatePOBoxAddressMandatoryFieldsMissing() throws Exception {
	
    	Gson jsonPayload = new Gson();
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(3)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("NL")
    			.municipalityname("LoydFord")
    			.PoBoxNbr(909)
    			.InstallationName("STNPOB")
    			.note("this is pobox")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);
    
    	 
    	
    	 pojo.setPoBoxNbr(null);
    	 pojo.setMunicipality(null);
    	 pojo.setProvinceCode(null);
    	 
    	 String payload = jsonPayload.toJson(pojo);
    	 given().baseUri(BASE_URI+"/"+recordID)
       	.contentType("application/json")
       	.body(payload)
       	.auth().basic("userName", "pwd")
       	.when()
       	.put()
       	.then()
       	.assertThat().statusCode(400).and()
    	.body("code", Matchers.hasItem(Matchers.equalTo("309")) ).and()
    	.body("desc", Matchers.hasItem(Matchers.equalTo("PO box required")))
     	.body("code", Matchers.hasItem(Matchers.equalTo("307")) ).and()
     	.body("desc", Matchers.hasItem(Matchers.equalTo("Municipality required")))
     	.body("code", Matchers.hasItem(Matchers.equalTo("308")) ).and()
     	.body("desc", Matchers.hasItem(Matchers.equalTo("Province required")));
    	 
    	 pojo.setPoBoxNbr(909);
    	 pojo.setMunicipality("LoydFord");
    	 pojo.setProvinceCode("NL");
    	 
    	try {
    		//Validate the record with assertions against DB
			Utility.queryUnacceptableAd(recordID, this::assertUnacceptableAdd, pojo);
			
			
	
		} finally {
			//Delete the record
			Utility.queryUnacceptableAdDelete(recordID);
		}   
    	
    }

}
