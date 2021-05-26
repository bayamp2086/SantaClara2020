package com.bayamp.santaclara2020.userdefined.objects;

import com.bayamp.santaclara2020.interfaces.IEmployee;

public class Employee extends Person implements IEmployee {

    private double salary;
    private String ssn;
    public Employee( String firstName, String lastName, String ssn, double s )
    {
        super( firstName, lastName);
        this.ssn=ssn;
        salary = s;
    }

    public String toString( )
    {
        return super.toString( ) + " ," + getSalary( );
    }

    public double getSalary( )
    {
        return salary;
    }

    public void setSalary(double salary)
    {
        this.salary=salary;
    }

    public boolean validSSN(){
        //check length first
        if (ssn.length() != 11) return false;

        //traverse through each character
        for (int i = 0; i < ssn.length(); i++){
            if (i <= 2){
                //these must be digits, otherwise return false
                if (!isDigit(ssn.charAt(i))){
                   return false;
                }
            }
            else if (i == 3 || i == 6){
                //these must be dashes, otherwise return false
                if (!isDash(ssn.charAt(i))){
                    return false;
                }
            }
            else if (i > 6){
                //these must be digits, otherwise return false
                if (!isDigit(ssn.charAt(i))){
                    return false;
                }
            }
        }
        //return true if it didn't error out
        return true;
    }

    public static boolean isDigit(char c){
        return Character.isDigit(c);
    }

    public static boolean isDash(char c){
        return (c == '-');
    }
}

