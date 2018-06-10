package com.restassured.update.PUT;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.restassured.pojo.UnacceptableAddBuilder;
import com.restassured.pojo.UnacceptableAddPojo;
import com.restassured.util.Utility;

public class DuplicateAddressValidationsTest extends AppTestBaseRest18{

	@Test
    public void updateCivicAddressDuplicateCheck() throws Exception {
		
		Gson jsonPayload = new Gson();
        String postalcd = Utility.generateUnacceptableAddPostalCd();

		//Civic Address 1 ID 113
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
    	
		int recordID1 = Utility.queryAddressCreation(pojo);

    	 
    	//Civic Address 2 ID 114
         String postalcd2 = Utility.generateUnacceptableAddPostalCd();

     	final UnacceptableAddPojo pojo2 = new UnacceptableAddBuilder()
     			.addresstypecode(1)
     			.entirepostalcodeInd(false)
     			.postalcode(postalcd2)
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
     	
		int recordID2 = Utility.queryAddressCreation(pojo2);

 		
 		pojo2.setPostalCode(postalcd);
 		 String payload = jsonPayload.toJson(pojo2);
 		 givenUpdateUnacceptableAd(recordID2,payload)
     	.put()
    	.then()
    	.assertThat().statusCode(400).and()
    	.body("code", Matchers.hasItem(Matchers.equalTo("302")) ).and()
    	.body("desc", Matchers.hasItem(Matchers.equalTo("Duplicate address")));
    	
			//Validate record count it should be 1 row for each postal code
			//Utility.queryDuplicateCivicAdCount(pojo.getPostalCode(), pojo.getStreetName(), pojo.getStreetNbr() );    		    			
    	 pojo2.setPostalCode(postalcd2);
    	try {
    		//Validate the record with assertions against DB
			Utility.queryUnacceptableAd(recordID2, this::assertUnacceptableAdd, pojo2);
			
		} finally {
			//Delete the record
			Utility.queryUnacceptableAdDelete(recordID1);
			Utility.queryUnacceptableAdDelete(recordID2);
		}

    	
    }
	@Test
	public void updateRuralAddressDuplicateCheck() throws Exception {
    	Gson jsonPayload = new Gson();
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	//Rural Address 1 
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
    	
		int recordID1 = Utility.queryAddressCreation(pojo);

    	 
    	//Rural Address 2 
         String postalcd2 = Utility.generateUnacceptableAddPostalCd();

     	final UnacceptableAddPojo pojo2 = new UnacceptableAddBuilder()
     			.addresstypecode(2)
     			.entirepostalcodeInd(false)
     			.postalcode(postalcd2)
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
     	
	int recordID2 = Utility.queryAddressCreation(pojo2);

 		
 		pojo2.setPostalCode(postalcd);
 		 String payload = jsonPayload.toJson(pojo2);
 		 givenUpdateUnacceptableAd(recordID2,payload)
     	.put()
      	.then()
      	.assertThat().statusCode(400).and()
    	.body("code", Matchers.hasItem(Matchers.equalTo("302")) ).and()
    	.body("desc", Matchers.hasItem(Matchers.equalTo("Duplicate address")));
    	 pojo2.setPostalCode(postalcd2);
    	try {
    		//Validate the record with assertions against DB
			Utility.queryUnacceptableAd(recordID2, this::assertUnacceptableAdd, pojo2);
			
			
		
		} finally {
			//Delete the record
			Utility.queryUnacceptableAdDelete(recordID1);
			Utility.queryUnacceptableAdDelete(recordID2);
		}

    	
    }
	@Test
	public void updatePOBoxAddressDuplicateCheck() throws Exception {
		
		
    	Gson jsonPayload = new Gson();
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	//POBox Ad 1
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
    	
		int recordID1 = Utility.queryAddressCreation(pojo);

    	 
    		//POBox Ad 2
         String postalcd2 = Utility.generateUnacceptableAddPostalCd();

     	final UnacceptableAddPojo pojo2 = new UnacceptableAddBuilder()
     			.addresstypecode(3)
     			.entirepostalcodeInd(false)
     			.postalcode(postalcd2)
     			.provincecode("NL")
     			.municipalityname("LoydFord")
     			.PoBoxNbr(909)
     			.InstallationName("STNPOB")
     			.note("this is pobox")
     			.build();
     	
int recordID2 = Utility.queryAddressCreation(pojo2);

 		
 		pojo2.setPostalCode(postalcd);
 		 String payload = jsonPayload.toJson(pojo2);
 		 givenUpdateUnacceptableAd(recordID2,payload)
     	.put()
       	.then()
       	.assertThat().statusCode(400).and()
    	.body("code", Matchers.hasItem(Matchers.equalTo("302")) ).and()
    	.body("desc", Matchers.hasItem(Matchers.equalTo("Duplicate address")));
    	 
    	 pojo2.setPostalCode(postalcd2);
    	try {
    		//Validate the record with assertions against DB
			Utility.queryUnacceptableAd(recordID2, this::assertUnacceptableAdd, pojo2);
			
			
	
		} finally {
			//Delete the record
			Utility.queryUnacceptableAdDelete(recordID1);
			Utility.queryUnacceptableAdDelete(recordID2);
		}   
    	
    }
	@Test
	public void updateGDAddressDuplicateCheck() throws Exception {


    	Gson jsonPayload = new Gson();
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	//GD Ad 1
    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(4)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("BC")
    			.municipalityname("HillTop")
    			.InstallationName("STNGD")
    			.note("this is GD Ad")
    			.build();
    	
		int recordID1 = Utility.queryAddressCreation(pojo);

    	 
    	//GD Ad 2
         String postalcd2 = Utility.generateUnacceptableAddPostalCd();

     	final UnacceptableAddPojo pojo2 = new UnacceptableAddBuilder()
     			.addresstypecode(4)
     			.entirepostalcodeInd(false)
     			.postalcode(postalcd2)
     			.provincecode("BC")
     			.municipalityname("HillTop")
     			.InstallationName("STNGD")
     			.note("this is GD Ad")
     			.build();
     	
int recordID2 = Utility.queryAddressCreation(pojo2);

 		
 		pojo2.setPostalCode(postalcd);
 		 String payload = jsonPayload.toJson(pojo2);
 		 givenUpdateUnacceptableAd(recordID2,payload)
     	.put()
     	.then()
     	.assertThat().statusCode(400).and()
    	.body("code", Matchers.hasItem(Matchers.equalTo("302")) ).and()
    	.body("desc", Matchers.hasItem(Matchers.equalTo("Duplicate address")));
    	 
    	 pojo2.setPostalCode(postalcd2);
   
    	try {
    		//Validate the record with assertions against DB
			Utility.queryUnacceptableAd(recordID2, this::assertUnacceptableAdd, pojo2);
			
			
		
		} finally {
			//Delete the record
			Utility.queryUnacceptableAdDelete(recordID1);
			Utility.queryUnacceptableAdDelete(recordID2);
		}   
    	
    }
}
