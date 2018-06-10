package com.restassured.util;

import static com.restassured.common.util.OracleConnection.getOracleConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;

import org.testng.Assert;

import com.restassured.common.util.CommonAddressUtility;
import com.restassured.common.util.ExceptionalRunnable;
import com.restassured.pojo.UnacceptableAddPojo;


public class Utility {
	
	public static void queryUnacceptableAd(int adID, ExceptionalRunnable assertions, UnacceptableAddPojo pojo) throws Exception {
		
		String selectTableSQL = "SELECT * FROM SCHEMA.POJO_ADDRESS WHERE POJO_ADDRESS_ID="+adID;
	    

        try ( Connection connection = getOracleConnection()) {

            
        	try (Statement statement = connection.createStatement()) {
	            
	          
	            // get data from DB
	            try (ResultSet rs = statement.executeQuery(selectTableSQL)) {
		
		            // fetch data
		            while (rs.next()) {
		            	assertions.run(rs, pojo);
		            }
	            }
        	}
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public static void queryUnacceptableAdDelete(int adID) {
		
		String selectTableSQL = "DELETE FROM SCHEMA.POJO_ADDRESS WHERE POJO_ADDRESS_ID="+adID;
		
    try ( Connection connection = getOracleConnection()) {

            
        	try (Statement statement = connection.createStatement()) {
	            
	            // execute the query to remove data
        		statement.executeUpdate(selectTableSQL);
	            
        	}
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	public static void queryUnacceptableAdCount(String postalCode, int rowCount) {
		
String selectTableSQL = "SELECT COUNT(*) FROM SCHEMA.POJO_ADDRESS WHERE POSTAL_CODE='"+postalCode.toUpperCase()+"'";
	    

        try ( Connection connection = getOracleConnection()) {

            
        	try (Statement statement = connection.createStatement()) {
	            
	          
	            // get data from DB
	            try (ResultSet rs = statement.executeQuery(selectTableSQL)) {
		
	            	  if(rs.next()) {
			        	   int recordCount = rs.getInt(1);
			        	   Assert.assertEquals(recordCount, rowCount);
			          }
		           
	            }
        	}
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
		
	}
	
	public static void queryDuplicateCivicAdCount(String postalCode, String streetName, Integer streetNo) {
		final int expectedRowCount = 1;
		final String selectTableSQL = "SELECT COUNT(*) FROM SCHEMA.POJO_ADDRESS WHERE POSTAL_CODE='"
				+postalCode.toUpperCase() + "' AND STREET_NAME='"
				+streetName.toUpperCase() + "' AND STREET_NBR="
				+streetNo.toString()+ " AND ADDRESS_TYPE_VLU_ID=1" + " AND ENTIRE_UNIT_RANGE_IND=1"+ " AND ENTIRE_POSTAL_CODE_IND=0";
	    

        try ( Connection connection = getOracleConnection()) {

            
        	try (Statement statement = connection.createStatement()) {
	            
	          
	            // get data from DB
	            try (ResultSet rs = statement.executeQuery(selectTableSQL)) {
		
		          if(rs.next()) {
		        	   int recordCount = rs.getInt(1);
		        	   Assert.assertEquals(recordCount, expectedRowCount);
		          }
		           
	            }
        	}
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
		
	}
	public static void queryDuplicateRuralAdCount(String postalCode, Integer ruralIdentifier, String routeName) {
		final int expectedRowCount = 1;
		final String selectTableSQL = "SELECT COUNT(*) FROM SCHEMA.POJO_ADDRESS WHERE POSTAL_CODE='"
				+postalCode.toUpperCase() + "' AND ROUTE_NAME='"
				+routeName.toUpperCase() + "' AND RURAL_IDENTIFIER_VLU_ID="
				+ruralIdentifier.toString()+ " AND ADDRESS_TYPE_VLU_ID=2";
	    

        try ( Connection connection = getOracleConnection()) {

            
        	try (Statement statement = connection.createStatement()) {
	            
	          
	            // get data from DB
	            try (ResultSet rs = statement.executeQuery(selectTableSQL)) {
		
	            	  if(rs.next()) {
			        	   int recordCount = rs.getInt(1);
			        	   Assert.assertEquals(recordCount, expectedRowCount);
			          }
		           
	            }
        	}
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
		
	}
	public static void queryDuplicatePOBoxAdCount(String postalCode, Integer poboxNo) {
		final int expectedRowCount = 1;
		final String selectTableSQL = "SELECT COUNT(*) FROM SCHEMA.POJO_ADDRESS WHERE POSTAL_CODE='"
				+postalCode.toUpperCase() + "' AND PO_BOX_NBR='"
				+poboxNo.toString()+ "' AND ADDRESS_TYPE_VLU_ID=3";
	    

        try ( Connection connection = getOracleConnection()) {

            
        	try (Statement statement = connection.createStatement()) {
	            
	          
	            // get data from DB
	            try (ResultSet rs = statement.executeQuery(selectTableSQL)) {
		
	            	  if(rs.next()) {
			        	   int recordCount = rs.getInt(1);
			        	   Assert.assertEquals(recordCount, expectedRowCount);
			          }
		           
	            }
        	}
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
        public static void queryDuplicateGDAdCount(String postalCode) {
    		final int expectedRowCount = 1;
    		final String selectTableSQL = "SELECT COUNT(*) FROM SCHEMA.POJO_ADDRESS WHERE POSTAL_CODE='"
    				+postalCode.toUpperCase() + "' AND ADDRESS_TYPE_VLU_ID=4";
    	    

            try ( Connection connection = getOracleConnection()) {

                
            	try (Statement statement = connection.createStatement()) {
    	            
    	          
    	            // get data from DB
    	            try (ResultSet rs = statement.executeQuery(selectTableSQL)) {
    		
    	            	  if(rs.next()) {
    			        	   int recordCount = rs.getInt(1);
    			        	   Assert.assertEquals(recordCount, expectedRowCount);
    			          }
    		           
    	            }
            	}
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
	}
        public static void queryRecordCheckCreation(String postalCode, String UnitNbr, String ToUnitNbr) {
    		final int expectedRowCount = 0;
    		final String selectTableSQL = "SELECT COUNT(*) FROM SCHEMA.POJO_ADDRESS WHERE POSTAL_CODE='"
    				+postalCode.toUpperCase() + "' AND ADDRESS_TYPE_VLU_ID=1" + " AND ENTIRE_UNIT_RANGE_IND=0" + " AND UNIT_NBR='"+UnitNbr + "' AND TO_UNIT_NBR='"+ToUnitNbr+"'";
    	    

            try ( Connection connection = getOracleConnection()) {

                
            	try (Statement statement = connection.createStatement()) {
    	            
    	          
    	            // get data from DB
    	            try (ResultSet rs = statement.executeQuery(selectTableSQL)) {
    		
    	            	  if(rs.next()) {
    			        	   int recordCount = rs.getInt(1);
    			        	   Assert.assertEquals(recordCount, expectedRowCount);
    			          }
    		           
    	            }
            	}
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
	}
        
        public static int queryAddressCreationEntirePostalCode(UnacceptableAddPojo pojo) throws Exception {
        	
        	if (pojo.isEntirePostalCodeInd() == false) {
        		throw new Exception("When calling this method, isEntirePostalCodeInd should be specified");
        	}
        	
        	if (pojo.getNotes() == null) {
        		throw new Exception("When entire postal code inditator set to true, notes must be specified");
        	}
        	
        	if (pojo.getPostalCode() == null) {
        		throw new Exception("Postal code is required when entire postal code inditator set to true");
        	}
        	
        	pojo.setAddressTypeCd(null);
        	pojo.setCompartment(null);
        	pojo.setConcession(null);
        	pojo.setEntireUnitRangeInd(false);
        	pojo.setInstallationName(null);
        	pojo.setLot(null);
        	pojo.setMunicipality(null);
        	pojo.setPoBoxNbr(null);
        	pojo.setProvinceCode(null);
        	pojo.setRouteName(null);
        	pojo.setRuralIdentifierCd(null);
        	pojo.setSite(null);
        	pojo.setStreetDirectionCd(null);
        	pojo.setStreetName(null);
        	pojo.setStreetNbr(null);
        	pojo.setStreetNbrSuffix(null);
        	pojo.setStreetTypeCd(null);
        	pojo.setToUnitNbr(null);
        	pojo.setUnitNbr(null);
        	
        	
        	return queryAddressCreation(pojo);
        }
    public static int queryAddressCreationCivic(UnacceptableAddPojo pojo) throws Exception {
        	
        	if (pojo.isEntirePostalCodeInd() == true) {
        		throw new Exception("When calling this method, isEntirePostalCodeInd should be false");
        	}
        	
        	if (pojo.getNotes() == null) {
        		throw new Exception("Notes is required");
        	}
        	
        	if (pojo.getPostalCode() == null) {
        		throw new Exception("Postal code is required ");
        	}
        	if (pojo.getProvinceCode() == null) {
        		throw new Exception("Province code is required ");
        	}
        	if (pojo.getMunicipality() == null) {
        		throw new Exception("Municipality Name is required");
        	}
        	if (pojo.getStreetName() == null) {
        		throw new Exception("Street Name is required");
        	}
        	if (pojo.getStreetNbr() == null) {
        		throw new Exception("Street Number is required");
        	}
        	if (pojo.getAddressTypeCd() == null) {
        		throw new Exception("Address Type is required");
        	}
        	pojo.setCompartment(null);
        	pojo.setConcession(null);
        	pojo.setInstallationName(null);
        	pojo.setLot(null);
        	pojo.setPoBoxNbr(null);
        	pojo.setRouteName(null);
        	pojo.setRuralIdentifierCd(null);
        	pojo.setSite(null);
        
        	
        	return queryAddressCreation(pojo);
        }
        public static int queryAddressCreation(UnacceptableAddPojo pojo) throws Exception {

        	StringBuilder sbquery = new StringBuilder();
        	StringBuilder sbvalues = new StringBuilder();
        	
        	sbquery.append("INSERT INTO SCHEMA.POJO_ADDRESS ( ");
        	
 		
     		if(pojo.getPostalCode()!=null)
     		{
     			sbvalues.append("?,");
     			sbquery.append("POSTAL_CODE,");
     		}
     		if(pojo.getProvinceCode()!=null)
     		{
     			sbvalues.append("?,");
     			sbquery.append("PROVINCE_CD,");
     		}
     		if(pojo.getMunicipality()!=null)
     		{
     			sbvalues.append("?,");
     			sbquery.append("MUNICIPALITY_NAME,");
     		}
     		if(pojo.getStreetNbr()!=null)
     		{
     			sbvalues.append("?,");
     			sbquery.append("STREET_NBR,");
     		}
     		if(pojo.getStreetName()!=null)
     		{
     			sbvalues.append("?,");
     			sbquery.append("STREET_NAME,");
     		}
     		if(pojo.getNotes()!=null)
     		{
     			sbvalues.append("?,");
     			sbquery.append("NOTES,");
     		}
     		
     		
     		if(pojo.getAddressTypeCd()!=null)
     		{
     			sbvalues.append("?,");
     			sbquery.append("ADDRESS_TYPE_VLU_ID,");
     		}
     		if(pojo.getCompartment()!=null)
     		{
     			sbvalues.append("?,");
     			sbquery.append("COMPARTMENT,");
     		}
     		if(pojo.getConcession()!=null)
     		{
     			sbvalues.append("?,");
     			sbquery.append("CONCESSION,");
     		}
     		if(pojo.getInstallationName()!=null) 
     		{
     			sbvalues.append("?,");
     			sbquery.append("INSTALLATION_NAME,");
     		}
     		if(pojo.getLot()!=null)
     		{
     			sbvalues.append("?,");
     			sbquery.append("LOT,");
     		}
     		if(pojo.getPoBoxNbr()!=null)
     		{
     			sbvalues.append("?,");
     			sbquery.append("PO_BOX_NBR,");
     		}
     		if(pojo.getRouteName()!=null)
     		{
     			sbvalues.append("?,");
     			sbquery.append("ROUTE_NAME,");
     		}
     		if(pojo.getRuralIdentifierCd()!=null)
     		{
     			sbvalues.append("?,");
     			sbquery.append("RURAL_IDENTIFIER_VLU_ID,");
     		}
     		if(pojo.getSite()!=null)
     		{
     			sbvalues.append("?,");
     			sbquery.append("SITE_ID,");
     		}
     		if(pojo.getStreetDirectionCd()!=null)
     		{
     			sbvalues.append("?,");
     			sbquery.append("STREET_DIRECTION_VLU_ID,");
     		}
     		if(pojo.getStreetNbrSuffix()!=null)
     		{
     			sbvalues.append("?,");
     			sbquery.append("STREET_NBR_SUFFIX,");
     		}
     		if(pojo.getStreetTypeCd()!=null)
     		{
     			sbvalues.append("?,");
     			sbquery.append("STREET_TYPE_VLU_ID,");
     		}
     		if(pojo.getToUnitNbr()!=null)
     		{
     			sbvalues.append("?,");
     			sbquery.append("TO_UNIT_NBR,");
     		}
     		if(pojo.getUnitNbr()!=null)
     		{
     			sbvalues.append("?,");
     			sbquery.append("UNIT_NBR,");
     		}
     		
     		sbvalues.append("?,");
     		sbquery.append("ENTIRE_UNIT_RANGE_IND,");
     		sbvalues.append("?,");
 			sbquery.append("CREATED_USER_ID,");
 			sbvalues.append("?,");
 			sbquery.append("CREATED_DATE_TIME,");
     		sbvalues.append("?");
 			sbquery.append("ENTIRE_POSTAL_CODE_IND");
 			
 			sbvalues.append(")");
 			sbquery.append(") values (");
 			sbquery.append(sbvalues.toString());
 			
        	
             try ( Connection connection = getOracleConnection()) {
                 
             	try (PreparedStatement statement = connection.prepareStatement(sbquery.toString(),
             			new String[] { "POJO_ADDRESS_ID" })) {
             		
             		int counter = 1;
             		if(pojo.getPostalCode()!=null)
             		{
             			statement.setString(counter, pojo.getPostalCode().toUpperCase().replace('-' , ' '));
             			counter++;
             		} else {
             			throw new Exception("Postal code missing");
             		}
             		if(pojo.getProvinceCode()!=null)
             		{
             			statement.setString(counter, pojo.getProvinceCode().toUpperCase());
             			counter++;
             		}
             		if(pojo.getMunicipality()!=null)
             		{
             			statement.setString(counter, pojo.getMunicipality().toUpperCase());
             			counter++;
             		}
             		if(pojo.getStreetNbr()!=null)
             		{
             			statement.setInt(counter, pojo.getStreetNbr());
             			counter++;
             		}
             		if(pojo.getStreetName()!=null)
             		{
             			statement.setString(counter, pojo.getStreetName().toUpperCase());
             			counter++;
             		}
             		if(pojo.getNotes()!=null)
             		{
             			statement.setString(counter, pojo.getNotes().toUpperCase());
             			counter++;
             		}
             		if(pojo.getAddressTypeCd()!=null)
             		{
             			statement.setInt(counter, pojo.getAddressTypeCd());
             			counter++;
             		}
             		if(pojo.getCompartment()!=null)
             		{
             			statement.setInt(counter, pojo.getCompartment());
             			counter++;
             		}
             		if(pojo.getConcession()!=null)
             		{
             			statement.setInt(counter, pojo.getConcession());
             			counter++;
             		}
             		if(pojo.getInstallationName()!=null) 
             		{
             			statement.setString(counter, pojo.getInstallationName().toUpperCase());
             			counter++;
             		}
             		if(pojo.getLot()!=null)
             		{
             			statement.setInt(counter, pojo.getLot());
             			counter++;
             		}
             		if(pojo.getPoBoxNbr()!=null)
             		{
             			statement.setInt(counter, pojo.getPoBoxNbr());
             			counter++;
             		}
             		if(pojo.getRouteName()!=null)
             		{
             			statement.setString(counter, pojo.getRouteName().toUpperCase());
             			counter++;
             		}
             		if(pojo.getRuralIdentifierCd()!=null)
             		{
             			statement.setInt(counter, pojo.getRuralIdentifierCd());
             			counter++;
             		}
             		if(pojo.getSite()!=null)
             		{
             			statement.setInt(counter, pojo.getSite());
             			counter++;
             		}
             		if(pojo.getStreetDirectionCd()!=null)
             		{
             			statement.setInt(counter, pojo.getStreetDirectionCd());
             			counter++;
             		}
             		if(pojo.getStreetNbrSuffix()!=null)
             		{
             			statement.setString(counter, pojo.getStreetNbrSuffix());
             			counter++;
             		}
             		if(pojo.getStreetTypeCd()!=null)
             		{
             			statement.setInt(counter, pojo.getStreetTypeCd());
             			counter++;
             		}
             		if(pojo.getToUnitNbr()!=null)
             		{
             			statement.setString(counter, pojo.getToUnitNbr().toUpperCase());
             			counter++;
             		}
             		if(pojo.getUnitNbr()!=null)
             		{
             			statement.setString(counter, pojo.getUnitNbr().toUpperCase());
             			counter++;
             		}
             		statement.setBoolean(counter, pojo.isEntireUnitRangeInd());
             		counter++;
             		statement.setString(counter,  "USER");
         			counter++;
         			Date date = new Date(Instant.now().getEpochSecond());
         			statement.setDate(counter, date);
         			counter++;
             		statement.setBoolean(counter, pojo.isEntirePostalCodeInd());
     
             		int affectedRows = statement.executeUpdate();
             		 if (affectedRows == 0) {
                         throw new SQLException("Creating user failed, no rows affected.");
                     }
             		 // Retrieve the generated primary key ID from the inserted row
             		Integer primaryKey = null;
             		try(ResultSet generatedKeys = statement.getGeneratedKeys()) {
	             		if (null != generatedKeys && generatedKeys.next()) {
	             		     primaryKey = generatedKeys.getInt(1);
	             		    
	             		}
             		}
             		return primaryKey;
 
             	}
             } catch (SQLException e) {
                 throw new RuntimeException(e);
             }
 	}
        public static void queryUnacceptableAdIDCheck(int recordID, int rowCount) {
    		
        	String selectTableSQL = "SELECT COUNT(*) FROM SCHEMA.POJO_ADDRESS WHERE POJO_ADDRESS_ID="+recordID;
        		    

        	        try ( Connection connection = getOracleConnection()) {

        	            
        	        	try (Statement statement = connection.createStatement()) {
        		            
        		          
        		            // get data from DB
        		            try (ResultSet rs = statement.executeQuery(selectTableSQL)) {
        			
        		            	  if(rs.next()) {
        				        	   int recordCount = rs.getInt(1);
        				        	   Assert.assertEquals(recordCount, rowCount);
        				          }
        			           
        		            }
        	        	}
        	        } catch (SQLException e) {
        	            throw new RuntimeException(e);
        	        }
        			
        		}
        
        public static boolean queryUnacceptablePostalCdCheckExists(String postalCode) {
    		
        	String selectTableSQL = "SELECT COUNT(*) FROM SCHEMA.POJO_ADDRESS WHERE POSTAL_CODE='"+postalCode.toUpperCase()+"'";
        		    

        	        try ( Connection connection = getOracleConnection()) {

        	            
        	        	try (Statement statement = connection.createStatement()) {
        		            
        		          
        		            // get data from DB
        		            try (ResultSet rs = statement.executeQuery(selectTableSQL)) {
        			
        		            	  if(rs.next()) {
        				        	   int recordCount = rs.getInt(1);
        				        	  return recordCount>0;
        				        	
        				        	   
        				          }
        			           
        		            }
        	        	}
        	        } catch (SQLException e) {
        	            throw new RuntimeException(e);
        	        }
        			return false;
        		}
        public static String generateUnacceptableAddPostalCd() 
        {
        	String postalcd= "";
        	
        	do {
        		postalcd = CommonAddressUtility.generatePostalCd();
        	}while(queryUnacceptablePostalCdCheckExists(postalcd));
        	return postalcd;
        }
        

}
