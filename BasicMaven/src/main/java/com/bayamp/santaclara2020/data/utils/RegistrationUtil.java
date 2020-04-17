package com.bayamp.santaclara2020.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RegistrationUtil {
	
	static long randomNumber = RandomUtil.getRandomNumberAsMilliSeconds();

	/**
	 * Method to generate a Random FirstName
	 * 
	 * @return
	 */
	public static String getRandomFirstName() {

		return Constants.AUTOUSER_FIRSTNAME + randomNumber;
	}

	/**
	 * Method to generate a Random LastName
	 * 
	 * @return
	 */
	public static String getRandomLastName() {

		return Constants.AUTOUSER_LASTNAME + randomNumber;
	}

	/**
	 * Method to generate a Random UserID
	 * 
	 * @return
	 */
	public static String getRandomUserID() {

		return Constants.AUTOUSERID + randomNumber;
	}

	/**
	 * Method to generate a Random Password
	 * 
	 * @return
	 */
	public static String getRandomPassword() {
		return RandomStringUtils.random(12, true, true);
	}

}
