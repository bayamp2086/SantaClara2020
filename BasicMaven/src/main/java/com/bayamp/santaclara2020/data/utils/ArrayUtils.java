package com.bayamp.santaclara2020.data.utils;

import org.testng.annotations.Test;

import java.util.*;

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
        int counter = newArray.length - 1;

        for (int i = 0; i < myArray.length; i++) {
            newArray[counter] = myArray[i];
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
    public static boolean searchNumber(int[] myArray, int number) {

        boolean found = false;
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
     * @param an integer array, and a number
     *
     * @return string that has all the pairs of numbers whose sum equals to 10
     */
    public static StringBuilder checkSum(int[] myArray, int sum) {
        int length = myArray.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (myArray[i] + myArray[j] == sum) {
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

    /*
     * Method to find  count of numbers from an array of numbers and display in descending order
     *
     * @param an integer array
     *
     * @return string that has count of number in descending order
     */
    public static StringBuilder numberCount(int[] myArray) {
        int length = myArray.length;
        StringBuilder sb = new StringBuilder();

        //LinkedHashMap preserves the ordering of elements in which they are inserted
        LinkedHashMap<Integer, Integer> reverseSortedMap = new LinkedHashMap<>();
        Map<Integer, Integer> unSortedMap = new HashMap();

        for (int i = 0; i < length; ++i) {
            int item = myArray[i];

            if (unSortedMap.containsKey(item))
                unSortedMap.put(item, unSortedMap.get(item) + 1);
            else
                unSortedMap.put(item, 1);
        }

        //Comparator.reverseOrder() for reverse ordering
        unSortedMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
               .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

        for (Map.Entry<Integer, Integer> e : reverseSortedMap.entrySet())
            {
                sb.append("\n");
                sb.append(e.getKey());
                sb.append(":");
                sb.append(e.getValue());
            }
        return sb;
    }

    /*
     * Method which takes int[] as input and returns the element of
       the array which is same as the index of that element.
     *
     * @param an integer array
     *
     * @return string that has the element of
       the array which is same as the index of that element.
*/
    public static StringBuilder sameIndexElement(int[] myArray) {
        int length= myArray.length;
        boolean m =false;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<length;i++) {
            if (i == myArray[i]) {
                if(m==true){
                    sb.append(",");
                }
                sb.append(myArray[i]);
                m=true;
            } else {
                continue;
            }
        }
       return sb;
    }

    public static String replaceAllSpaceExceptLastOne(String inputString){
        int index = 0;
        String finalString = null;
        char[] chars = inputString.toCharArray();
        int len = inputString.length();
        for (int i=len-1;i>0;i--){
            if(Character.isWhitespace(chars[i])){
                 index = i;
                 break;
            }
        }
        for (int i=0;i<len;i++){
            if(Character.isWhitespace(chars[i]) && i!=index){
                
            }
        }
    return finalString;
    }


    /*
     * Method which takes int[] as input and returns the index of the element if the element is present in the array
     *
     * @param an integer array
     *
     * @return string that has the index of the element if the element is present in the array
     */
    public static StringBuilder indexOfElement(int[] myArray,int a) {
        int length= myArray.length;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<length;i++) {
            if (myArray[i]==a) {
            sb.append(i);
            }
            else {
                continue;
            }
        }
        return sb;
    }

    @Test
    public void splitDigitsfromNumberAndCompute() {
        int number = 153;
        int sum = 0;
        boolean flag =false;
        String str = (new Integer(number)).toString();
        char[] digits = str.toCharArray();
        int[] arr = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            arr[i] = Character.getNumericValue(digits[i]);
        }
        for (int a : arr) {
            System.out.println(a);
            sum = sum + (int)Math.pow(a,3);
        }
        if (sum == 153) {
            flag= true;
        }
        System.out.println(flag);
    }
}

