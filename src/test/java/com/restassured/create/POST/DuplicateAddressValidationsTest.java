package com.restassured.create.POST;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.restassured.pojo.UnacceptableAddBuilder;
import com.restassured.pojo.UnacceptableAddPojo;
import com.restassured.util.Utility;

public class DuplicateAddressValidationsTest extends AppTestBaseRest17 {

	private final String civicPostalcd = Utility.generateUnacceptableAddPostalCd();
	private final String ruralPostalcd = Utility.generateUnacceptableAddPostalCd();
	private final String poboxPostalcd = Utility.generateUnacceptableAddPostalCd();
	private final String gdPostalcd = Utility.generateUnacceptableAddPostalCd();

	public void setJiraTestCaseParamters() {
		this.issueID = null; // This should be mapped to existing JIRA issue
		this.desc = "Duplicate Address Fields test";
	}
	@Test
	public void  validcheckduplicateCivic() throws Exception {
		
		
		Gson jsonPayload = new Gson();
    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(1)
    			.entirepostalcodeInd(false)
    			.postalcode(civicPostalcd)
    			.provincecode("ON")
    			.municipalityname("Boredome")
    			.streetnbr(676)
    			.streetname("Dunrobin")
    			.EntireUnitRangeInd(true)
    			.UnitNbr("45")
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
    
    	 
    	 adIDsTodelete.add(result);
    	
    		//Validate the record with assertions against DB
			Utility.queryUnacceptableAd(result, this::assertUnacceptableAdd, pojo);
			
			
		
    	 pojo.setEntirePostalCodeInd(true);
    	 payload = jsonPayload.toJson(pojo);
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
    		    
    		    	 
    		    	 adIDsTodelete.add(result);
    		    		
    		        		//Validate the record with assertions against DB
    		    			Utility.queryUnacceptableAd(result, this::assertUnacceptableAdd, pojo);
    		    			
    		    			
    		    			 
	}
	@Test(dependsOnMethods= "validcheckduplicateCivic")
	public void invalidcheckduplicateCivic() {
Gson jsonPayload = new Gson();
 
		
    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(1)
    			.entirepostalcodeInd(false)
    			.postalcode(civicPostalcd)
    			.provincecode("BC")
    			.municipalityname("Boredome")
    			.streetnbr(676)
    			.streetname("Dunrobin")
    			.EntireUnitRangeInd(true)
    			.UnitNbr("45")
    			.note("this is hospistal")
    			.build();
    	System.out.println(civicPostalcd);
    	String payload = jsonPayload.toJson(pojo);

		 given().baseUri(BASE_URI)
    	.contentType("application/json")
    	.body(payload)
    	.auth().basic("userName", "pwd")
    	.when()
    	.post()
    	.then()
    	.assertThat().statusCode(400).and()
    	.body("code", Matchers.hasItem(Matchers.equalTo("302")) ).and()
    	.body("desc", Matchers.hasItem(Matchers.equalTo("Duplicate address")));
	    System.out.println(civicPostalcd);


   
    	
    		//Validate record count it shouldnt be more than 2 rows for each postal code
    		Utility.queryUnacceptableAdCount(pojo.getPostalCode().toUpperCase().replace('-', ' '), 2);
			
			
		
		
	}
	
	@Test
	public void  validcheckduplicateRural() throws Exception {
		
		
		Gson jsonPayload = new Gson();
		final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(2)
    			.entirepostalcodeInd(false)
    			.postalcode(ruralPostalcd)
    			.provincecode("NB")
    			.municipalityname("Rambo")
    			.routename("RR0016")
    			.ruralidentifiercd(1)
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
    
    	 
    	 adIDsTodelete.add(result);
    	
    		//Validate the record with assertions against DB
			Utility.queryUnacceptableAd(result, this::assertUnacceptableAdd, pojo);
			
			
		
    	 pojo.setEntirePostalCodeInd(true);
    	 payload = jsonPayload.toJson(pojo);
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
    		    
    		    	 
    		    	 adIDsTodelete.add(result);
    		    		
    		        		//Validate the record with assertions against DB
    		    			Utility.queryUnacceptableAd(result, this::assertUnacceptableAdd, pojo);
    		    			
    		    			
    		    			 
	}
	@Test(dependsOnMethods= "validcheckduplicateRural")
	public void invalidcheckduplicateRural() {
			Gson jsonPayload = new Gson();
 
		
			final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
			.addresstypecode(2)
			.entirepostalcodeInd(false)
			.postalcode(ruralPostalcd)
			.provincecode("NB")
			.municipalityname("Rambo")
			.routename("RR0016")
			.ruralidentifiercd(1)
			.note("this is hospistal rural")
			.build();
    	
    	String payload = jsonPayload.toJson(pojo);

		 given().baseUri(BASE_URI)
    	.contentType("application/json")
    	.body(payload)
    	.auth().basic("userName", "pwd")
    	.when()
    	.post()
    	.then()
    	.assertThat().statusCode(400).and()
    	.body("code", Matchers.hasItem(Matchers.equalTo("302")) ).and()
    	.body("desc", Matchers.hasItem(Matchers.equalTo("Duplicate address")));


   
    
    		//Validate record count it shouldnt be more than 2 rows for each postal code
    		Utility.queryUnacceptableAdCount(pojo.getPostalCode().toUpperCase().replace('-', ' '), 2);
			
			
		
		
	}
	@Test
	public void  validcheckduplicatePOBox() throws Exception {
		
		
		Gson jsonPayload = new Gson();
		final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(3)
    			.entirepostalcodeInd(false)
    			.postalcode(poboxPostalcd)
    			.provincecode("NL")
    			.municipalityname("Fordsmith")
    			.PoBoxNbr(965)
    			.note("this is hospistal POBox")
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
    
    	 
    	 adIDsTodelete.add(result);
    	
    		//Validate the record with assertions against DB
			Utility.queryUnacceptableAd(result, this::assertUnacceptableAdd, pojo);
			
			
		
    	 pojo.setEntirePostalCodeInd(true);
    	 payload = jsonPayload.toJson(pojo);
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
    		    
    		    	 
    		    	 adIDsTodelete.add(result);
    		    		
    		        		//Validate the record with assertions against DB
    		    			Utility.queryUnacceptableAd(result, this::assertUnacceptableAdd, pojo);
    		    			
    		    			
    		    			 
	}
	@Test(dependsOnMethods= "validcheckduplicatePOBox")
	public void invalidcheckduplicatePOBox() {
			Gson jsonPayload = new Gson();
 
		
			final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
					.addresstypecode(3)
	    			.entirepostalcodeInd(false)
	    			.postalcode(poboxPostalcd)
	    			.provincecode("NL")
	    			.municipalityname("Fordsmith")
	    			.PoBoxNbr(965)
	    			.note("this is hospistal POBox")
	    			.build();
	    			
    	
    	String payload = jsonPayload.toJson(pojo);

		 given().baseUri(BASE_URI)
    	.contentType("application/json")
    	.body(payload)
    	.auth().basic("userName", "pwd")
    	.when()
    	.post()
    	.then()
    	.assertThat().statusCode(400).and()
    	.body("code", Matchers.hasItem(Matchers.equalTo("302")) ).and()
    	.body("desc", Matchers.hasItem(Matchers.equalTo("Duplicate address")));


   
    	
    		//Validate record count it shouldnt be more than 2 rows for each postal code
    		Utility.queryUnacceptableAdCount(pojo.getPostalCode().toUpperCase().replace('-', ' '), 2);
			
			
		
		
	}
	@Test
	public void  validcheckduplicateGD() throws Exception {
		
		
		Gson jsonPayload = new Gson();
		final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(4)
    			.entirepostalcodeInd(false)
    			.postalcode(gdPostalcd)
    			.provincecode("BC")
    			.municipalityname("Illnois")
    			.InstallationName("STN GD")
    			.note("this is hospistal GD")
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
    
    	 
    	 adIDsTodelete.add(result);
    	
    		//Validate the record with assertions against DB
			Utility.queryUnacceptableAd(result, this::assertUnacceptableAdd, pojo);
			
			
		
    	 pojo.setEntirePostalCodeInd(true);
    	 payload = jsonPayload.toJson(pojo);
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
    		    
    		    	 
    		    	 adIDsTodelete.add(result);
    		    		
    		        		//Validate the record with assertions against DB
    		    			Utility.queryUnacceptableAd(result, this::assertUnacceptableAdd, pojo);
    		    			
    		    			
    		    		 
	}
	@Test(dependsOnMethods= {"validcheckduplicateGD"})
	public void invalidcheckduplicateGD() {
			Gson jsonPayload = new Gson();
 
		
			final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
					.addresstypecode(4)
	    			.entirepostalcodeInd(false)
	    			.postalcode(gdPostalcd)
	    			.provincecode("BC")
	    			.municipalityname("Illnois")
	    			.InstallationName("STN GD")
	    			.note("this is hospistal GD")
	    			.build();
    	
    	String payload = jsonPayload.toJson(pojo);

		 given().baseUri(BASE_URI)
    	.contentType("application/json")
    	.body(payload)
    	.auth().basic("userName", "pwd")
    	.when()
    	.post()
    	.then()
    	.assertThat().statusCode(400).and()
    	.body("code", Matchers.hasItem(Matchers.equalTo("302")) ).and()
    	.body("desc", Matchers.hasItem(Matchers.equalTo("Duplicate address")));


   
    	
    		//Validate record count it shouldnt be more than 2 rows for each postal code
    		Utility.queryUnacceptableAdCount(pojo.getPostalCode().toUpperCase().replace('-', ' '), 2);
			
			
		
		
	}
	@Test(dependsOnMethods= "validcheckduplicateRural")
	public void  sameRuralAdDuplicateTest() throws Exception {
		
		
		Gson jsonPayload = new Gson();
    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(2)
    			.entirepostalcodeInd(false)
    			.postalcode(ruralPostalcd)
    			.provincecode("NB")
    			.municipalityname("Rambo")
    			.routename("RR0016")
    			.ruralidentifiercd(1)
    			.note("this is hospistal rural")
    			.build();
    	
    	String payload = jsonPayload.toJson(pojo);

    	given().baseUri(BASE_URI)
    	.contentType("application/json")
    	.body(payload)
    	.auth().basic("userName", "pwd")
    	.when()
    	.post()
    	.then()
    	.assertThat().statusCode(400).and()
    	.body("code", Matchers.hasItem(Matchers.equalTo("302")) ).and()
    	.body("desc", Matchers.hasItem(Matchers.equalTo("Duplicate address")));
    
   
 
    	 			//Validate record count it should be 1 row for each postal code
    	 			Utility.queryDuplicateRuralAdCount(pojo.getPostalCode().toUpperCase().replace('-', ' '), pojo.getRuralIdentifierCd(), pojo.getRouteName());    		    			
    		    			
    		    			 
	}
	
	@Test(dependsOnMethods= {"validcheckduplicateCivic"})
	public void  sameCivicAdDuplicateTest() throws Exception {
		
		
		Gson jsonPayload = new Gson();
    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(1)
    			.entirepostalcodeInd(false)
    			.postalcode(civicPostalcd)
    			.provincecode("BC")
    			.municipalityname("Kingdom")
    			.streetnbr(676)
    			.streetname("Dunrobin")
    			.EntireUnitRangeInd(true)
    			.UnitNbr("45")
    			.note("this is hospistal")
    			.build();
    	
    	String payload = jsonPayload.toJson(pojo);

	
    	
    	
    	 			given().baseUri(BASE_URI)
    		    	.contentType("application/json")
    		    	.body(payload)
    		    	.auth().basic("userName", "pwd")
    		    	.when()
    		    	.post()
    		    	.then()
    		    	.assertThat().statusCode(400).and()
    		    	.body("code", Matchers.hasItem(Matchers.equalTo("302")) ).and()
    		    	.body("desc", Matchers.hasItem(Matchers.equalTo("Duplicate address")));
    		    	
    	 			//Validate record count it should be 1 row for each postal code
    	 			Utility.queryDuplicateCivicAdCount(pojo.getPostalCode().toUpperCase().replace('-', ' '), pojo.getStreetName(), pojo.getStreetNbr() );    		    			
    		    			
    		    			 
	}
	@Test(dependsOnMethods= "validcheckduplicatePOBox")
	public void  samePOBoxAdDuplicateTest() throws Exception {
		
		
		Gson jsonPayload = new Gson();
		final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
				.addresstypecode(3)
    			.entirepostalcodeInd(false)
    			.postalcode(poboxPostalcd)
    			.provincecode("NL")
    			.municipalityname("Fordsmith")
    			.PoBoxNbr(965)
    			.note("this is hospistal POBox")
    			.build();
    	
    	String payload = jsonPayload.toJson(pojo);

    	given().baseUri(BASE_URI)
    	.contentType("application/json")
    	.body(payload)
    	.auth().basic("userName", "pwd")
    	.when()
    	.post()
    	.then()
    	.assertThat().statusCode(400).and()
    	.body("code", Matchers.hasItem(Matchers.equalTo("302")) ).and()
    	.body("desc", Matchers.hasItem(Matchers.equalTo("Duplicate address")));
    
    	
    		    	
    	 			//Validate record count it should be 1 row for each postal code
    	 			Utility.queryDuplicatePOBoxAdCount(pojo.getPostalCode().toUpperCase().replace('-', ' '), pojo.getPoBoxNbr() );    		    			
    		    			
    		    			 
	}
	@Test(dependsOnMethods= {"validcheckduplicateGD"})
	public void  sameGDAdDuplicateTest() throws Exception {
		
		
		Gson jsonPayload = new Gson();
		final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
				.addresstypecode(4)
    			.entirepostalcodeInd(false)
    			.postalcode(gdPostalcd)
    			.provincecode("BC")
    			.municipalityname("Illnois")
    			.InstallationName("STN GD")
    			.note("this is hospistal GD")
    			.build();
    	
    	String payload = jsonPayload.toJson(pojo);

    	given().baseUri(BASE_URI)
    	.contentType("application/json")
    	.body(payload)
    	.auth().basic("userName", "pwd")
    	.when()
    	.post()
    	.then()
    	.assertThat().statusCode(400).and()
    	.body("code", Matchers.hasItem(Matchers.equalTo("302")) ).and()
    	.body("desc", Matchers.hasItem(Matchers.equalTo("Duplicate address")));
    
    	
    		    	
    	 			//Validate record count it should be 1 row for each postal code
    	 			Utility.queryDuplicateGDAdCount(pojo.getPostalCode().toUpperCase().replace('-', ' ') );    		    			
    		    			
    		    			 
	}
}
