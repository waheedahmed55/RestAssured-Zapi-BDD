package com.restassured.util;


import static com.restassured.common.EndpointConstants.MEDIA_TYPE;
import static com.restassured.common.EndpointConstants.PASSWORD;
import static com.restassured.common.EndpointConstants.USERNAME;
import static io.restassured.RestAssured.given;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

import com.restassured.common.CommonAdd;
import com.restassured.pojo.UnacceptableAddPojo;

import io.restassured.specification.RequestSpecification;

public class AppTestBase {
	
	protected String BASE_URI = "http://localhost:8080/userName/unacceptableaddress";
	protected String BASE_URI2 = "http://localhost:8080/userName/validateunacceptableaddress";

	protected static String adID;
	protected static String adID1;
	protected static int result;
	protected static int result1;
	protected Integer addressTypeCd=null ;
	protected boolean entirePostalCodeInd;
	protected String postalCode= null ;
	protected String provinceCode= null;
	protected String municipality= null;
	protected Integer streetNbr= null;
	protected String streetNbrSuffix= null;
	protected String streetName= null;
	protected Integer streetTypeCd= null;
	protected Integer streetDirectionCd= null;
	protected String poBoxNbr=null;
	protected Integer ruralIdentifierCd=null;
	protected String routeName=null;
	protected Boolean entireUnitRangeInd=null;
	protected String unitNbr=null;
	protected String toUnitNbr=null;
	protected Integer site=null;
	protected Integer compartment=null;
	protected Integer lot=null;
	protected Integer concession=null;
	protected String installationName=null;
	protected String notes= "";
	protected ArrayList<Integer> adIDsTodelete = new ArrayList<>();
	
	protected final static Pattern NUMERIC_PATTERN = Pattern.compile("^[0-9]+$");
	
	@AfterClass
	public void deleteRecords() {
		
		for(Integer i : adIDsTodelete ) {
			Utility.queryUnacceptableAdDelete(i);
		}
		adIDsTodelete.clear();
	}

	protected void assertUnacceptableAdd(ResultSet rs, Object o) throws Exception {
		UnacceptableAddPojo pojo = (UnacceptableAddPojo)o;
		
		if(pojo.isEntirePostalCodeInd())
		{
			Assert.assertEquals(rs.getString("POSTAL_CODE"),pojo.getPostalCode().toUpperCase().replace('-', ' '));
			Assert.assertEquals(rs.getString("NOTES"),pojo.getNotes().toUpperCase());
	    	Assert.assertEquals(rs.getBoolean("ENTIRE_POSTAL_CODE_IND"),pojo.isEntirePostalCodeInd());
	    	Assert.assertEquals(rs.getInt("ADDRESS_TYPE_VLU_ID"),0);
	    	Assert.assertEquals(rs.getInt("STREET_NBR"),0);
	    	Assert.assertNull(rs.getString("STREET_NAME"));
	    	Assert.assertNull(rs.getString("MUNICIPALITY_NAME"));
	    	Assert.assertNull(rs.getString("PROVINCE_CD"));
	    	Assert.assertNull(rs.getString("STREET_NBR_SUFFIX"));
	    	Assert.assertEquals(rs.getInt("STREET_TYPE_VLU_ID"),0);
	    	Assert.assertEquals(rs.getInt("STREET_DIRECTION_VLU_ID"),0);
	    	Assert.assertNull(rs.getString("UNIT_NBR"));
	    	Assert.assertNull(rs.getString("TO_UNIT_NBR"));
	    	Assert.assertNull(rs.getString("ROUTE_NAME"));
	    	Assert.assertEquals(rs.getInt("RURAL_IDENTIFIER_VLU_ID"),0);
	    	Assert.assertEquals(rs.getInt("SITE_ID"),0);
	    	Assert.assertEquals(rs.getInt("COMPARTMENT"),0);
	    	Assert.assertEquals(rs.getInt("CONCESSION"),0);
	    	Assert.assertEquals(rs.getInt("LOT"),0);
	    	Assert.assertNull(rs.getString("INSTALLATION_NAME"));
	    	Assert.assertNull(rs.getString("PO_BOX_NBR"));
	    	Assert.assertFalse(rs.getBoolean("ENTIRE_UNIT_RANGE_IND"));
	
	    	return;
		}
		
		Assert.assertEquals(rs.getInt("ADDRESS_TYPE_VLU_ID"), pojo.getAddressTypeCd().intValue());
		Assert.assertEquals(rs.getString("POSTAL_CODE"),pojo.getPostalCode().toUpperCase().replace('-', ' '));
		Assert.assertEquals(rs.getString("NOTES"),pojo.getNotes().toUpperCase());
		Assert.assertEquals(rs.getBoolean("ENTIRE_POSTAL_CODE_IND"),pojo.isEntirePostalCodeInd());
		switch (pojo.getAddressTypeCd()) {
	    case CommonAdd.CIVIC:
	    	
	        	Assert.assertEquals(rs.getInt("RURAL_IDENTIFIER_VLU_ID"), 0);
	        	Assert.assertNull(rs.getString("ROUTE_NAME"));
	        	Assert.assertEquals(rs.getInt("SITE_ID"),0);
	        	Assert.assertEquals(rs.getInt("COMPARTMENT"),0);
	        	Assert.assertEquals(rs.getInt("CONCESSION"),0);
	        	Assert.assertEquals(rs.getInt("LOT"),0);
	        	Assert.assertNull(rs.getString("INSTALLATION_NAME"));
	        	
	        if (pojo.getStreetNbr() != null) {
	           
	        	Assert.assertEquals(rs.getInt("STREET_NBR"),pojo.getStreetNbr().intValue());
	
	        }else{
	        	throw new Exception ("303 Street number required");
	        }
	        	
	        
	        if (pojo.getStreetName() != null) {
	            Assert.assertEquals(rs.getString("STREET_NAME"),pojo.getStreetName().toUpperCase());
	        }else {
	        	throw new Exception ("304 Street name required");
	        	}
	        
	        if (pojo.getMunicipality() != null) {
	           
	            Assert.assertEquals(rs.getString("MUNICIPALITY_NAME"),pojo.getMunicipality().toUpperCase());
	        }else
	        {
	        	throw new Exception ("307 Municipality required");
	        }
	        if (pojo.getProvinceCode() != null) {
	        	Assert.assertEquals(rs.getString("PROVINCE_CD"),pojo.getProvinceCode().toUpperCase());
	        }else
	        {
	        	throw new Exception ("308 Province required");
	        }
	        if(pojo.getStreetNbrSuffix()!=null)
	        {
	        	Assert.assertEquals(rs.getString("STREET_NBR_SUFFIX"), pojo.getStreetNbrSuffix().toUpperCase());
	        }else {
	        	Assert.assertNull(rs.getString("STREET_NBR_SUFFIX"));

	        }
	        if(pojo.getStreetTypeCd()!=null)
	        {
	        	Assert.assertEquals(rs.getInt("STREET_TYPE_VLU_ID"), pojo.getStreetTypeCd().intValue());
	        }else {
	        	Assert.assertEquals(rs.getInt("STREET_TYPE_VLU_ID"), 0);
	        }
	        if(pojo.getStreetDirectionCd()!=null)
	        {
	        	Assert.assertEquals(rs.getInt("STREET_DIRECTION_VLU_ID"), pojo.getStreetDirectionCd().intValue());
	        }else {
	        	Assert.assertEquals(rs.getInt("STREET_DIRECTION_VLU_ID"), 0);
	        }
	        
	        //All isEntireUnitRangeInd=true
	        if(pojo.isEntireUnitRangeInd())
	        {
	        	Assert.assertNull(rs.getString("TO_UNIT_NBR"));            	
	        	Assert.assertNull(rs.getString("UNIT_NBR"));
	        	return;
	        }
	        //Single isEntireUnitRangeInd=false
	        if(pojo.getUnitNbr()!=null && !(pojo.isEntireUnitRangeInd()) && (pojo.getToUnitNbr()==null)) {
	        	Assert.assertEquals(rs.getString("UNIT_NBR"),pojo.getUnitNbr().toUpperCase());
	        	Assert.assertNull(rs.getString("TO_UNIT_NBR"));
	        }
	
	        if (pojo.getUnitNbr() == null && pojo.getToUnitNbr() != null) {
	            throw new Exception ("301 Range unacceptable");
	        }
	        //Range isEntireUnitRangeInd=false
	        if (pojo.getUnitNbr() != null && pojo.getToUnitNbr() != null) {
	        	if (!NUMERIC_PATTERN.matcher(pojo.getUnitNbr()).matches() || !NUMERIC_PATTERN.matcher(pojo.getToUnitNbr()).matches()) {
	                throw new Exception ("312 The From and To unit values have incompatible formats");
	            }
	        	Integer unitNbr = Integer.parseInt(pojo.getUnitNbr());
	        	Integer toUnitNbr = Integer.parseInt(pojo.getToUnitNbr());
	        	if (unitNbr > toUnitNbr) {
	        		Integer tmp = unitNbr;
	        		unitNbr = toUnitNbr;
	        		toUnitNbr = tmp;
	        	}
	        	Assert.assertEquals(rs.getString("TO_UNIT_NBR"),toUnitNbr.toString().toUpperCase());
	        	Assert.assertEquals(rs.getString("UNIT_NBR"),unitNbr.toString().toUpperCase());
	            if (pojo.getUnitNbr().equals(pojo.getToUnitNbr())) {
	                throw new Exception ("311 Values entered for the From and To unit are the same");
	            }
	        }
	       

	       
	        break;
	    case CommonAdd.RURAL:
	        if (pojo.getRouteName() == null) {
	            throw new Exception("305 Route name required");
	        }else {
	        	Assert.assertEquals(rs.getString("ROUTE_NAME"), pojo.getRouteName().toUpperCase());
	        }
	        if (pojo.getRuralIdentifierCd() == null) {
	            throw new Exception ("306 Rural identifier required");
	        }else
	        {
	        	Assert.assertEquals(rs.getInt("RURAL_IDENTIFIER_VLU_ID"), pojo.getRuralIdentifierCd().intValue());
	
	        }
	        if (pojo.getMunicipality() == null) {
	          throw new Exception ("307 Municipality required");
	        }else
	        {
	            Assert.assertEquals(rs.getString("MUNICIPALITY_NAME"),pojo.getMunicipality().toUpperCase());
	
	        }
	        if (pojo.getProvinceCode() != null) {
	        	Assert.assertEquals(rs.getString("PROVINCE_CD"),pojo.getProvinceCode().toUpperCase());
	        }else
	        {
	        	throw new Exception ("308 Province required");
	        }
	       
	        if(pojo.getSite()!=null)
	        {
	        	Assert.assertEquals(rs.getInt("SITE_ID"),pojo.getSite().intValue());
	
	        }else {
	        	Assert.assertEquals(rs.getInt("SITE_ID"),0);

	        }
	        if(pojo.getCompartment()!=null)
	        {
	        	Assert.assertEquals(rs.getInt("COMPARTMENT"),pojo.getCompartment().intValue());
	
	        }else {
	        	Assert.assertEquals(rs.getInt("COMPARTMENT"),0);

	        }
	        if(pojo.getConcession()!=null)
	        {
	        	Assert.assertEquals(rs.getInt("CONCESSION"),pojo.getConcession().intValue());
	
	        }else {
	        	Assert.assertEquals(rs.getInt("CONCESSION"),0);
	        }
	        if(pojo.getLot()!=null)
	        {
	        	Assert.assertEquals(rs.getInt("LOT"),pojo.getLot().intValue());
	
	        }else {
	        	Assert.assertEquals(rs.getInt("LOT"),0);

	        }
	        if(pojo.getInstallationName()!=null)
	        {
	        	Assert.assertEquals(rs.getString("INSTALLATION_NAME"),pojo.getInstallationName().toUpperCase());
	
	        }else {
	        	Assert.assertNull(rs.getString("INSTALLATION_NAME"));

	        }
	     
        	Assert.assertEquals(rs.getInt("STREET_NBR"),0);
        	Assert.assertNull(rs.getString("STREET_NBR_SUFFIX"));
            Assert.assertNull(rs.getString("STREET_NAME"));
        	Assert.assertEquals(rs.getInt("STREET_TYPE_VLU_ID"), 0);
        	Assert.assertEquals(rs.getInt("STREET_DIRECTION_VLU_ID"), 0);
        	Assert.assertNull(rs.getString("TO_UNIT_NBR"));            	
        	Assert.assertNull(rs.getString("UNIT_NBR"));
        	Assert.assertNull(rs.getString("PO_BOX_NBR"));
	    	Assert.assertFalse(rs.getBoolean("ENTIRE_UNIT_RANGE_IND"));


	        break;
	    case CommonAdd.POBOX:
	        if (pojo.getPoBoxNbr() == null) {
	            throw new Exception ("309 PO box required");
	        }else
	        {
	        	Assert.assertEquals(rs.getInt("PO_BOX_NBR"),pojo.getPoBoxNbr().intValue());
	
	        }
	        if (pojo.getMunicipality() == null) {
	            throw new Exception ("307 Municipality required");
	          }else
	          {
	              Assert.assertEquals(rs.getString("MUNICIPALITY_NAME"),pojo.getMunicipality().toUpperCase());
	
	          }
	        if (pojo.getProvinceCode() != null) {
	        	Assert.assertEquals(rs.getString("PROVINCE_CD"),pojo.getProvinceCode().toUpperCase());
	        }else
	        {
	        	throw new Exception ("308 Province required");
	        }
	        if(pojo.getInstallationName()!=null)
	        {
	        	Assert.assertEquals(rs.getString("INSTALLATION_NAME"),pojo.getInstallationName().toUpperCase());
	
	        }else {
	        	Assert.assertNull(rs.getString("INSTALLATION_NAME"));

	        }
	        
	        Assert.assertEquals(rs.getInt("STREET_NBR"),0);
        	Assert.assertNull(rs.getString("STREET_NBR_SUFFIX"));
            Assert.assertNull(rs.getString("STREET_NAME"));
        	Assert.assertEquals(rs.getInt("STREET_TYPE_VLU_ID"), 0);
        	Assert.assertEquals(rs.getInt("STREET_DIRECTION_VLU_ID"), 0);
        	Assert.assertNull(rs.getString("TO_UNIT_NBR"));            	
        	Assert.assertNull(rs.getString("UNIT_NBR"));
        	Assert.assertEquals(rs.getInt("RURAL_IDENTIFIER_VLU_ID"), 0);
        	Assert.assertNull(rs.getString("ROUTE_NAME"));
        	Assert.assertEquals(rs.getInt("SITE_ID"),0);
        	Assert.assertEquals(rs.getInt("COMPARTMENT"),0);
        	Assert.assertEquals(rs.getInt("CONCESSION"),0);
        	Assert.assertEquals(rs.getInt("LOT"),0);
	        break;
	    case CommonAdd.GEN_DELIVERY:
	        if (pojo.getInstallationName() == null) {
	            throw new Exception ("310 Delivery installation name required");
	        }else
	        {
	        	Assert.assertEquals(rs.getString("INSTALLATION_NAME"),pojo.getInstallationName().toUpperCase());
	
	        }
	        if (pojo.getMunicipality() == null) {
	            throw new Exception ("307 Municipality required");
	          }else
	          {
	              Assert.assertEquals(rs.getString("MUNICIPALITY_NAME"),pojo.getMunicipality().toUpperCase());
	
	          }
	        if (pojo.getProvinceCode() != null) {
	        	Assert.assertEquals(rs.getString("PROVINCE_CD"),pojo.getProvinceCode().toUpperCase());
	        }else
	        {
	        	throw new Exception ("308 Province required");
	        }
	        Assert.assertEquals(rs.getInt("STREET_NBR"),0);
        	Assert.assertNull(rs.getString("STREET_NBR_SUFFIX"));
            Assert.assertNull(rs.getString("STREET_NAME"));
        	Assert.assertEquals(rs.getInt("STREET_TYPE_VLU_ID"), 0);
        	Assert.assertEquals(rs.getInt("STREET_DIRECTION_VLU_ID"), 0);
        	Assert.assertNull(rs.getString("TO_UNIT_NBR"));            	
        	Assert.assertNull(rs.getString("UNIT_NBR"));
        	Assert.assertEquals(rs.getInt("RURAL_IDENTIFIER_VLU_ID"), 0);
        	Assert.assertNull(rs.getString("ROUTE_NAME"));
        	Assert.assertEquals(rs.getInt("SITE_ID"),0);
        	Assert.assertEquals(rs.getInt("COMPARTMENT"),0);
        	Assert.assertEquals(rs.getInt("CONCESSION"),0);
        	Assert.assertEquals(rs.getInt("LOT"),0);
        	Assert.assertNull(rs.getString("PO_BOX_NBR"));

		}
		
		
		
	}
	
	public RequestSpecification processUnacceptableAd(final String URI) {
		return given().baseUri(URI)
     	.contentType(MEDIA_TYPE);
	}
	
	public RequestSpecification givenUnacceptableAd(final String URI, final String payload) {
		return processUnacceptableAd(URI)
     	.body(payload)
     	.auth().basic(USERNAME, PASSWORD)
     	.when();
	}
	
	public RequestSpecification givenDeleteUnacceptableAd(final int recordId) {
		return processUnacceptableAd(BASE_URI+"/"+Integer.valueOf(recordId).toString())
     	.auth().basic(USERNAME, PASSWORD)
     	.when();
	}
	
	public RequestSpecification givenValidateUnacceptableAd(final String payload) {
		return givenUnacceptableAd(BASE_URI2, payload);
	}
	
	public RequestSpecification givenCreateUnacceptableAd(final String payload) {
		return givenUnacceptableAd(BASE_URI, payload);
	}
	
	public RequestSpecification givenUpdateUnacceptableAd(final int recordId, final String payload) {
		return givenUnacceptableAd(BASE_URI+"/"+Integer.valueOf(recordId).toString(), payload);
	}

	
}
