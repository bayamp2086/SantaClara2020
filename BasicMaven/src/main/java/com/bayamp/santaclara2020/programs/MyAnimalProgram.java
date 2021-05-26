package com.bayamp.santaclara2020.programs;

import com.bayamp.santaclara2020.userdefined.objects.Animal;
import com.bayamp.santaclara2020.userdefined.objects.Cat;
import com.bayamp.santaclara2020.userdefined.objects.Dog;

public class MyAnimalProgram {
    public static void main(String[] args) {
        Animal a1 = new Cat("Danny",10,"Greens");
        Animal a2 = new Dog("Nickel",9,"Meat");

        a1.isMoreThanLifeExpectancy();

        int updatedAge = a2.updateAge();
        a2.setAge(updatedAge);
        int chkAnimalAge = a2.getAge();
        a2.isMoreThanLifeExpectancy();
    }
}
