package com.bayamp.santaclara2020.userdefined.objects;

import com.bayamp.santaclara2020.exceptions.EmptyIdException;

public class Student extends Person {

    private double gpa;
    private String id;

    public Student(String firstName, String lastName, String id, double g) {
        super(firstName, lastName);
        this.gpa = g;
        this.id = id;
    }

    public String toString() {
        return super.toString() + "," + getGPA();
    }

    public double getGPA() {
        return gpa;
    }

    //checking student id is null
    public void validateID() throws EmptyIdException{
        if (id.equals("")) {
            throw new EmptyIdException(
                    "Please input Student ID");
        }
    }

}
