package com.bayamp.santaclara2020.data.utils;

import java.util.Arrays;

public class ArrayUtils {

    /*
     * Method to reverse elements in an array
     *
     * @param  an integer array
     *
     * @return an array without all elements reversed
     */
    public static int[] reverseArray(int[] myArray) {
        int[] newArray = new int[myArray.length];
        int counter = newArray.length-1;

        for(int i=0; i<myArray.length;i++) {
            newArray[counter]=myArray[i];
            counter--;
        }
        return newArray;
    }
    /*
     * Method to remove duplicates in an array
     *
     * @param  an integer array
     *
     * @return an array without any duplicates
     */
    public static int[] removeDuplicates(int[] myArray) {
        int len = myArray.length;
        if (len == 0 || len == 1) {
            System.out.println("Not valid Input.The length of array must be at least two");
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (myArray[i] == myArray[j]) {
                    int temp = myArray[i];
                    myArray[i] = myArray[len - 1];
                    myArray[len - 1] = temp;
                    len = len - 1;
                    j--;
                }
            }
        }
       // System.out.println("The length of array after removing duplicates is:" + len);
        int[] noDuplicatesArray = Arrays.copyOf(myArray, len);
        return noDuplicatesArray;
    }

    /*
     * Method to find the highest number in an array
     *
     * @param an integer array
     *
     * @return highest number in the array
     */
    public static int highestNumber(int[] myArray) {
        int highest = myArray[0];
        for (int i = 1; i < myArray.length; i++) {
            if (highest < myArray[i]) {
                highest = myArray[i];
            }
        }
        return highest;
    }

    /*
     * Method to find the second highest number in an array
     *
     * @param an integer array
     *
     * @return second highest number in the array
     */
    public static int secondHighestNumber(int[] myArray) {
        int highest = myArray[0];
        int secondHighest = myArray[0];
        for (int i = 0; i < myArray.length; i++) {

            if (secondHighest < myArray[i]) {
                secondHighest = myArray[i];
            }

            if (highest < secondHighest) {
                int temp = secondHighest;
                secondHighest = highest;
                highest = temp;
            }
        }
        return secondHighest;
    }

    /*
     * Method to find the smallest number in an array
     *
     * @param an integer array
     *
     * @return smallest number in the array
     */
    public static int smallestNumber(int[] myArray) {
        int smallest = myArray[0];
        for (int i = 1; i < myArray.length; i++) {
            if (smallest > myArray[i]) {
                smallest = myArray[i];
            }
        }
        return smallest;
    }

    /*
     * Method to find the second smallest number in an array
     *
     * @param an integer array
     *
     * @return second smallest number in the array
     */
    public static int secondSmallestNumber(int[] myArray) {

        Arrays.sort(myArray);
        int secondSmallest = myArray[1];
        return secondSmallest;
    }

    /*
     * User defined toString method
     *
     * @param an integer array
     *
     * @return string in {} format
     */
    public static String toString(int[] myArray) {
        if (myArray == null)
            return "null";
        int iMax = myArray.length - 1;
        if (iMax == -1)
            return "{}";

        StringBuilder b = new StringBuilder();
        b.append('{');
        for (int i = 0; ; i++) {
            b.append(myArray[i]);
            if (i == iMax)
                return b.append('}').toString();
            b.append(",");

        }
    }

    /*
     * Method that searches a given number in an array
     *
     * @param an integer array and the number to be found
     *
     */
    public static boolean searchNumber(int[] myArray,int number) {

        boolean found= false;
        for (int i = 0; i < myArray.length; i++) {
            if (number == myArray[i]) {
                //System.out.println("Number found in the index: " + i);
                found = true;
            }
        }
        return found;
    }

    /*
     * Method to find pair of all numbers in an array whose sum is going to be 10
     *
     * @param an integer array
     *
     * @return string that has all the pairs of numbers whose sum equals to 10
     */
    public static StringBuilder sumTen(int[] myArray) {
        int length= myArray.length;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<length;i++) {
            for(int j=i+1; j<length;j++) {
                if(myArray[i]+myArray[j]==10) {
                    sb.append("(");
                    sb.append(myArray[i]);
                    sb.append(",");
                    sb.append(myArray[j]);
                    sb.append(")");
                    sb.append(" ");
                }
            }
        }
        return sb;
    }
}
