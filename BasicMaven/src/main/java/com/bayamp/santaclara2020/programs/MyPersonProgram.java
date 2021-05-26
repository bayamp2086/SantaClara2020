package com.bayamp.santaclara2020.programs;

import com.bayamp.santaclara2020.data.utils.UserDefinedUtil;
import com.bayamp.santaclara2020.exceptions.EmptyIdException;
import com.bayamp.santaclara2020.exceptions.InvalidSSNException;
import com.bayamp.santaclara2020.userdefined.objects.Employee;
import com.bayamp.santaclara2020.userdefined.objects.Person;
import com.bayamp.santaclara2020.userdefined.objects.Student;

public class MyPersonProgram {
    public static void main(String[] args) throws InvalidSSNException {
        Person p1 = new Student("james1", "bond1", "A1", 4);
        Person p2 = new Employee("james2", "bond2", "478-23-5204", 1784.456);
        Person p3= new Person("Praveen","Dhayalan");
        Student s1 = new Student("Ryan", "Donald", "", 3);
        Employee e2 = new Employee("Advith", "Shekar", "488-83-5906", 1784.456);

        double gpa = ((Student) p1).getGPA();
        double salary = ((Employee) p2).getSalary();

        String infoPerson = UserDefinedUtil.getPersonInfo(p1);
        String personDetails = UserDefinedUtil.getPersonInfo(p3);
        System.out.println(infoPerson);
        System.out.println(personDetails);

        try {
            s1.validateID();

        } catch (EmptyIdException ex) {
            System.err.print(ex);
        }

        boolean chkSSN = e2.validSSN();
        if (chkSSN == false) {
            throw new InvalidSSNException("Please input right SSN format : ***-**-****");
        }
    }
}