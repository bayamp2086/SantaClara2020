package com.bayamp.santaclara2020.data.utils;

import org.testng.annotations.Test;

public class GeneralUtils {

    public static void swapNumbers() {
        //swap two numbers with temp
        int a = 10;
        int b = 12;
        int temp;
        temp = a;
        a = b;
        b = temp;
        System.out.println(a + "," + b);

        //swap two numbers without temp
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(a + "," + b);
    }

    @Test
    public static void factorialIteration(int n) {

        int factorial = 1;
        for (; n > 1; n -= 2) {
            factorial = factorial * n * (n - 1);
        }
        System.out.println(factorial);
    }

    @Test
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return (n * factorial(n - 1));
        }
    }

    @Test
    public static void primeNumber() {
        int n = 11;
        if (n % 2 == 0 && n != 2) {
            System.out.println("Number not prime");
        } else {
            System.out.println("Number is prime");
        }
    }
    @Test
    public static void printNumberSequence() {
        int num=5;
        int updaNum = num;

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= updaNum; j++) {
                System.out.print(j);
            }
            updaNum--;
            System.out.println();
        }

        for (int i = 2; i <= num; i++) {
            for (int j = 1; j <= (updaNum - (updaNum - i)); j++) {
                System.out.print(j);
            }
            updaNum++;
            System.out.println();
        }
    }
    /*Output :
    12345
    1234
    123
    12
    1
    12
    123
    1234
    12345*/

    @Test
    public static void printNumberSequence1() {
        int num = 5;
        int updaNum = num;

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= (updaNum - (updaNum - i)); j++) {
                System.out.print(j);
            }
            updaNum++;
            System.out.println();
        }
        updaNum-=6;
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= updaNum; j++) {
                System.out.print(j);
            }
            updaNum--;
            System.out.println();
        }
    }
    /*Output
     1
    12
    123
    1234
    12345
    1234
    123
    12
    1
    */

}
