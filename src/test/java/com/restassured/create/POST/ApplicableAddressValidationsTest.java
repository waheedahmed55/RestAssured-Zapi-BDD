package com.restassured.create.POST;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.restassured.pojo.UnacceptableAddBuilder;
import com.restassured.pojo.UnacceptableAddPojo;
import com.restassured.util.Utility;

public class ApplicableAddressValidationsTest extends AppTestBaseRest17{
	public void setJiraTestCaseParamters() {
		this.issueID = null; // This should be mapped to existing JIRA issue
		this.desc = "Applicable Fields test";
	}
	@Test
    public void createCivicAddressApplicableFieldsSingle() throws Exception {
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
    			.EntireUnitRangeInd(false)
    			.UnitNbr("10")
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
    public void createCivicAddressApplicableFieldsRange() throws Exception {
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
    public void createCivicAddressApplicableFieldsAll() throws Exception {
    	Gson jsonPayload = new Gson();
    	String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(1)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("NL")
    			.municipalityname("Hollywood")
    			.streetnbr(888)
    			.streetname("McCarthur")
    			.StreetNbrSuffix("4")
    			.StreetTypeCd(11)
    			.StreetDirectionCd(5)
    			.EntireUnitRangeInd(true)
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
	public void createRuralAddressApplicableFields() throws Exception {
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
	public void createPOBoxAddressApplicableFields() throws Exception {
		
		
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
	public void createGDAddressApplicableFields() throws Exception {
	
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
