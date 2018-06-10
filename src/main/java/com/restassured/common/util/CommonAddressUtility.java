package com.restassured.common.util;
import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
public class CommonAddressUtility {
	public static String generatePostalCd() 
	
	{
		//"pattern": "^[A-Za-z][0-9][A-Za-z]([ -])?[0-9][A-Za-z][0-9]$"
		return randomAlphabetic(1).toUpperCase() + randomNumeric(1) + randomAlphabetic(1).toUpperCase()+  random(1," -") +randomNumeric(1) +randomAlphabetic(1).toUpperCase()+randomNumeric(1); 
				
	
	}

}
