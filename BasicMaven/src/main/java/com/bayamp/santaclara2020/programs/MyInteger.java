package com.bayamp.santaclara2020.programs;

public class MyInteger {

    public static int parseInt(String value, int temp) {
        int total = 0;
        try {
            total = Integer.parseInt(value) + temp;
            System.out.println("Success no exception");
        } catch (NumberFormatException e) {
            System.out.println("Number Format Exception caught!");
        } catch (NullPointerException e) {
            System.out.println("Null Pointer Exception caught!");
        } catch (RuntimeException e) {

        } finally {
            System.out.println("Finally getting executed!");
        }
        ;
        return total;
    }
}
