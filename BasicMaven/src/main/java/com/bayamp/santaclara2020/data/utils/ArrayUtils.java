package com.bayamp.santaclara2020.data.utils;

public class ArrayUtils {

    public static int[] reverseArray(int[] myArray) {
        int[] newArray = new int[myArray.length];
        int counter = newArray.length-1;

        for(int i=0; i<myArray.length;i++) {
            newArray[counter]=myArray[i];
            counter--;
        }
        return newArray;
    }
}