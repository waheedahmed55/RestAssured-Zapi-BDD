package com.restassured.update.PUT;

import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.restassured.pojo.UnacceptableAddBuilder;
import com.restassured.pojo.UnacceptableAddPojo;
import com.restassured.util.Utility;

public class ApplicableAddressFieldsUpdateTest extends AppTestBaseRest18 {
	
	@Test
    public void updateCivicAddressApplicableFields() throws Exception {
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
    			.note("this is hospistal")
    			.build();
    	
    	
		int recordID = Utility.queryAddressCreation(pojo);
		
    	 pojo.setStreetNbrSuffix("5");
    	 pojo.setStreetTypeCd(12);
    	 pojo.setStreetDirectionCd(7);
    	 pojo.setNotes("this is civic ap f");
    	 pojo.setEntireUnitRangeInd(true);
    	 String payload = jsonPayload.toJson(pojo);
 		 givenUpdateUnacceptableAd(recordID,payload)
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
    public void updateCivicAddressApplicableFieldsSingle() throws Exception {
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
    	
		int recordID = Utility.queryAddressCreation(pojo);

   
    	 pojo.setStreetNbrSuffix("5");
    	 pojo.setStreetTypeCd(12);
    	 pojo.setStreetDirectionCd(7);
    	 pojo.setNotes("this is civic single");
    	 pojo.setUnitNbr("11");
    	 String payload = jsonPayload.toJson(pojo);
 		 givenUpdateUnacceptableAd(recordID,payload)
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
    public void updateCivicAddressApplicableFieldsRange() throws Exception {
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
    			.UnitNbr("20")
    			.ToUnitNbr("25")
    			.note("this is hospistal")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

   
    	 pojo.setStreetNbrSuffix("5");
    	 pojo.setStreetTypeCd(12);
    	 pojo.setStreetDirectionCd(7);
    	 pojo.setNotes("this is civic single");
    	 pojo.setUnitNbr("26");
    	 pojo.setToUnitNbr("36");
    	 String payload = jsonPayload.toJson(pojo);
 		 givenUpdateUnacceptableAd(recordID,payload)
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
    public void updateCivicAddressApplicableFieldsAll() throws Exception {
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
    			.UnitNbr("20")
    			.ToUnitNbr("25")
    			.note("this is hospistal")
    			.build();
    	
		int recordID = Utility.queryAddressCreation(pojo);

   
    	
    	 pojo.setStreetNbrSuffix("5");
    	 pojo.setStreetTypeCd(12);
    	 pojo.setStreetDirectionCd(7);
    	 pojo.setNotes("this is civic single");
    	 pojo.setUnitNbr("26");
    	 pojo.setToUnitNbr("36");
    	 String payload = jsonPayload.toJson(pojo);
 		 givenUpdateUnacceptableAd(recordID,payload)
     	.put()
     	.then()
     	.assertThat().statusCode(204);
    	 
    	 //to be discsused whether we need to set them to null 
    	 pojo.setUnitNbr(null);
    	 pojo.setToUnitNbr(null);
    	 
    	try {
    		//Validate the record with assertions against DB
			Utility.queryUnacceptableAd(recordID, this::assertUnacceptableAdd, pojo);
			
		} finally {
			//Delete the record
			Utility.queryUnacceptableAdDelete(recordID);
		}

    	
    }
	@Test
	public void updateRuralAddressApplicableFields() throws Exception {
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

    	
    	 pojo.setSite(88);
    	 pojo.setCompartment(88);
    	 pojo.setConcession(88);
    	 pojo.setLot(88);
    	 pojo.setInstallationName("STNRA");
    	 pojo.setNotes("this is rural update");
    	 
    	 String payload = jsonPayload.toJson(pojo);
 		 givenUpdateUnacceptableAd(recordID,payload)
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
	public void updatePOBoxAddressApplicableFields() throws Exception {
		
	
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

  
    	 pojo.setInstallationName("STNPOBX");
    	 pojo.setNotes("this is pobox update");
    	 
    	 String payload = jsonPayload.toJson(pojo);
 		 givenUpdateUnacceptableAd(recordID,payload)
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
	public void updateGDAddressApplicableFields() throws Exception {
	
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

    	
    	 pojo.setNotes("This is GD Ad Update");
    	 
    	 String payload = jsonPayload.toJson(pojo);
 		 givenUpdateUnacceptableAd(recordID,payload)
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
	public void updateentirePostalCodeAddressFields() throws Exception {
		Gson jsonPayload = new Gson();
		String postalcd = Utility.generateUnacceptableAddPostalCd();

		final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
				.entirepostalcodeInd(true)
				.postalcode(postalcd)
				.note("this is hospistal")
				.build();

		int recordID = Utility.queryAddressCreation(pojo);

		pojo.setNotes("this entirepostalcode");
		String postalcd2 = Utility.generateUnacceptableAddPostalCd();

		pojo.setPostalCode(postalcd2);
		String payload = jsonPayload.toJson(pojo);

		givenUpdateUnacceptableAd(recordID, payload).put().then().assertThat().statusCode(204);

		try {
			// Validate the record with assertions against DB
			Utility.queryUnacceptableAd(recordID, this::assertUnacceptableAdd, pojo);
		} finally {
			// Delete the record
			Utility.queryUnacceptableAdDelete(recordID);
		}
	}

}
