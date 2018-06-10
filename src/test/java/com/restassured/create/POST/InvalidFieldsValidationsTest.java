package com.restassured.create.POST;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.restassured.pojo.UnacceptableAddBuilder;
import com.restassured.pojo.UnacceptableAddPojo;
import com.restassured.util.Utility;

public class InvalidFieldsValidationsTest extends AppTestBaseRest17{
	
	public void setJiraTestCaseParamters() {
		this.issueID = null; // This should be mapped to existing JIRA issue
		this.desc = "Invalid Fields test";
	}
	@Test
	 public void createCivicAddressInvalidFieldsAll() throws Exception {
    	
        String postalcd = Utility.generateUnacceptableAddPostalCd();

		Gson jsonPayload = new Gson();
 

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
    			.ruralidentifiercd(2)
    			.routename("SS0022")
    			.Site(44)
    			.Compartment(44)
    			.Concession(44)
    			.Lot(44)
    			.InstallationName("STNCV")
    			.PoBoxNbr(976)
    			.EntireUnitRangeInd(true)
    			.note("this is Civic All")
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
	 public void createCivicAddressInvalidFieldsSingle() throws Exception {
  
        String postalcd = Utility.generateUnacceptableAddPostalCd();

		Gson jsonPayload = new Gson();


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
   			.ruralidentifiercd(2)
   			.routename("SS0022")
   			.Site(44)
   			.Compartment(44)
   			.Concession(44)
   			.Lot(44)
   			.InstallationName("STNCV")
   			.PoBoxNbr(976)
   			.EntireUnitRangeInd(false)
   			.UnitNbr("20")
   			.note("this is Civic Single")
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
	 public void createCivicAddressInvalidFieldsRange() throws Exception {
  	
        String postalcd = Utility.generateUnacceptableAddPostalCd();

		Gson jsonPayload = new Gson();


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
  			.ruralidentifiercd(2)
  			.routename("SS0022")
  			.Site(44)
  			.Compartment(44)
  			.Concession(44)
  			.Lot(44)
  			.InstallationName("STNCV")
  			.PoBoxNbr(976)
  			.EntireUnitRangeInd(false)
  			.UnitNbr("20")
  			.ToUnitNbr("30")
  			.note("this is Civic Single")
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
	 public void createRuralAddressInvalidFields() throws Exception {
 
        String postalcd = Utility.generateUnacceptableAddPostalCd();

		Gson jsonPayload = new Gson();


 	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
 			.addresstypecode(2)
 			.entirepostalcodeInd(false)
 			.postalcode(postalcd)
 			.provincecode("NL")
 			.municipalityname("Hollywood")
 			.streetnbr(888)
 			.streetname("McCarthur")
 			.StreetNbrSuffix("4")
 			.StreetTypeCd(11)
 			.StreetDirectionCd(5)
 			.ruralidentifiercd(2)
 			.routename("SS0022")
 			.Site(44)
 			.Compartment(44)
 			.Concession(44)
 			.Lot(44)
 			.InstallationName("STNCV")
 			.PoBoxNbr(976)
 			.EntireUnitRangeInd(false)
 			.UnitNbr("20")
 			.ToUnitNbr("30")
 			.note("this is Civic Single")
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
	 public void createPOBoxAddressInvalidFields() throws Exception {
	
        String postalcd = Utility.generateUnacceptableAddPostalCd();

		Gson jsonPayload = new Gson();


	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
			.addresstypecode(3)
			.entirepostalcodeInd(false)
			.postalcode(postalcd)
			.provincecode("NL")
			.municipalityname("Hollywood")
			.streetnbr(888)
			.streetname("McCarthur")
			.StreetNbrSuffix("4")
			.StreetTypeCd(11)
			.StreetDirectionCd(5)
			.ruralidentifiercd(2)
			.routename("SS0022")
			.Site(44)
			.Compartment(44)
			.Concession(44)
			.Lot(44)
			.InstallationName("STNCV")
			.PoBoxNbr(976)
			.EntireUnitRangeInd(false)
			.UnitNbr("20")
			.ToUnitNbr("30")
			.note("this is Civic Single")
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
	 public void createGDAddressInvalidFields() throws Exception {
	
        String postalcd = Utility.generateUnacceptableAddPostalCd();

		Gson jsonPayload = new Gson();


	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
			.addresstypecode(4)
			.entirepostalcodeInd(false)
			.postalcode(postalcd)
			.provincecode("NL")
			.municipalityname("Hollywood")
			.streetnbr(888)
			.streetname("McCarthur")
			.StreetNbrSuffix("4")
			.StreetTypeCd(11)
			.StreetDirectionCd(5)
			.ruralidentifiercd(2)
			.routename("SS0022")
			.Site(44)
			.Compartment(44)
			.Concession(44)
			.Lot(44)
			.InstallationName("STNCV")
			.PoBoxNbr(976)
			.EntireUnitRangeInd(false)
			.UnitNbr("20")
			.ToUnitNbr("30")
			.note("this is Civic Single")
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
	 public void createEntirePostalCodeAddressInvalidFields() throws Exception {
	
        String postalcd = Utility.generateUnacceptableAddPostalCd();

		Gson jsonPayload = new Gson();


	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
			.addresstypecode(4)
			.entirepostalcodeInd(true)
			.postalcode(postalcd)
			.provincecode("NL")
			.municipalityname("Hollywood")
			.streetnbr(888)
			.streetname("McCarthur")
			.StreetNbrSuffix("4")
			.StreetTypeCd(11)
			.StreetDirectionCd(5)
			.ruralidentifiercd(2)
			.routename("SS0022")
			.Site(44)
			.Compartment(44)
			.Concession(44)
			.Lot(44)
			.InstallationName("STNCV")
			.PoBoxNbr(976)
			.EntireUnitRangeInd(false)
			.UnitNbr("20")
			.ToUnitNbr("30")
			.note("this is Civic Single")
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
