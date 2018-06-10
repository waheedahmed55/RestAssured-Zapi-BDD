package com.restassured.update.PUT;

import static io.restassured.RestAssured.given;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.restassured.pojo.UnacceptableAddBuilder;
import com.restassured.pojo.UnacceptableAddPojo;
import com.restassured.util.Utility;

public class UnitRangeValidationsTest extends AppTestBaseRest18 {

	@Test
    public void updateunitRangeUnitNbrmissing() throws Exception {
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
    			.note("this is hospistal")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

		
    
    	 
	

    	 pojo.setUnitNbr(null);
    	 //we update the entire unit range ind = true to represent valid scenario ALL
    	 pojo.setEntireUnitRangeInd(true);
    	 String payload = jsonPayload.toJson(pojo);
    
    	 given().baseUri(BASE_URI+"/"+recordID)
      	.contentType("application/json")
      	.body(payload)
      	.auth().basic("userName", "pwd")
      	.when()
      	.put()
      	.then()
      	.assertThat().statusCode(204);
    	 
    	 //check if we have assertion where entireuniterangeind = false and both are null I believe we would have set
    	 //DB query to ensure unitNbr is null
    	 try {
     		//Validate the record with assertions against DB
 			Utility.queryUnacceptableAd(recordID, this::assertUnacceptableAdd, pojo);
 			
 			
 	
 		} finally {
 			//Delete the record
 			Utility.queryUnacceptableAdDelete(recordID);
 		}   
		
    }
	@Test
    public void updateunitRangeUnitNbrUpdate() throws Exception {
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
    			.ToUnitNbr("20")
    			.note("this is hospistal")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

		
	
    	 pojo.setUnitNbr("5");
    	 String payload = jsonPayload.toJson(pojo);
    
    	 given().baseUri(BASE_URI+"/"+recordID)
      	.contentType("application/json")
      	.body(payload)
      	.auth().basic("userName", "pwd")
      	.when()
      	.put()
      	.then()
      	.assertThat().statusCode(204);
    	 
    	 
    	 try {
     		//Validate the record with assertions against DB
 			Utility.queryUnacceptableAd(recordID, this::assertUnacceptableAdd, pojo);
 			
 			
 	
 		} finally {
 			//Delete the record
 			Utility.queryUnacceptableAdDelete(recordID);
 		}   
		
    }
	
	@Test
    public void updateunitRangeToUnitNbrUpdate() throws Exception {
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
    			.ToUnitNbr("20")
    			.note("this is hospistal")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

		
	
    	 pojo.setToUnitNbr("25");
    	 String payload = jsonPayload.toJson(pojo);
    
    	 given().baseUri(BASE_URI+"/"+recordID)
      	.contentType("application/json")
      	.body(payload)
      	.auth().basic("userName", "pwd")
      	.when()
      	.put()
      	.then()
      	.assertThat().statusCode(204);
    	 
    	 
    	 try {
     		//Validate the record with assertions against DB
 			Utility.queryUnacceptableAd(recordID, this::assertUnacceptableAdd, pojo);
 			
 			
 	
 		} finally {
 			//Delete the record
 			Utility.queryUnacceptableAdDelete(recordID);
 		}   
		
    }
	@Test
    public void updateunitRangeUnitNbrToUnitNbrAlphaNumeric() throws Exception {
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
    			.ToUnitNbr("20")
    			.note("this is hospistal")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

		
	
    	 pojo.setUnitNbr("10A");
    	 pojo.setToUnitNbr("20A");
    	 String payload = jsonPayload.toJson(pojo);
    
    	 given().baseUri(BASE_URI+"/"+recordID)
      	.contentType("application/json")
      	.body(payload)
      	.auth().basic("userName", "pwd")
      	.when()
      	.put()
      	.then()
      	.assertThat().statusCode(400).and()
    	.body("code", Matchers.hasItem(Matchers.equalTo("312")) ).and()
    	.body("desc", Matchers.hasItem(Matchers.equalTo("The From and To unit values have incompatible formats")));
    	 
    	 pojo.setUnitNbr("10");
    	 pojo.setToUnitNbr("20");
    
    	 
    	 try {
     		//Validate the record with assertions against DB
 			Utility.queryUnacceptableAd(recordID, this::assertUnacceptableAdd, pojo);
 			
 			
 	
 		} finally {
 			//Delete the record
 			Utility.queryUnacceptableAdDelete(recordID);
 		}   
		
    }
	@Test
    public void updateunitRangeUnitNbrAlphaNumericToUnitNbrNumeric() throws Exception {
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
    			.ToUnitNbr("20")
    			.note("this is hospistal")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

	
    	 pojo.setUnitNbr("10A");
    	 pojo.setToUnitNbr("21");
    	 String payload = jsonPayload.toJson(pojo);
    
    	 given().baseUri(BASE_URI+"/"+recordID)
      	.contentType("application/json")
      	.body(payload)
      	.auth().basic("userName", "pwd")
      	.when()
      	.put()
      	.then()
      	.assertThat().statusCode(400).and()
    	.body("code", Matchers.hasItem(Matchers.equalTo("312")) ).and()
    	.body("desc", Matchers.hasItem(Matchers.equalTo("The From and To unit values have incompatible formats")));
    	 
    	 pojo.setUnitNbr("10");
    	 pojo.setToUnitNbr("20");
    	 
    	
    	 
    	 try {
     		//Validate the record with assertions against DB
 			Utility.queryUnacceptableAd(recordID, this::assertUnacceptableAdd, pojo);
 			
 			
 	
 		} finally {
 			//Delete the record
 			Utility.queryUnacceptableAdDelete(recordID);
 		}   
		
    }
	@Test
    public void updateunitRangeUnitNbrNumericToUnitNbrAlphaNumeric() throws Exception {
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
    			.ToUnitNbr("20")
    			.note("this is hospistal")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

		
	
    	 pojo.setUnitNbr("10");
    	 pojo.setToUnitNbr("21A");
    	 String payload = jsonPayload.toJson(pojo);
    
    	 given().baseUri(BASE_URI+"/"+recordID)
      	.contentType("application/json")
      	.body(payload)
      	.auth().basic("userName", "pwd")
      	.when()
      	.put()
      	.then()
      	.assertThat().statusCode(400).and()
    	.body("code", Matchers.hasItem(Matchers.equalTo("312")) ).and()
    	.body("desc", Matchers.hasItem(Matchers.equalTo("The From and To unit values have incompatible formats")));
    	 
    	 pojo.setUnitNbr("10");
    	 pojo.setToUnitNbr("20");
    	 
    	
    	 
    	 try {
     		//Validate the record with assertions against DB
 			Utility.queryUnacceptableAd(recordID, this::assertUnacceptableAdd, pojo);
 			
 			
 	
 		} finally {
 			//Delete the record
 			Utility.queryUnacceptableAdDelete(recordID);
 		}   
		
    }
	@Test
    public void updateunitRangeUnitNbrAlphaNumericSingle() throws Exception {
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
    			.UnitNbr("A10")
    			.note("this is hospistal")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

    	 pojo.setUnitNbr("A11");
    	 
    	 
    	 String payload = jsonPayload.toJson(pojo);
    
    	 given().baseUri(BASE_URI+"/"+recordID)
      	.contentType("application/json")
      	.body(payload)
      	.auth().basic("userName", "pwd")
      	.when()
      	.put()
      	.then()
      	.assertThat().statusCode(204);
    	 
    	
    	 try {
     		//Validate the record with assertions against DB
 			Utility.queryUnacceptableAd(recordID, this::assertUnacceptableAdd, pojo);
 			
 			
 	
 		} finally {
 			//Delete the record
 			Utility.queryUnacceptableAdDelete(recordID);
 		}   
		
    }
	@Test
    public void updateunitRangeUnitNbrNumericAlphaSingle() throws Exception {
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
    			.UnitNbr("10A")
    			.note("this is hospistal")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

		
	
    	 pojo.setUnitNbr("11A");
    	 String payload = jsonPayload.toJson(pojo);
    
    	 given().baseUri(BASE_URI+"/"+recordID)
      	.contentType("application/json")
      	.body(payload)
      	.auth().basic("userName", "pwd")
      	.when()
      	.put()
      	.then()
      	.assertThat().statusCode(204);
    	 
    	
    	 try {
     		//Validate the record with assertions against DB
 			Utility.queryUnacceptableAd(recordID, this::assertUnacceptableAdd, pojo);
 			
 			
 	
 		} finally {
 			//Delete the record
 			Utility.queryUnacceptableAdDelete(recordID);
 		}   
		
    }
	@Test
    public void updateunitRangeUnitNbrGreaterToUnitNbr() throws Exception {
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
    			.ToUnitNbr("20")
    			.note("this is hospistal")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

		
	
    	 pojo.setUnitNbr("30");
    	 pojo.setToUnitNbr("25");
    	 String payload = jsonPayload.toJson(pojo);
    
    	 given().baseUri(BASE_URI+"/"+recordID)
      	.contentType("application/json")
      	.body(payload)
      	.auth().basic("userName", "pwd")
      	.when()
      	.put()
      	.then()
      	.assertThat().statusCode(204);
    	 
    	
    	 try {
     		//Validate the record with assertions against DB
 			Utility.queryUnacceptableAd(recordID, this::assertUnacceptableAdd, pojo);
 			
 			
 	
 		} finally {
 			//Delete the record
 			Utility.queryUnacceptableAdDelete(recordID);
 		}   
		
    }
	@Test
    public void updateunitRangeUnitNbrToUnitNbrSame() throws Exception {
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
    			.ToUnitNbr("20")
    			.note("this is hospistal")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

		
    	 pojo.setUnitNbr("30");
    	 pojo.setToUnitNbr("30");
    	 String payload = jsonPayload.toJson(pojo);
    
    	 given().baseUri(BASE_URI+"/"+recordID)
      	.contentType("application/json")
      	.body(payload)
      	.auth().basic("userName", "pwd")
      	.when()
      	.put()
      	.then()
      	.assertThat().statusCode(400).and()
    	.body("code", Matchers.hasItem(Matchers.equalTo("311")) ).and()
    	.body("desc", Matchers.hasItem(Matchers.equalTo("Values entered for the From and To unit are the same")));
    	 
    	 pojo.setUnitNbr("10");
    	 pojo.setToUnitNbr("20");
    	
    	 try {
     		//Validate the record with assertions against DB
 			Utility.queryUnacceptableAd(recordID, this::assertUnacceptableAdd, pojo);
 			
 			
 	
 		} finally {
 			//Delete the record
 			Utility.queryUnacceptableAdDelete(recordID);
 		}   
		
    }
	@Test
    public void updateunitRangeUnitNbrToUnitNbrBefore() throws Exception {
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
    			.ToUnitNbr("20")
    			.note("this is hospistal")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

	
	
    	 pojo.setUnitNbr("1");
    	 pojo.setToUnitNbr("9");
    	 String payload = jsonPayload.toJson(pojo);
    
    	 given().baseUri(BASE_URI+"/"+recordID)
      	.contentType("application/json")
      	.body(payload)
      	.auth().basic("userName", "pwd")
      	.when()
      	.put()
      	.then()
      	.assertThat().statusCode(204);
    	 
    	 
    	
    	 try {
     		//Validate the record with assertions against DB
 			Utility.queryUnacceptableAd(recordID, this::assertUnacceptableAdd, pojo);
 			
 			
 	
 		} finally {
 			//Delete the record
 			Utility.queryUnacceptableAdDelete(recordID);
 		}   
		
    }
	@Test
    public void updateunitRangeUnitNbrToUnitNbrMiddle() throws Exception {
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
    			.ToUnitNbr("20")
    			.note("this is hospistal")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

		
	
    	 pojo.setUnitNbr("11");
    	 pojo.setToUnitNbr("19");
    	 String payload = jsonPayload.toJson(pojo);
    
    	 given().baseUri(BASE_URI+"/"+recordID)
      	.contentType("application/json")
      	.body(payload)
      	.auth().basic("userName", "pwd")
      	.when()
      	.put()
      	.then()
      	.assertThat().statusCode(204);
    	 
    	 
    	
    	 try {
     		//Validate the record with assertions against DB
 			Utility.queryUnacceptableAd(recordID, this::assertUnacceptableAdd, pojo);
 			
 			
 	
 		} finally {
 			//Delete the record
 			Utility.queryUnacceptableAdDelete(recordID);
 		}   
		
    }
	@Test
    public void updateunitRangeUnitNbrToUnitNbrAfter() throws Exception {
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
    			.ToUnitNbr("20")
    			.note("this is hospistal")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

		
	
    	 pojo.setUnitNbr("21");
    	 pojo.setToUnitNbr("31");
    	 String payload = jsonPayload.toJson(pojo);
    
    	 given().baseUri(BASE_URI+"/"+recordID)
      	.contentType("application/json")
      	.body(payload)
      	.auth().basic("userName", "pwd")
      	.when()
      	.put()
      	.then()
      	.assertThat().statusCode(204);
    	 
    	 
    	
    	 try {
     		//Validate the record with assertions against DB
 			Utility.queryUnacceptableAd(recordID, this::assertUnacceptableAdd, pojo);
 			
 			
 	
 		} finally {
 			//Delete the record
 			Utility.queryUnacceptableAdDelete(recordID);
 		}   
		
    }
}
