package com.bayamp.santaclara2020.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class RandomUtil {

    /**
     * Method to generate a Random Number
     *
     * @return long
     */
    public static long getRandomLongNumber() {
        Random randomObject = new Random();
        long randomNumber = randomObject.nextLong();
        return randomNumber;
    }

    /**
     * Method to generate a Random Number
     *
     * @return int
     */
    public static int getRandomIntNumber(int len) {
        Random randomObject = new Random();
        int nextRandom = randomObject.nextInt(len);
        return nextRandom;
    }

    /**
     * Method to generate a Random Number in Milliseconds
     *
     * @return long
     */
    public static long getRandomNumberAsMilliSeconds() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return System.currentTimeMillis();
    }

    /**
     * Method to generate a Random Number in Milliseconds
     *
     * @return String
     */
    public static String getRandomNumberStringAsMilliSeconds() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        long random = System.currentTimeMillis();
        return Long.toString(random);
    }

    /**
     * Method to generate a Random Number according to Digit Length
     *
     * @return
     */
    public static int getRandomStringOfLen(int numberOfDigits) {
        int m = (int) Math.pow(10, numberOfDigits - 1);
        return m + new Random().nextInt(9 * m);
    }

    /**
     * Method to generate a Random First Name
     *
     * @return
     */
    public static String getRandomFirstName() {
        return "TestUserF" + getRandomNumberAsMilliSeconds();
    }

    /**
     * Method to generate a Random Date
     *
     * @return
     */
    public static String getDate() {
        Date date = new Date();
        String pattern;
        SimpleDateFormat format = new SimpleDateFormat(pattern = "MM/DD/YYYY");
        format.format(date);
        return date.toString();
    }

    /**
     * Method to generate a Random SSN
     *
     * @return
     */
    public static String generateRandomSSN() {
        int num1, num2, num3; // 3 numbers in area code
        int groupNumber, serialNumber; // sequence 2 and 3 of the phone number

        Random generator = new Random();

        // Area code number
        num1 = generator.nextInt(9) + 1; // adding 1 so there is no 0 to begin
        num2 = generator.nextInt(10);
        num3 = generator.nextInt(10);

        // generating the group number in ssn number
        groupNumber = generator.nextInt(89) + 10;

        // generating the serial number in ssn number
        serialNumber = generator.nextInt(8999) + 1000;

        String randomSSNNumber = "(" + num1 + num2 + num3 + ")" + "-" + groupNumber + "-" + serialNumber;
        return randomSSNNumber;
    }

    /**
     * Method to generate a Random Phone Number
     *
     * @return
     */
    public static String generateRandomPhoneNumber() {
        int num1, num2, num3; // 3 numbers in area code
        int set2, set3; // sequence 2 and 3 of the phone number

        Random generator = new Random();

        // Area code number
        num1 = generator.nextInt(9) + 1; // adding 1 so there is no 0 to begin
        num2 = generator.nextInt(10);
        num3 = generator.nextInt(10);

        // Sequence two of phone number
        set2 = generator.nextInt(899) + 100;

        // Sequence 3 of number
        set3 = generator.nextInt(8999) + 1000;

        String randomPhoneNumber = "(" + num1 + num2 + num3 + ")" + " " + set2 + "-" + set3;
        return randomPhoneNumber;
    }

}