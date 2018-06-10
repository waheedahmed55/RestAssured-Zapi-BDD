package com.restassured.delete.DELETE;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import com.restassured.pojo.UnacceptableAddBuilder;
import com.restassured.pojo.UnacceptableAddPojo;
import com.restassured.util.Utility;

public class DeleteAddressMandatoryFields extends AppTestBaseRest19 {

	@Test
    public void deleteCivicAddressMandatoryFields() throws Exception {
    
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(1)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("NL")
    			.municipalityname("Popcorn")
    			.streetnbr(562)
    			.streetname("Castors")
    			.note("this is Civic Address")
    			.build();
    	
    	int recordID= Utility.queryAddressCreation(pojo);
    System.out.println(recordID);
    
    	try {
    		try {
			   	 given().baseUri(BASE_URI+"/"+recordID)
			  	.auth().basic("userName", "pwd")
			  	.when()
			  	.delete()
			  	.then()
			  	.assertThat().statusCode(204);
    		} finally {
    			Utility.queryUnacceptableAdIDCheck(recordID, 0);
    		}
		} catch (Exception e) {
			//Delete the record manually if the assertion fails
			Utility.queryUnacceptableAdDelete(recordID);
		}

    	
    }
	@Test
    public void deleteCivicAddressApplicableFieldsAll() throws Exception {
 
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(1)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("BC")
    			.municipalityname("Lauren")
    			.streetnbr(888)
    			.streetname("StLaurent")
    			.StreetNbrSuffix("4")
    			.StreetTypeCd(11)
    			.StreetDirectionCd(5)
    			.EntireUnitRangeInd(true)
    			.note("this is Civic Hospital")
    			.build();
    	
    	int recordID= Utility.queryAddressCreation(pojo);
        System.out.println(recordID);
        
        	try {
        		try {
    			   	 given().baseUri(BASE_URI+"/"+recordID)
    			  	.auth().basic("userName", "pwd")
    			  	.when()
    			  	.delete()
    			  	.then()
    			  	.assertThat().statusCode(204);
        		} finally {
        			Utility.queryUnacceptableAdIDCheck(recordID, 0);
        		}
    		} catch (Exception e) {
    			//Delete the record manually if the assertion fails
    			Utility.queryUnacceptableAdDelete(recordID);
    		}

    	
    }
	@Test
    public void deleteCivicAddressApplicableFieldsRange() throws Exception {
    	
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
    	
    	int recordID= Utility.queryAddressCreation(pojo);
        System.out.println(recordID);
        
        	try {
        		try {
    			   	 given().baseUri(BASE_URI+"/"+recordID)
    			  	.auth().basic("userName", "pwd")
    			  	.when()
    			  	.delete()
    			  	.then()
    			  	.assertThat().statusCode(204);
        		} finally {
        			Utility.queryUnacceptableAdIDCheck(recordID, 0);
        		}
    		} catch (Exception e) {
    			//Delete the record manually if the assertion fails
    			Utility.queryUnacceptableAdDelete(recordID);
    		}

    	
    }
	@Test
    public void deleteCivicAddressApplicableFieldsSingle() throws Exception {
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
    	
    	int recordID= Utility.queryAddressCreation(pojo);
        System.out.println(recordID);
        
        	try {
        		try {
    			   	 given().baseUri(BASE_URI+"/"+recordID)
    			  	.auth().basic("userName", "pwd")
    			  	.when()
    			  	.delete()
    			  	.then()
    			  	.assertThat().statusCode(204);
        		} finally {
        			Utility.queryUnacceptableAdIDCheck(recordID, 0);
        		}
    		} catch (Exception e) {
    			//Delete the record manually if the assertion fails
    			Utility.queryUnacceptableAdDelete(recordID);
    		}

    	
    }
	@Test
	public void deleteRuralAddressMandatoryFields() throws Exception {
    
 
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
    	
    	int recordID= Utility.queryAddressCreation(pojo);
        System.out.println(recordID);
        
        	try {
        		try {
    			   	 given().baseUri(BASE_URI+"/"+recordID)
    			  	.auth().basic("userName", "pwd")
    			  	.when()
    			  	.delete()
    			  	.then()
    			  	.assertThat().statusCode(204);
        		} finally {
        			Utility.queryUnacceptableAdIDCheck(recordID, 0);
        		}
    		} catch (Exception e) {
    			//Delete the record manually if the assertion fails
    			Utility.queryUnacceptableAdDelete(recordID);
    		}

    	
    }
	@Test
	public void deleteRuralAddressApplicableFields() throws Exception {
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
    	
    	int recordID= Utility.queryAddressCreation(pojo);
        System.out.println(recordID);
        
        	try {
        		try {
    			   	 given().baseUri(BASE_URI+"/"+recordID)
    			  	.auth().basic("userName", "pwd")
    			  	.when()
    			  	.delete()
    			  	.then()
    			  	.assertThat().statusCode(204);
        		} finally {
        			Utility.queryUnacceptableAdIDCheck(recordID, 0);
        		}
    		} catch (Exception e) {
    			//Delete the record manually if the assertion fails
    			Utility.queryUnacceptableAdDelete(recordID);
    		}
    	
    }
	@Test
    public void deletePOBoxAddressMandatoryFields() throws Exception {
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(3)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("AB")
    			.municipalityname("Locksmith")
    			.PoBoxNbr(1943)
    			.note("this is PoBox")
    			.build();
    	int recordID= Utility.queryAddressCreation(pojo);
        System.out.println(recordID);
        
        	try {
        		try {
    			   	 given().baseUri(BASE_URI+"/"+recordID)
    			  	.auth().basic("userName", "pwd")
    			  	.when()
    			  	.delete()
    			  	.then()
    			  	.assertThat().statusCode(204);
        		} finally {
        			Utility.queryUnacceptableAdIDCheck(recordID, 0);
        		}
    		} catch (Exception e) {
    			//Delete the record manually if the assertion fails
    			Utility.queryUnacceptableAdDelete(recordID);
    		}
    	
    }
	@Test
	public void deletePOBoxAddressApplicableFields() throws Exception {
		
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
    	
    	int recordID= Utility.queryAddressCreation(pojo);
        System.out.println(recordID);
        
        	try {
        		try {
    			   	 given().baseUri(BASE_URI+"/"+recordID)
    			  	.auth().basic("userName", "pwd")
    			  	.when()
    			  	.delete()
    			  	.then()
    			  	.assertThat().statusCode(204);
        		} finally {
        			Utility.queryUnacceptableAdIDCheck(recordID, 0);
        		}
    		} catch (Exception e) {
    			//Delete the record manually if the assertion fails
    			Utility.queryUnacceptableAdDelete(recordID);
    		}
    	
    }
	@Test
    public void deleteGDAddressMandatoryFields() throws Exception {
		String postalcd = Utility.generateUnacceptableAddPostalCd();
    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(4)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("ON")
    			.municipalityname("Scarborough")
    			.InstallationName("STNHJ")
    			.note("this is GD1")
    			.build();
    	
    	int recordID= Utility.queryAddressCreation(pojo);
        System.out.println(recordID);
        
        	try {
        		try {
    			   	 given().baseUri(BASE_URI+"/"+recordID)
    			  	.auth().basic("userName", "pwd")
    			  	.when()
    			  	.delete()
    			  	.then()
    			  	.assertThat().statusCode(204);
        		} finally {
        			Utility.queryUnacceptableAdIDCheck(recordID, 0);
        		}
    		} catch (Exception e) {
    			//Delete the record manually if the assertion fails
    			Utility.queryUnacceptableAdDelete(recordID);
    		}
    	
    }
	@Test
	public void deleteGDAddressApplicableFields() throws Exception {
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
    	
    	int recordID= Utility.queryAddressCreation(pojo);
        System.out.println(recordID);
        
        	try {
        		try {
    			   	 given().baseUri(BASE_URI+"/"+recordID)
    			  	.auth().basic("userName", "pwd")
    			  	.when()
    			  	.delete()
    			  	.then()
    			  	.assertThat().statusCode(204);
        		} finally {
        			Utility.queryUnacceptableAdIDCheck(recordID, 0);
        		}
    		} catch (Exception e) {
    			//Delete the record manually if the assertion fails
    			Utility.queryUnacceptableAdDelete(recordID);
    		}
    	
    }
}
