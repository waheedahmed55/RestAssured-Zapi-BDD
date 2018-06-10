package com.restassured.update.PUT;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.restassured.pojo.UnacceptableAddBuilder;
import com.restassured.pojo.UnacceptableAddPojo;
import com.restassured.util.Utility;

public class InvalidFieldsValidationsTest extends AppTestBaseRest18 {
	/**
	 * Scenario: For an existing address try to update with invalid fields.
	 * Expected: Ensure it updates the existing records mandatory and applicable 
	 * fields and silently ignores invalid fields in DB. 
	 */
	@Test
	 public void updateCivicAddressInvalidFieldsAll() throws Exception {
   
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
    	
    	
		int recordID = Utility.queryAddressCreation(pojo);

    
    	 
		
    	
		
   	 pojo.setRuralIdentifierCd(2);
   	 pojo.setRouteName("SS0002");
   	 pojo.setSite(2);
	 pojo.setCompartment(2);
	 pojo.setConcession(2);
	 pojo.setLot(2);
	 pojo.setInstallationName("STNCV");
	 pojo.setPoBoxNbr(1010);
	 pojo.setProvinceCode("QC");
	 pojo.setMunicipality("Foxwood");
   	 pojo.setStreetDirectionCd(6);
   	 
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
	 public void updateCivicAddressInvalidFieldsSingle() throws Exception {
  
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
   			.EntireUnitRangeInd(false)
   			.UnitNbr("20")
   			.note("this is hospistal")
   			.build();
   	
	int recordID = Utility.queryAddressCreation(pojo);

   
   	 
		
   	
		
  	 pojo.setRuralIdentifierCd(2);
  	 pojo.setRouteName("SS0002");
  	 pojo.setSite(2);
	 pojo.setCompartment(2);
	 pojo.setConcession(2);
	 pojo.setLot(2);
	 pojo.setInstallationName("STNCV");
	 pojo.setPoBoxNbr(1010);
	 pojo.setProvinceCode("QC");
	 pojo.setMunicipality("Foxwood");
  	 pojo.setStreetDirectionCd(6);
  	 pojo.setUnitNbr("15A");
  	 
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
	 public void updateCivicAddressInvalidFieldsRange() throws Exception {
 
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
  			.EntireUnitRangeInd(false)
  			.UnitNbr("20")
  			.ToUnitNbr("35")
  			.note("this is hospistal")
  			.build();
  	
	int recordID = Utility.queryAddressCreation(pojo);

	
  
  	 
		
  	
		
 	 pojo.setRuralIdentifierCd(2);
 	 pojo.setRouteName("SS0002");
 	 pojo.setSite(2);
	 pojo.setCompartment(2);
	 pojo.setConcession(2);
	 pojo.setLot(2);
	 pojo.setInstallationName("STNCV");
	 pojo.setPoBoxNbr(1010);
	 pojo.setProvinceCode("QC");
	 pojo.setMunicipality("Foxwood");
 	 pojo.setStreetDirectionCd(6);
 	 //UnitNb>ToUnitNbr 
 	 pojo.setUnitNbr("19");
 	 pojo.setToUnitNbr("10");
 	 
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
	public void updateRuralAddressInvalidFields() throws Exception {
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

		
    
    	 
    	 
    	 pojo.setRuralIdentifierCd(2);
     	 pojo.setRouteName("SS0002");
     	 pojo.setSite(2);
    	 pojo.setCompartment(2);
    	 pojo.setConcession(2);
    	 pojo.setLot(2);
    	 pojo.setInstallationName("STNCV");
    	 pojo.setPoBoxNbr(1010);
    	 pojo.setProvinceCode("QC");
    	 pojo.setMunicipality("Foxwood");
     	 pojo.setStreetDirectionCd(6);
     	 pojo.setUnitNbr("19");
     	 pojo.setToUnitNbr("10");
     	 pojo.setStreetName("Albert");
     	 pojo.setStreetTypeCd(12);
     	 
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
	public void updatePOBoxAddressInvalidFields() throws Exception {
		
	
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

		
    
    	 
    	 pojo.setRuralIdentifierCd(2);
     	 pojo.setRouteName("SS0002");
     	 pojo.setSite(2);
    	 pojo.setCompartment(2);
    	 pojo.setConcession(2);
    	 pojo.setLot(2);
    	 pojo.setInstallationName("STNCV");
    	 pojo.setPoBoxNbr(1010);
    	 pojo.setProvinceCode("QC");
    	 pojo.setMunicipality("Foxwood");
     	 pojo.setStreetDirectionCd(6);
     	 pojo.setUnitNbr("19");
     	 pojo.setToUnitNbr("10");
     	 pojo.setStreetName("Albert");
     	 pojo.setStreetTypeCd(12);
     	 
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
	public void updateGDAddressInvalidFields() throws Exception {
	
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

		
    
    	 
    	 
    	 pojo.setRuralIdentifierCd(2);
     	 pojo.setRouteName("SS0002");
     	 pojo.setSite(2);
    	 pojo.setCompartment(2);
    	 pojo.setConcession(2);
    	 pojo.setLot(2);
    	 pojo.setInstallationName("STNCV");
    	 pojo.setPoBoxNbr(1010);
    	 pojo.setProvinceCode("QC");
    	 pojo.setMunicipality("Foxwood");
     	 pojo.setStreetDirectionCd(6);
     	 pojo.setUnitNbr("19");
     	 pojo.setToUnitNbr("10");
     	 pojo.setStreetName("Albert");
     	 pojo.setStreetTypeCd(12);
     	 
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
