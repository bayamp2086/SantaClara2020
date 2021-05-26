package com.bayamp.santaclara2020.programs;

public class MyProgram {
    public static void main(String[] args) {
        String value = "1334";
        int temp = 40;
        int sum = MyInteger.parseInt(value, temp);
        System.out.println("The total sum is :" + sum);
    }
}
