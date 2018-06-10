package com.restassured.getAll.GET;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.restassured.pojo.UnacceptableAddBuilder;
import com.restassured.pojo.UnacceptableAddPojo;
import com.restassured.util.Utility;

public class GetAllUnacceptableAddressTest extends AppTestBaseRest16 {
	
	@Test
    public void getAllCivicAddressMandatoryFields() throws Exception {
    
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
  
    	try {
    		try {
    			UnacceptableAddPojo[] resp = given().baseUri(BASE_URI)
    				   	.accept("application/json")
    				  	.auth().basic("userName", "pwd")
    				  	.when()
    				  	.get()
    				  	.then()
    				  	.assertThat().statusCode(200)
    				  	.extract().body().as(UnacceptableAddPojo[].class);
    			// Find the map of values in response corresponding to ID of record created 
				for (UnacceptableAddPojo add : resp) {
					if (Integer.valueOf(recordID).equals(add.getUnacceptableAddressId())) {
						Assert.assertEquals(add.getAddressTypeCd(), pojo.getAddressTypeCd());
						Assert.assertEquals(add.isEntirePostalCodeInd(), pojo.isEntirePostalCodeInd());
						Assert.assertEquals(add.getPostalCode(), pojo.getPostalCode().toUpperCase().replace('-', ' '));
						Assert.assertEquals(add.getProvinceCode(), pojo.getProvinceCode().toUpperCase());
						Assert.assertEquals(add.getMunicipality(), pojo.getMunicipality().toUpperCase());
						Assert.assertEquals(add.getStreetNbr(), pojo.getStreetNbr());
						Assert.assertEquals(add.getStreetName(), pojo.getStreetName().toUpperCase());
						Assert.assertEquals(add.getNotes(), pojo.getNotes().toUpperCase());
						break;
					}
				}
				
    		} finally {
    			Utility.queryUnacceptableAdIDCheck(recordID, 1);
    		}
		} finally {
			//Delete the record manually if the assertion fails
			Utility.queryUnacceptableAdDelete(recordID);
		}
    }

	@Test
	public void getAllCivicAddressApplicableFieldsAll() throws Exception {
	
        String postalcd = Utility.generateUnacceptableAddPostalCd();

		// Change pojo to be unique
		final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
				.addresstypecode(1)
				.entirepostalcodeInd(false)
				.postalcode(postalcd)
				.provincecode("BC")
				.municipalityname("Stlaurent")
				.streetnbr(888)
				.streetname("MajorMckenzie")
				.StreetNbrSuffix("4")
				.StreetTypeCd(11)
				.StreetDirectionCd(5)
				.EntireUnitRangeInd(true)
				.note("this is Civic Hospital")
				.build();
		
		int recordID= Utility.queryAddressCreation(pojo);
	    
    	try {
    		try {
			   	 
			   	UnacceptableAddPojo[] resp = given().baseUri(BASE_URI)
			   	.accept("application/json")
			  	.auth().basic("userName", "pwd")
			  	.when()
			  	.get()
			  	.then()
			  	.assertThat().statusCode(200)
			  	.extract().body().as(UnacceptableAddPojo[].class);
			   	 
				// Find the map of values in response corresponding to ID of record created 
				for (UnacceptableAddPojo add : resp) {
					if (Integer.valueOf(recordID).equals(add.getUnacceptableAddressId())) {
						Assert.assertEquals(add.getAddressTypeCd(), pojo.getAddressTypeCd());
						Assert.assertEquals(add.isEntirePostalCodeInd(), pojo.isEntirePostalCodeInd());
						Assert.assertEquals(add.getPostalCode(), pojo.getPostalCode().toUpperCase().replace('-', ' '));
						Assert.assertEquals(add.getProvinceCode(), pojo.getProvinceCode().toUpperCase());
						Assert.assertEquals(add.getMunicipality(), pojo.getMunicipality().toUpperCase());
						Assert.assertEquals(add.getStreetNbr(), pojo.getStreetNbr());
						Assert.assertEquals(add.getStreetName(), pojo.getStreetName().toUpperCase());
						Assert.assertEquals(add.getStreetNbrSuffix(), pojo.getStreetNbrSuffix().toUpperCase());
						Assert.assertEquals(add.getStreetTypeCd(), pojo.getStreetTypeCd());
						Assert.assertEquals(add.getStreetDirectionCd(), pojo.getStreetDirectionCd());
						Assert.assertEquals(add.isEntireUnitRangeInd(), pojo.isEntireUnitRangeInd());
						Assert.assertEquals(add.getNotes(), pojo.getNotes().toUpperCase());
						break;
					}
				}
			
    		} finally {
    			Utility.queryUnacceptableAdIDCheck(recordID, 1);
    		}
		} finally {
			//Delete the record manually if the assertion fails
			Utility.queryUnacceptableAdDelete(recordID);
		}
	}

	
	@Test
    public void getAllCivicAddressApplicableFieldsSingle() throws Exception {
    	
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(1)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("BC")
    			.municipalityname("HomeRoad")
    			.streetnbr(1945)
    			.streetname("Pole")
    			.StreetNbrSuffix("4")
    			.StreetTypeCd(11)
    			.StreetDirectionCd(5)
    			.EntireUnitRangeInd(false)
    			.UnitNbr("10")
    			.note("this is hospistal")
    			.build();
		int recordID= Utility.queryAddressCreation(pojo);

     	try {
     		try {
     		 	UnacceptableAddPojo[] resp = given().baseUri(BASE_URI)
     				   	.accept("application/json")
     				  	.auth().basic("userName", "pwd")
     				  	.when()
     				  	.get()
     				  	.then()
     				  	.assertThat().statusCode(200)
     				  	.extract().body().as(UnacceptableAddPojo[].class);
     		// Find the map of values in response corresponding to ID of record created 
				for (UnacceptableAddPojo add : resp) {
					if (Integer.valueOf(recordID).equals(add.getUnacceptableAddressId())) {
						Assert.assertEquals(add.getAddressTypeCd(), pojo.getAddressTypeCd());
						Assert.assertEquals(add.isEntirePostalCodeInd(), pojo.isEntirePostalCodeInd());
						Assert.assertEquals(add.getPostalCode(), pojo.getPostalCode().toUpperCase().replace('-', ' '));
						Assert.assertEquals(add.getProvinceCode(), pojo.getProvinceCode().toUpperCase());
						Assert.assertEquals(add.getMunicipality(), pojo.getMunicipality().toUpperCase());
						Assert.assertEquals(add.getStreetNbr(), pojo.getStreetNbr());
						Assert.assertEquals(add.getStreetName(), pojo.getStreetName().toUpperCase());
						Assert.assertEquals(add.getStreetNbrSuffix(), pojo.getStreetNbrSuffix().toUpperCase());
						Assert.assertEquals(add.getStreetTypeCd(), pojo.getStreetTypeCd());
						Assert.assertEquals(add.getStreetDirectionCd(), pojo.getStreetDirectionCd());
						Assert.assertEquals(add.isEntireUnitRangeInd(), pojo.isEntireUnitRangeInd());
						Assert.assertEquals(add.getNotes(), pojo.getNotes().toUpperCase());
	 					Assert.assertEquals(add.getUnitNbr(), pojo.getUnitNbr().toUpperCase());

						break;
					}
				}
 				
 				
     		} finally {
     			Utility.queryUnacceptableAdIDCheck(recordID, 1);
     		}
 		} finally {
 			//Delete the record manually if the assertion fails
 			Utility.queryUnacceptableAdDelete(recordID);
 		}

    	
    }
	@Test
    public void getAllCivicAddressApplicableFieldsRange() throws Exception {
    	
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
      	try {
      		try {
      		  	UnacceptableAddPojo[] resp = given().baseUri(BASE_URI)
      				   	.accept("application/json")
      				  	.auth().basic("userName", "pwd")
      				  	.when()
      				  	.get()
      				  	.then()
      				  	.assertThat().statusCode(200)
      				  	.extract().body().as(UnacceptableAddPojo[].class);
  			   	 
      		// Find the map of values in response corresponding to ID of record created 
				for (UnacceptableAddPojo add : resp) {
					if (Integer.valueOf(recordID).equals(add.getUnacceptableAddressId())) {
						Assert.assertEquals(add.getAddressTypeCd(), pojo.getAddressTypeCd());
						Assert.assertEquals(add.isEntirePostalCodeInd(), pojo.isEntirePostalCodeInd());
						Assert.assertEquals(add.getPostalCode(), pojo.getPostalCode().toUpperCase().replace('-', ' '));
						Assert.assertEquals(add.getProvinceCode(), pojo.getProvinceCode().toUpperCase());
						Assert.assertEquals(add.getMunicipality(), pojo.getMunicipality().toUpperCase());
						Assert.assertEquals(add.getStreetNbr(), pojo.getStreetNbr());
						Assert.assertEquals(add.getStreetName(), pojo.getStreetName().toUpperCase());
						Assert.assertEquals(add.getStreetNbrSuffix(), pojo.getStreetNbrSuffix().toUpperCase());
						Assert.assertEquals(add.getStreetTypeCd(), pojo.getStreetTypeCd());
						Assert.assertEquals(add.getStreetDirectionCd(), pojo.getStreetDirectionCd());
						Assert.assertEquals(add.isEntireUnitRangeInd(), pojo.isEntireUnitRangeInd());
						Assert.assertEquals(add.getNotes(), pojo.getNotes().toUpperCase());
						Assert.assertEquals(add.getUnitNbr(), pojo.getUnitNbr().toUpperCase());
	  					Assert.assertEquals(add.getToUnitNbr(), pojo.getToUnitNbr().toUpperCase());

						break;
					}
				}
  				
  				
  				
      		} finally {
      			Utility.queryUnacceptableAdIDCheck(recordID, 1);
      		}
  		} finally {
  			//Delete the record manually if the assertion fails
  			Utility.queryUnacceptableAdDelete(recordID);
  		}

    	
    }
	@Test
	public void getAllRuralAddressMandatoryFields() throws Exception {
    
 
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
       	try {
       		try {
       			UnacceptableAddPojo[] resp = given().baseUri(BASE_URI)
      				   	.accept("application/json")
      				  	.auth().basic("userName", "pwd")
      				  	.when()
      				  	.get()
      				  	.then()
      				  	.assertThat().statusCode(200)
      				  	.extract().body().as(UnacceptableAddPojo[].class);
       			// Find the map of values in response corresponding to ID of record created 
				for (UnacceptableAddPojo add : resp) {
					if (Integer.valueOf(recordID).equals(add.getUnacceptableAddressId())) {
						Assert.assertEquals(add.getAddressTypeCd(), pojo.getAddressTypeCd());
						Assert.assertEquals(add.isEntirePostalCodeInd(), pojo.isEntirePostalCodeInd());
						Assert.assertEquals(add.getPostalCode(), pojo.getPostalCode().toUpperCase().replace('-', ' '));
						Assert.assertEquals(add.getProvinceCode(), pojo.getProvinceCode().toUpperCase());
						Assert.assertEquals(add.getMunicipality(), pojo.getMunicipality().toUpperCase());
						Assert.assertEquals(add.isEntireUnitRangeInd(), pojo.isEntireUnitRangeInd());
						Assert.assertEquals(add.getNotes(), pojo.getNotes().toUpperCase());
						Assert.assertEquals(add.getRouteName(), pojo.getRouteName().toUpperCase());
    					Assert.assertEquals(add.getRuralIdentifierCd(), pojo.getRuralIdentifierCd());
						break;
					}
				}
       		} finally {
       			Utility.queryUnacceptableAdIDCheck(recordID, 1);
       		}
   		} finally {
   			//Delete the record manually if the assertion fails
   			Utility.queryUnacceptableAdDelete(recordID);
   		}

    	
    }
	@Test
	public void getAllRuralAddressApplicableFields() throws Exception {
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
        	try {
        		try {
        			UnacceptableAddPojo[] resp = given().baseUri(BASE_URI)
          				   	.accept("application/json")
          				  	.auth().basic("userName", "pwd")
          				  	.when()
          				  	.get()
          				  	.then()
          				  	.assertThat().statusCode(200)
          				  	.extract().body().as(UnacceptableAddPojo[].class);
    			   	 
        			// Find the map of values in response corresponding to ID of record created 
    				for (UnacceptableAddPojo add : resp) {
    					if (Integer.valueOf(recordID).equals(add.getUnacceptableAddressId())) {
    						Assert.assertEquals(add.getAddressTypeCd(), pojo.getAddressTypeCd());
    						Assert.assertEquals(add.isEntirePostalCodeInd(), pojo.isEntirePostalCodeInd());
    						Assert.assertEquals(add.getPostalCode(), pojo.getPostalCode().toUpperCase().replace('-', ' '));
    						Assert.assertEquals(add.getProvinceCode(), pojo.getProvinceCode().toUpperCase());
    						Assert.assertEquals(add.getMunicipality(), pojo.getMunicipality().toUpperCase());
    						Assert.assertEquals(add.isEntireUnitRangeInd(), pojo.isEntireUnitRangeInd());
    						Assert.assertEquals(add.getNotes(), pojo.getNotes().toUpperCase());
    						Assert.assertEquals(add.getRouteName(), pojo.getRouteName().toUpperCase());
        					Assert.assertEquals(add.getRuralIdentifierCd(), pojo.getRuralIdentifierCd());
        					Assert.assertEquals(add.getSite(), pojo.getSite());
        					Assert.assertEquals(add.getCompartment(), pojo.getCompartment());
        					Assert.assertEquals(add.getLot(), pojo.getLot());
        					Assert.assertEquals(add.getConcession(), pojo.getConcession());
    						Assert.assertEquals(add.getInstallationName(), pojo.getInstallationName().toUpperCase());
    						break;
    					}
    				}
        		} finally {
        			Utility.queryUnacceptableAdIDCheck(recordID, 1);
        		}
    		} finally {
    			//Delete the record manually if the assertion fails
    			Utility.queryUnacceptableAdDelete(recordID);
    		}

    	
    }
	@Test
    public void getAllPOBoxAddressMandatoryFields() throws Exception {
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(3)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("NL")
    			.municipalityname("Brampton")
    			.PoBoxNbr(1909)
    			.note("this is PoBox")
    			.build();
    	int recordID= Utility.queryAddressCreation(pojo);
     	try {
     		try {
     			UnacceptableAddPojo[] resp = given().baseUri(BASE_URI)
      				   	.accept("application/json")
      				  	.auth().basic("userName", "pwd")
      				  	.when()
      				  	.get()
      				  	.then()
      				  	.assertThat().statusCode(200)
      				  	.extract().body().as(UnacceptableAddPojo[].class);
     			for (UnacceptableAddPojo add : resp) {
					if (Integer.valueOf(recordID).equals(add.getUnacceptableAddressId())) {
						Assert.assertEquals(add.getAddressTypeCd(), pojo.getAddressTypeCd());
						Assert.assertEquals(add.isEntirePostalCodeInd(), pojo.isEntirePostalCodeInd());
						Assert.assertEquals(add.getPostalCode(), pojo.getPostalCode().toUpperCase().replace('-', ' '));
						Assert.assertEquals(add.getProvinceCode(), pojo.getProvinceCode().toUpperCase());
						Assert.assertEquals(add.getMunicipality(), pojo.getMunicipality().toUpperCase());
						Assert.assertEquals(add.isEntireUnitRangeInd(), pojo.isEntireUnitRangeInd());
						Assert.assertEquals(add.getNotes(), pojo.getNotes().toUpperCase());
	  					Assert.assertEquals(add.getPoBoxNbr(), pojo.getPoBoxNbr());
						break;
					}
				}
  				
     			
     		} finally {
     			Utility.queryUnacceptableAdIDCheck(recordID, 1);
     		}
 		} finally {
 			//Delete the record manually if the assertion fails
 			Utility.queryUnacceptableAdDelete(recordID);
 		}
    	
    }
	@Test
	public void getAllPOBoxAddressApplicableFields() throws Exception {
		
        String postalcd = Utility.generateUnacceptableAddPostalCd();

    	final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(3)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("BC")
    			.municipalityname("Mississpi")
    			.PoBoxNbr(8090)
    			.InstallationName("STNPOB")
    			.note("this is pobox")
    			.build();
    	
    	int recordID= Utility.queryAddressCreation(pojo);
      	try {
      		try {
      		 	UnacceptableAddPojo[] resp = given().baseUri(BASE_URI)
      				   	.accept("application/json")
      				  	.auth().basic("userName", "pwd")
      				  	.when()
      				  	.get()
      				  	.then()
      				  	.assertThat().statusCode(200)
      				  	.extract().body().as(UnacceptableAddPojo[].class);
      		// Find the map of values in response corresponding to ID of record created 
				for (UnacceptableAddPojo add : resp) {
					if (Integer.valueOf(recordID).equals(add.getUnacceptableAddressId())) {
						Assert.assertEquals(add.getAddressTypeCd(), pojo.getAddressTypeCd());
						Assert.assertEquals(add.isEntirePostalCodeInd(), pojo.isEntirePostalCodeInd());
						Assert.assertEquals(add.getPostalCode(), pojo.getPostalCode().toUpperCase().replace('-', ' '));
						Assert.assertEquals(add.getProvinceCode(), pojo.getProvinceCode().toUpperCase());
						Assert.assertEquals(add.getMunicipality(), pojo.getMunicipality().toUpperCase());
						Assert.assertEquals(add.isEntireUnitRangeInd(), pojo.isEntireUnitRangeInd());
						Assert.assertEquals(add.getNotes(), pojo.getNotes().toUpperCase());
	  					Assert.assertEquals(add.getPoBoxNbr(), pojo.getPoBoxNbr());
						Assert.assertEquals(add.getInstallationName(), pojo.getInstallationName().toUpperCase());
						break;
					}
				}
  				
      		} finally {
      			Utility.queryUnacceptableAdIDCheck(recordID, 1);
      		}
  		} finally {
  			//Delete the record manually if the assertion fails
  			Utility.queryUnacceptableAdDelete(recordID);
  		}
    	
    }
}
