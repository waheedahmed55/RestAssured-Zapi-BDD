package com.restassured.validate.POST;

import static io.restassured.RestAssured.given;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.restassured.pojo.UnacceptableAddBuilder;
import com.restassured.pojo.UnacceptableAddPojo;
import com.restassured.util.Utility;

public class EntirePostalCdAddressValidationTest extends AppTestBaseRest15{
	
	@Test
    public void validateEentirePostalCodeAddressSameCivic() throws Exception {
    	Gson jsonPayload = new Gson();
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.entirepostalcodeInd(true)
    			.postalcode(postalcd)
    			.note("this is hospistal")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

		
    	
      	final UnacceptableAddPojo pojo2 = new UnacceptableAddBuilder()
      			.addresstypecode(1)
      			.entirepostalcodeInd(false)
      			.postalcode(postalcd)
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
    	 payload2 = jsonObject.toString();
    	 
    	 given().baseUri(BASE_URI2)
     	.contentType("application/json")
     	.body(payload2)
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
    public void validateEentirePostalCodeAddressSameRural() throws Exception {
    	Gson jsonPayload = new Gson();
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.entirepostalcodeInd(true)
    			.postalcode(postalcd)
    			.note("this is hospistal")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

		 
    	
    	 final UnacceptableAddPojo pojo2 = new UnacceptableAddBuilder()
     			.addresstypecode(2)
     			.entirepostalcodeInd(false)
     			.postalcode(postalcd)
     			.provincecode("NB")
     			.municipalityname("HarryTwns")
     			.routename("RR0079")
     			.ruralidentifiercd(1)
     			.Site(42)
     			.Compartment(42)
     			.Concession(42)
     			.Lot(42)
     			.note("this is rural1")
     			.build();
      	
      	String payload2 = jsonPayload.toJson(pojo2);

    	 JsonObject jsonObject = jsonPayload.fromJson(payload2, JsonObject.class);
    	 jsonObject.remove("entireUnitRangeInd");
    	 jsonObject.remove("notes");
    	 jsonObject.remove("entirePostalCodeInd");
    	 payload2 = jsonObject.toString();
    	 
    	 given().baseUri(BASE_URI2)
     	.contentType("application/json")
     	.body(payload2)
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
    public void validateEentirePostalCodeAddressSamePOBox() throws Exception {
    	Gson jsonPayload = new Gson();
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.entirepostalcodeInd(true)
    			.postalcode(postalcd)
    			.note("this is hospistal")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

		
    	 
    	
    	 final UnacceptableAddPojo pojo2 = new UnacceptableAddBuilder()
     			.addresstypecode(3)
     			.entirepostalcodeInd(false)
     			.postalcode(postalcd)
     			.provincecode("NB")
     			.municipalityname("MarksField")
     			.PoBoxNbr(1818)
     			.note("this is pobox1 ")
     			.build();
      	
      	String payload2 = jsonPayload.toJson(pojo2);

    	 JsonObject jsonObject = jsonPayload.fromJson(payload2, JsonObject.class);
    	 jsonObject.remove("entireUnitRangeInd");
    	 jsonObject.remove("notes");
    	 jsonObject.remove("entirePostalCodeInd");
    	 payload2 = jsonObject.toString();
    	 
    	 given().baseUri(BASE_URI2)
     	.contentType("application/json")
     	.body(payload2)
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
    public void validateEentirePostalCodeAddressSameGD() throws Exception {
    	Gson jsonPayload = new Gson();
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.entirepostalcodeInd(true)
    			.postalcode(postalcd)
    			.note("this is hospistal")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

		
    	 
    	
    	 final UnacceptableAddPojo pojo2 = new UnacceptableAddBuilder()
     			.addresstypecode(4)
     			.entirepostalcodeInd(false)
     			.postalcode(postalcd)
     			.provincecode("AB")
     			.municipalityname("Minnesota")
     			.note("this is GD Ad2")
     			.build();
      	
      	String payload2 = jsonPayload.toJson(pojo2);

    	 JsonObject jsonObject = jsonPayload.fromJson(payload2, JsonObject.class);
    	 jsonObject.remove("entireUnitRangeInd");
    	 jsonObject.remove("notes");
    	 jsonObject.remove("entirePostalCodeInd");
    	 payload2 = jsonObject.toString();
    	 
    	 given().baseUri(BASE_URI2)
     	.contentType("application/json")
     	.body(payload2)
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

}
