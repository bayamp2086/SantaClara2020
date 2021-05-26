package com.bayamp.santaclara2020.data.utils;

import com.bayamp.santaclara2020.userdefined.objects.Employee;
import com.bayamp.santaclara2020.userdefined.objects.Person;
import com.bayamp.santaclara2020.userdefined.objects.Student;

public class UserDefinedUtil {

    public static String getPersonInfo(Person p) {
        String infoPerson = null;
        if (p instanceof Person) {
            infoPerson = p.toString();
        } else if (p instanceof Employee) {
            Employee e1 = (Employee) p;
            infoPerson = e1.toString();

        } else if (p instanceof Student) {
            Student s1 = (Student) p;
            infoPerson = s1.toString();
        }
        return infoPerson;
    }
}
