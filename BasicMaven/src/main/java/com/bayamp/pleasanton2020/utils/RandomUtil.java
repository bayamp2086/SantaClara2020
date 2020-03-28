package com.bayamp.pleasanton2020.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class RandomUtil {

   private static final String ALL_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789%@#*!=@";

    public static String getRandonNumberOfLength(int length) {

            Random random = new Random();
            long randNumber = random.nextInt(900);

            long fixedLen = randNumber + 100;

            return Long.toString(fixedLen);

    }

    public synchronized static String getRandomFirstName() {
        long time = System.currentTimeMillis();
        return "APIAutoUserF" + time;

    }

    public static String getRandomLastName() {

        Random random = new Random();
        return "AutoUserL"+random.nextInt(9999);
    }

    public static String randomSSNNumber() {
        //345-45-4567
        Random random1 = new Random();
        long randomNumber1 = random1.nextInt(900)+100;

        Random random2 = new Random();
        long randomNumber2 = random1.nextInt(90)+10;

        Random random3= new Random();
        long randomNumber3 = random1.nextInt(9000)+1000;

        StringBuffer buffer = new StringBuffer();

        buffer.append(randomNumber1+"-"+randomNumber2+"-"+randomNumber3);

        return buffer.toString();
    }

    public static String getRandomAlphaNumberic(int len) {

        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < len; i++) {
            Random random1 = new Random();
            int index = random1.nextInt(ALL_CHARS.length());

            char myChar = ALL_CHARS.charAt(index);

            buffer.append(myChar) ;
        }

        return buffer.toString();
    }

    public static String getDate() {

        Date date = new Date();

        DateFormat myDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        String myDate = myDateFormat.format(date);

        return myDate;

    }

    public static String generateRandomNumOfDigits(int numOfDigits){
        String str="";
        for (int i=0;i<numOfDigits;i++){
            str=str+9;
        }
        Random num = new Random();
        String format="%0"+numOfDigits+"d";

       String numStr = String.format(format,num.nextInt(Integer.parseInt(str))).toString();

       return numStr;
    }
    public static String generateRandomPhoneNumber(){
        return "("+generateRandomNumOfDigits(3)+")"+generateRandomNumOfDigits(3)+"-"+generateRandomNumOfDigits(4);
    }
    public static String generateRandomSSN(){
        return generateRandomNumOfDigits(3)+"-"+generateRandomNumOfDigits(2)+"-"+generateRandomNumOfDigits(3);
    }

}
