package com.bayamp.santaclara2020.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class RandomUtil {

	// private static final String DATE_FORMAT = "MM/dd/YYYY HH:mm";

	public static long getRandomLongNumber() {
		Random randomObject = new Random();
		long randomNumber = randomObject.nextLong();

		return randomNumber;

	}

	/**
	 * if parameter value is 1 (return any random number from 0-9)
	 * if parameter value is 2 (return any random number from 10-99)
	 * if parameter value is 3 (return any random number from 100-999)
	 * @param numberOfDigits
	 * @return
	 */
	public static int getRandomStringOfLen(int numberOfDigits) {

		int m = (int) Math.pow(10, numberOfDigits - 1); // 0-999

		return m + new Random().nextInt(9 * m);

	}

	public static long getRandomNumberAsMilliSeconds() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return System.currentTimeMillis();
	}

	public static String getRandomSringAsMilliSeconds() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long random = System.currentTimeMillis();

		return Long.toString(random);

	}

	public static String getRandomFirstName() {

		return "TestUserF" + getRandomNumberAsMilliSeconds();
	}

	public static String getDate() {

		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_FORMAT);
		return format.format(date);
	}

	public static String getDate(String strFormat) {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(strFormat);
		return dateFormat.format(date);
	}

	public static String generateRandomPhoneNumber() {
		return null;
	}
}
