package com.bayamp.santaclara2020.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author swatipathak
 *
 */
public class RandomUtil {

    //private static final String DATE_FORMAT = "MM/dd/YYYY HH:mm";

    public static long getRandomLongNumber( ) {
        Random randomObject = new Random();
        long randomNumber = randomObject.nextLong() ;

		return randomNumber;

	}

    /**
     * if parameter value is 1 or 2 (return any random number from 0-9)
     * if parameter value is 2 or 3 (return any random number from 10-99)
     * if parameter value is 3 or 4 (return any random number from 100-999)
     * @param numberOfDigits
     * @return
     */
    public static String getRandomStringOfLen(int numberOfDigits) {

		Random randomObject = new Random();
		StringBuilder digitFormat = new StringBuilder();
		StringBuilder bound = new StringBuilder();
		digitFormat.append("%0" + numberOfDigits + "d");

		bound.append("1");
		for (int i = 0; i < numberOfDigits; i++) {
			bound.append("0");
		}
		int boundValue = Integer.parseInt(bound.toString());

		//int randomIntNumber = randomObject.nextInt(boundValue);
		int randomIntNumber = randomObject.nextInt(boundValue - boundValue / 10) + boundValue / 10;
		String str = String.format(digitFormat.toString(), randomIntNumber);

		return str;
	}
    

    /**
     * Method to generate a random number using current time in milliseconds
     * @return
     */
    public static long getRandomNumberAsMilliSeconds( ) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return System.currentTimeMillis();
    }


    /**
     * Method to generate a random string in milliseconds
     * @return string
     */
    public static String getRandomSringAsMilliSeconds( ) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long random = System.currentTimeMillis();

        return Long.toString(random);

    }

    /**
     * generates RandomFirstName
     * @return
     */
    public static String getRandomFirstName() {

        return "TestUserF"+getRandomNumberAsMilliSeconds();
    }

    /**
     * generates Date
     * @return
     */
    public static String getDate() {

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_FORMAT);
        return format.format(date);
    }

    /**
     * generates Date in specified format
     * @param strFormat
     * @return
     */
    public static String getDate(String strFormat) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(strFormat);
        return dateFormat.format(date);
    }

    /**
     * generates RandomSSN
	 * @return
	 */
	public static String generateRandomSSN() {

		return getRandomStringOfLen(3) + "-" + getRandomStringOfLen(2) + "-" + getRandomStringOfLen(4);
	}

	/**
	 * generates RandomPhoneNumber
	 * @return
	 */
	public static String generateRandomPhoneNumber() {

		return "(" + getRandomStringOfLen(3) + ")" + getRandomStringOfLen(3) + "-"
				+ getRandomStringOfLen(4);
	}
}
