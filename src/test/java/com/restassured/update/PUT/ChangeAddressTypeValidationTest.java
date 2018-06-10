package com.restassured.update.PUT;

import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.restassured.pojo.UnacceptableAddBuilder;
import com.restassured.pojo.UnacceptableAddPojo;
import com.restassured.util.Utility;

public class ChangeAddressTypeValidationTest extends AppTestBaseRest18 {


	@Test
    public void updateCivicAddressTypeToRural() throws Exception {
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

   
    	 
    	 pojo.setAddressTypeCd(2);
    	 pojo.setRuralIdentifierCd(2);
    	 pojo.setRouteName("SS0012");
    	 pojo.setSite(2);
    	 pojo.setCompartment(2);
    	 pojo.setConcession(2);
    	 pojo.setLot(2);
    	 pojo.setInstallationName("STNR");
    	 pojo.setPoBoxNbr(8989);
    	 pojo.setStreetName("scarborough");
    	 
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
    public void updateCivicAddressTypeToPOBox() throws Exception {
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

    	 //do we need to set them to null for assertion tbd
    	 pojo.setAddressTypeCd(3);
    	 pojo.setPoBoxNbr(9090);
    	 pojo.setRuralIdentifierCd(2);
    	 pojo.setRouteName("SS0012");
    	 pojo.setSite(2);
    	 pojo.setCompartment(2);
    	 pojo.setConcession(2);
    	 pojo.setLot(2);
    	 pojo.setInstallationName("STNPOBox");
    	 
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
    public void updateCivicAddressTypeToGD() throws Exception {
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

    	 //do we need to set them to null for assertion tbd
    	 pojo.setAddressTypeCd(4);
    	 pojo.setPoBoxNbr(9090);
    	 pojo.setRuralIdentifierCd(2);
    	 pojo.setRouteName("SS0012");
    	 pojo.setSite(2);
    	 pojo.setCompartment(2);
    	 pojo.setConcession(2);
    	 pojo.setLot(2);
    	 pojo.setInstallationName("STNPOBox");
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
	public void updateRuralAddressToCivic() throws Exception {
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

    	 
    	 //do we need to set them to null for assertion tbd
    	 pojo.setAddressTypeCd(1);
    	 pojo.setStreetNbr(111);
    	 pojo.setStreetNbrSuffix("4");
    	 pojo.setStreetName("Spark");
    	 pojo.setStreetDirectionCd(2);
    	 pojo.setStreetTypeCd(2);
    	 pojo.setPoBoxNbr(9090);
    	 pojo.setRuralIdentifierCd(2);
    	 pojo.setRouteName("SS0012");
    	 pojo.setSite(2);
    	 pojo.setCompartment(2);
    	 pojo.setConcession(2);
    	 pojo.setLot(2);
    	 pojo.setEntireUnitRangeInd(true);
    	 pojo.setInstallationName("STNPOBox");
    	 
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
	public void updateRuralAddressToPOBox() throws Exception {
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

    	 
    	 //do we need to set them to null for assertion tbd
    	 pojo.setAddressTypeCd(3); 
    	 pojo.setPoBoxNbr(9090);
    	 pojo.setInstallationName("STNPOBox");
    	 pojo.setStreetNbr(111);
    	 pojo.setStreetNbrSuffix("4");
    	 pojo.setStreetName("Spark");
    	 pojo.setStreetDirectionCd(2);
    	 pojo.setStreetTypeCd(2);
    	 pojo.setRuralIdentifierCd(2);
    	 pojo.setRouteName("SS0012");
    	 pojo.setSite(2);
    	 pojo.setCompartment(2);
    	 pojo.setConcession(2);
    	 pojo.setLot(2);
    	 
    	 
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
	public void updateRuralAddressToGD() throws Exception {
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

    	 
    	 //do we need to set them to null for assertion tbd
    	 pojo.setAddressTypeCd(4);
    	 pojo.setInstallationName("STNPOBox");
    	 pojo.setPoBoxNbr(9090); 
    	 pojo.setStreetNbr(111);
    	 pojo.setStreetNbrSuffix("4");
    	 pojo.setStreetName("Spark");
    	 pojo.setStreetDirectionCd(2);
    	 pojo.setStreetTypeCd(2);
    	 pojo.setRuralIdentifierCd(2);
    	 pojo.setRouteName("SS0012");
    	 pojo.setSite(2);
    	 pojo.setCompartment(2);
    	 pojo.setConcession(2);
    	 pojo.setLot(2);
    	 
    	 
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
	public void updateGDAddressToCivic() throws Exception {
		
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
    	
    	System.out.println(jsonPayload.toJson(pojo));
		int recordID = Utility.queryAddressCreation(pojo);

    	 
    	 //do we need to set them to null for assertion tbd
    	 pojo.setAddressTypeCd(1);
    	 pojo.setStreetNbr(111);
    	 pojo.setStreetNbrSuffix("4");
    	 pojo.setStreetName("Spark");
    	 pojo.setStreetDirectionCd(2);
    	 pojo.setStreetTypeCd(2);
    	 pojo.setPoBoxNbr(9090);
    	 pojo.setRuralIdentifierCd(2);
    	 pojo.setRouteName("SS0012");
    	 pojo.setSite(2);
    	 pojo.setCompartment(2);
    	 pojo.setConcession(2);
    	 pojo.setLot(2);
    	 pojo.setEntireUnitRangeInd(true);
    	 pojo.setInstallationName("STNPOBox");
     	System.out.println(jsonPayload.toJson(pojo));

    	 String payload = jsonPayload.toJson(pojo);
 		 String resp= givenUpdateUnacceptableAd(recordID,payload)
     	.put()
     	.then()
     	.extract().asString();
    // 	.assertThat().statusCode(204);
      	System.out.println(resp);

    	try {
    		//Validate the record with assertions against DB
			Utility.queryUnacceptableAd(recordID, this::assertUnacceptableAdd, pojo);
			
			
		
		} finally {
			//Delete the record
			Utility.queryUnacceptableAdDelete(recordID);
		}   
    	
    }
	@Test
	public void updateGDAddressToRural() throws Exception {
		
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

    	 
    	//do we need to set them to null for assertion tbd
    	 pojo.setAddressTypeCd(2);
    	 pojo.setRuralIdentifierCd(2);
    	 pojo.setRouteName("SS0012");
    	 pojo.setSite(2);
    	 pojo.setCompartment(2);
    	 pojo.setConcession(2);
    	 pojo.setLot(2);
    	 pojo.setInstallationName("STNR");
    	 pojo.setPoBoxNbr(8989);
    	 pojo.setStreetNbr(111);
    	 pojo.setStreetNbrSuffix("4");
    	 pojo.setStreetName("Spark");
    	 pojo.setStreetDirectionCd(2);
    	 pojo.setStreetTypeCd(2);
    	 
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
	public void updateGDAddressToPOBox() throws Exception {
		
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

    	 
    	//do we need to set them to null for assertion tbd
    	 pojo.setAddressTypeCd(3);
    	 pojo.setPoBoxNbr(8989);
    	 pojo.setInstallationName("STNPB");
    	 pojo.setRuralIdentifierCd(2);
    	 pojo.setRouteName("SS0012");
    	 pojo.setSite(2);
    	 pojo.setCompartment(2);
    	 pojo.setConcession(2);
    	 pojo.setLot(2);
    	 pojo.setStreetNbr(111);
    	 pojo.setStreetNbrSuffix("4");
    	 pojo.setStreetName("Spark");
    	 pojo.setStreetDirectionCd(2);
    	 pojo.setStreetTypeCd(2);
    	 
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
public void updatePOBoxAddressToCivic() throws Exception {
		
		
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

    	 
    	 //do we need to set them to null for assertion tbd
    	 pojo.setAddressTypeCd(1);
    	 pojo.setStreetNbr(111);
    	 pojo.setStreetNbrSuffix("4");
    	 pojo.setStreetName("Spark");
    	 pojo.setStreetDirectionCd(2);
    	 pojo.setStreetTypeCd(2);
    	 pojo.setPoBoxNbr(9090);
    	 pojo.setRuralIdentifierCd(2);
    	 pojo.setRouteName("SS0012");
    	 pojo.setSite(2);
    	 pojo.setCompartment(2);
    	 pojo.setConcession(2);
    	 pojo.setLot(2);
    	 pojo.setInstallationName("STNPOBox");
    	 
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
public void updatePOBoxAddressToRural() throws Exception {
	
	
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

	 
	 //do we need to set them to null for assertion tbd
	 pojo.setAddressTypeCd(2);
	 pojo.setRuralIdentifierCd(2);
	 pojo.setRouteName("SS0012");
	 pojo.setSite(2);
	 pojo.setCompartment(2);
	 pojo.setConcession(2);
	 pojo.setLot(2);
	 pojo.setInstallationName("STNR");
	 pojo.setPoBoxNbr(8989);
	 pojo.setStreetNbr(111);
	 pojo.setStreetNbrSuffix("4");
	 pojo.setStreetName("Spark");
	 pojo.setStreetDirectionCd(2);
	 pojo.setStreetTypeCd(2);
	 pojo.setPoBoxNbr(9090);
	 
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
public void updatePOBoxAddressToGD() throws Exception {
	
	
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

	 
	//do we need to set them to null for assertion tbd
	 pojo.setAddressTypeCd(4);
	 pojo.setInstallationName("STNPOBox");
	 pojo.setPoBoxNbr(9090); 
	 pojo.setStreetNbr(111);
	 pojo.setStreetNbrSuffix("4");
	 pojo.setStreetName("Spark");
	 pojo.setStreetDirectionCd(2);
	 pojo.setStreetTypeCd(2);
	 pojo.setRuralIdentifierCd(2);
	 pojo.setRouteName("SS0012");
	 pojo.setSite(2);
	 pojo.setCompartment(2);
	 pojo.setConcession(2);
	 pojo.setLot(2);
	 
	 
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
}
