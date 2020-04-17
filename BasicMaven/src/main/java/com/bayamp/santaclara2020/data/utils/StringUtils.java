package com.bayamp.santaclara2020.data.utils;

public class StringUtils {

    public StringUtils() throws Exception{

        throw new Exception("I don't like you at all");

    }
    public static String reverseString(String str) {

        if(str==null) {
            return null;
        }
        StringBuffer buff = new StringBuffer(str);
        return buff.reverse().toString();

    }

    public static boolean isPalindrome(String input) throws Exception {

        if(input == null || input == "" || input == " ") {
            throw new NullPointerException("Hey buddy input cannot be null or empty.");
        }

        StringBuffer buff = new StringBuffer(input);

        String reverse = buff.reverse().toString();
        if(input.equals(reverse)){
            return true;
        }

        return false;

    }
}
