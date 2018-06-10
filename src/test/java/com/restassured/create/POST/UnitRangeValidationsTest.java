package com.restassured.create.POST;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.restassured.pojo.UnacceptableAddBuilder;
import com.restassured.pojo.UnacceptableAddPojo;
import com.restassured.util.Utility;

public class UnitRangeValidationsTest extends AppTestBaseRest17 {
	
	public void setJiraTestCaseParamters() {
		// This should be mapped to existing JIRA issue
		// if left as null a new JIRA test case will be created in JIRA
		this.issueID = null; 
		this.desc = "Unit Range Validation";
	}
	
	@Test
    public void unitRangeUnitNbrmissing() throws Exception {
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
    			.UnitNbr("")
    			.ToUnitNbr("25")
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
    	.body("code", Matchers.hasItem(Matchers.equalTo("301")) ).and()
    	.body("desc", Matchers.hasItem(Matchers.equalTo("Range unacceptable")));
	
    
		//DB check
		Utility.queryRecordCheckCreation(pojo.getPostalCode(), pojo.getUnitNbr(), pojo.getToUnitNbr());    	
    }
	
	@Test
    public void unitRangeUnitNbrToUnitNbrsame() throws Exception {
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
    			.UnitNbr("25")
    			.ToUnitNbr("25")
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
    	.body("code", Matchers.hasItem(Matchers.equalTo("311")) ).and()
    	.body("desc", Matchers.hasItem(Matchers.equalTo("Values entered for the From and To unit are the same")));
    
		//DB check
		Utility.queryRecordCheckCreation(pojo.getPostalCode(), pojo.getUnitNbr(), pojo.getToUnitNbr());
				

    	
    }
	@Test
    public void unitRangeToUnitNbrAlphaNumeric() throws Exception {
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
    			.UnitNbr("20")
    			.ToUnitNbr("25A")
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
    	.body("code", Matchers.hasItem(Matchers.equalTo("312")) ).and()
    	.body("desc", Matchers.hasItem(Matchers.equalTo("The From and To unit values have incompatible formats")));
    
		//DB check
		Utility.queryRecordCheckCreation(pojo.getPostalCode(), pojo.getUnitNbr(), pojo.getToUnitNbr());

    	
    }
	@Test
    public void unitRangeUnitNbrAlphaNumeric() throws Exception {
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
    			.UnitNbr("20A")
    			.ToUnitNbr("25")
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
    	.body("code", Matchers.hasItem(Matchers.equalTo("312")) ).and()
    	.body("desc", Matchers.hasItem(Matchers.equalTo("The From and To unit values have incompatible formats")));
    
		//DB check
		Utility.queryRecordCheckCreation(pojo.getPostalCode(), pojo.getUnitNbr(), pojo.getToUnitNbr());


    	
    }
	@Test
    public void unitRangeUnitNbrToUnitNbrAlphaNumeric() throws Exception {
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
    			.UnitNbr("20A")
    			.ToUnitNbr("25A")
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
    	.body("code", Matchers.hasItem(Matchers.equalTo("312")) ).and()
    	.body("desc", Matchers.hasItem(Matchers.equalTo("The From and To unit values have incompatible formats")));
		
    
		//DB check
		Utility.queryRecordCheckCreation(pojo.getPostalCode(), pojo.getUnitNbr(), pojo.getToUnitNbr());


    	
    }
	@Test
    public void unitRangeUnitNbrAlphaNumericSingle() throws Exception {
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
    			.UnitNbr("A3")
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
    public void unitRangeUnitNbrNumericAlphaSingle() throws Exception {
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
    			.UnitNbr("3A")
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
    public void unitRangeUnitNbrgreaterthanToUnitNbr() throws Exception {
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
    			.UnitNbr("20")
    			.ToUnitNbr("15")
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
    public void unitRangeEntireUnitRangeIndisTrue() throws Exception {
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
    			.UnitNbr("20")
    			.ToUnitNbr("15")
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
    public void unitRangeExistsConflict1() throws Exception {
    	Gson jsonPayload = new Gson();
    	String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(1)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("AB")
    			.municipalityname("Rumsfield")
    			.streetnbr(999)
    			.streetname("Peterborough")
    			.StreetNbrSuffix("4")
    			.StreetTypeCd(11)
    			.StreetDirectionCd(5)
    			.EntireUnitRangeInd(false)
    			.UnitNbr("10")
    			.ToUnitNbr("20")
    			.note("this is hospistal unit range conf1")
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
			
			pojo.setUnitNbr("5");
			pojo.setToUnitNbr("12");
	    	payload = jsonPayload.toJson(pojo);
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
	    		    
	    	         	//DB check
	    	     		Utility.queryRecordCheckCreation(pojo.getPostalCode(), pojo.getUnitNbr(), pojo.getToUnitNbr());
    	
    }
	@Test
    public void unitRangeExistsConflict2() throws Exception {
    	Gson jsonPayload = new Gson();
    	String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(1)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("ON")
    			.municipalityname("Missiasauga")
    			.streetnbr(9666)
    			.streetname("Brampton")
    			.StreetNbrSuffix("4")
    			.StreetTypeCd(11)
    			.StreetDirectionCd(5)
    			.EntireUnitRangeInd(false)
    			.UnitNbr("10")
    			.ToUnitNbr("20")
    			.note("this is hospistal conf2")
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
			
			pojo.setUnitNbr("12");
			pojo.setToUnitNbr("16");
	    	payload = jsonPayload.toJson(pojo);
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
	    		    
	    	           //DB check
	    	             Utility.queryRecordCheckCreation(pojo.getPostalCode(), pojo.getUnitNbr(), pojo.getToUnitNbr());
    	
    }
	@Test
    public void unitRangeExistsConflict3() throws Exception {
    	Gson jsonPayload = new Gson();
    	String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(1)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("NB")
    			.municipalityname("Ottawa")
    			.streetnbr(999)
    			.streetname("BellCorner")
    			.StreetNbrSuffix("4")
    			.StreetTypeCd(11)
    			.StreetDirectionCd(5)
    			.EntireUnitRangeInd(false)
    			.UnitNbr("10")
    			.ToUnitNbr("20")
    			.note("this is hospistal conf3")
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
			
			pojo.setUnitNbr("12");
			pojo.setToUnitNbr("25");
	    	payload = jsonPayload.toJson(pojo);
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
	    		    
	    	           //DB check
		    	     Utility.queryRecordCheckCreation(pojo.getPostalCode(), pojo.getUnitNbr(), pojo.getToUnitNbr());

    	
    }
	@Test
    public void unitRangeExistsConflict4() throws Exception {
		
	    	Gson jsonPayload = new Gson();
	    	String postalcd = Utility.generateUnacceptableAddPostalCd();

	    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
	    			.addresstypecode(1)
	    			.entirepostalcodeInd(false)
	    			.postalcode(postalcd)
	    			.provincecode("NL")
	    			.municipalityname("KirkLand")
	    			.streetnbr(555)
	    			.streetname("Quebec")
	    			.StreetNbrSuffix("4")
	    			.StreetTypeCd(11)
	    			.StreetDirectionCd(5)
	    			.EntireUnitRangeInd(false)
	    			.UnitNbr("10")
	    			.ToUnitNbr("25")
	    			.note("this is hospistal conf4")
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

				pojo.setUnitNbr("26");
				pojo.setToUnitNbr("36");
				payload = jsonPayload.toJson(pojo);
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
				    
				    	 
				    	 adIDsTodelete.add(result);
				    	//Validate the record with assertions against DB
							Utility.queryUnacceptableAd(result, this::assertUnacceptableAdd, pojo);
	    	
	    }
}
