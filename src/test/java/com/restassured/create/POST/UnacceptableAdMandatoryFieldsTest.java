package com.restassured.create.POST;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.restassured.pojo.UnacceptableAddBuilder;
import com.restassured.pojo.UnacceptableAddPojo;
import com.restassured.util.Utility;

/**
 * Unit test for simple App.
 */
public class UnacceptableAdMandatoryFieldsTest extends AppTestBaseRest17
   
{
	public void setJiraTestCaseParamters() {
		this.issueID = null; // This should be mapped to existing JIRA issue
		this.desc = "Mandatory Fields test";
	}
	
	@Test
    public void createCivicAddressMandatoryFields() throws Exception {
    	Gson jsonPayload = new Gson();
        String postalcd = Utility.generateUnacceptableAddPostalCd();

		
    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(1)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("BC")
    			.municipalityname("HillTop")
    			.streetnbr(163)
    			.streetname("Elm")
    			.note("this is hospistal")
    			.EntireUnitRangeInd(true)
    			.build();
    	
    	String payload = jsonPayload.toJson(pojo);

		result = given().baseUri(BASE_URI)
    	.contentType("application/json")
    	.body(payload)
    	.auth().basic("userName", "pwd")
    	.when()
    	.post()
    	.then()
    	.assertThat().body("$", hasKey("id")).and().statusCode(200)
    	.extract()
        .path("id");
    
    	 
   
    	try {
    		//Validate the record with assertions against DB
			Utility.queryUnacceptableAd(result, this::assertUnacceptableAdd, pojo);
			
		} finally {
			//Delete the record
			Utility.queryUnacceptableAdDelete(result);
		}

    	
    }
	@Test
	public void createRuralAddressMandatoryFields() throws Exception {
    	Gson jsonPayload = new Gson();
        String postalcd = Utility.generateUnacceptableAddPostalCd();

		
    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(2)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("QC")
    			.municipalityname("London")
    			.routename("SS0073")
    			.ruralidentifiercd(2)
    			.note("this is hospistal rural")
    			.build();
    	
    	String payload = jsonPayload.toJson(pojo);

		result = given().baseUri(BASE_URI)
    	.contentType("application/json")
    	.body(payload)
    	.auth().basic("userName", "pwd")
    	.when()
    	.post()
    	.then()
    	.assertThat().statusCode(200).and().body("$", hasKey("id"))
    	.extract()
        .path("id");
    
    	 
   
    	try {
    		//Validate the record with assertions against DB
			Utility.queryUnacceptableAd(result, this::assertUnacceptableAdd, pojo);
			
			
		
		} finally {
			//Delete the record
			Utility.queryUnacceptableAdDelete(result);
		}

    	
    }
	@Test
    public void createPOBoxAddressMandatoryFields() throws Exception {
    	Gson jsonPayload = new Gson();
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(3)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("BC")
    			.municipalityname("HillTop")
    			.PoBoxNbr(880)
    			.note("this is hospistal")
    			.build();
    	
    	String payload = jsonPayload.toJson(pojo);

		result = given().baseUri(BASE_URI)
    	.contentType("application/json")
    	.body(payload)
    	.auth().basic("userName", "pwd")
    	.when()
    	.post()
    	.then()
    	.assertThat().statusCode(200).and().body("$", hasKey("id"))
    	.extract()
        .path("id");
    
    	 
   
    	try {
    		//Validate the record with assertions against DB
			Utility.queryUnacceptableAd(result, this::assertUnacceptableAdd, pojo);
			
			
	
		} finally {
			//Delete the record
			Utility.queryUnacceptableAdDelete(result);
		}   
    	
    }
	@Test
    public void createGDAddressMandatoryFields() throws Exception {
    	Gson jsonPayload = new Gson();
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(4)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("BC")
    			.municipalityname("HillTop")
    			.InstallationName("STNGD")
    			.note("this is GD")
    			.build();
    	
    	String payload = jsonPayload.toJson(pojo);

		result = given().baseUri(BASE_URI)
    	.contentType("application/json")
    	.body(payload)
    	.auth().basic("userName", "pwd")
    	.when()
    	.post()
    	.then()
    	.assertThat().statusCode(200).and().body("$", hasKey("id"))
    	.extract()
        .path("id");
    
    	 
   
    	try {
    		//Validate the record with assertions against DB
			Utility.queryUnacceptableAd(result, this::assertUnacceptableAdd, pojo);
			
			
		
		} finally {
			//Delete the record
			Utility.queryUnacceptableAdDelete(result);
		}   
    	
    }
	@Test
    public void createentirePostalCodeAddressMandatoryFields() throws Exception {
    	Gson jsonPayload = new Gson();
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.entirepostalcodeInd(true)
    			.postalcode(postalcd)
    			.note("this is hospistal")
    			.build();
    	
    	String payload = jsonPayload.toJson(pojo);

		result = given().baseUri(BASE_URI)
    	.contentType("application/json")
    	.body(payload)
    	.auth().basic("userName", "pwd")
    	.when()
    	.post()
    	.then()
    	.assertThat().statusCode(200).and().body("$", hasKey("id"))
    	.extract()
        .path("id");
    
    	 
   
    	try {
    		//Validate the record with assertions against DB
			Utility.queryUnacceptableAd(result, this::assertUnacceptableAdd, pojo);
			
			
		
		} finally {
			//Delete the record
			Utility.queryUnacceptableAdDelete(result);
		}       
    	}
	@Test
    public void createCivicAddressMandatoryFieldsSingle() throws Exception {
Gson jsonPayload = new Gson();
String postalcd = Utility.generateUnacceptableAddPostalCd();

		
    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(1)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("BC")
    			.municipalityname("HillTop")
    			.streetnbr(163)
    			.streetname("Elm")
    			.EntireUnitRangeInd(false)
    			.UnitNbr("15")
    			.note("this is hospistal")
    			.build();
    	
    	String payload = jsonPayload.toJson(pojo);

		result = given().baseUri(BASE_URI)
    	.contentType("application/json")
    	.body(payload)
    	.auth().basic("userName", "pwd")
    	.when()
    	.post()
    	.then()
    	.assertThat().statusCode(200).and().body("$", hasKey("id"))
    	.extract()
        .path("id");
    
    	 
   
    	try {
    		//Validate the record with assertions against DB
			Utility.queryUnacceptableAd(result, this::assertUnacceptableAdd, pojo);
			
		
		} finally {
			//Delete the record
			Utility.queryUnacceptableAdDelete(result);
		}   
    	}
	@Test
    public void createCivicAddressMandatoryFieldsRange() throws Exception {
Gson jsonPayload = new Gson();
 
String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(1)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("NB")
    			.municipalityname("TopHorn")
    			.streetnbr(909)
    			.streetname("Bordan")
    			.EntireUnitRangeInd(false)
    			.UnitNbr("88")
    			.ToUnitNbr("188")
    			.note("this is civic mandatory")
    			.build();
    	
    	String payload = jsonPayload.toJson(pojo);

		result = given().baseUri(BASE_URI)
    	.contentType("application/json")
    	.body(payload)
    	.auth().basic("userName", "pwd")
    	.when()
    	.post()
    	.then()
    	.assertThat().statusCode(200).and().body("$", hasKey("id"))
    	.extract()
        .path("id");
    
    	 
   
    	try {
    		//Validate the record with assertions against DB
			Utility.queryUnacceptableAd(result, this::assertUnacceptableAdd, pojo);
			
			
	
		} finally {
			//Delete the record
			Utility.queryUnacceptableAdDelete(result);
		} 
    }
	@Test
    public void createCivicAddressMandatoryFieldsAll() throws Exception {
Gson jsonPayload = new Gson();
 
String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(1)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("BC")
    			.municipalityname("HillTop")
    			.streetnbr(163)
    			.streetname("Elm")
    			.EntireUnitRangeInd(true)
    			.UnitNbr("15")
    			.note("this is hospistal")
    			.build();
    	
    	String payload = jsonPayload.toJson(pojo);

		result = given().baseUri(BASE_URI)
    	.contentType("application/json")
    	.body(payload)
    	.auth().basic("userName", "pwd")
    	.when()
    	.post()
    	.then()
    	.assertThat().statusCode(200).and().body("$", hasKey("id"))
    	.extract()
        .path("id");
    
    	 
   
    	try {
    		//Validate the record with assertions against DB
			Utility.queryUnacceptableAd(result, this::assertUnacceptableAdd, pojo);
			
	
		} finally {
			//Delete the record
			Utility.queryUnacceptableAdDelete(result);
		}     
    	}
    
    
    
}
