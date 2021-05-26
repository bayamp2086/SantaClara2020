package com.bayamp.santaclara2020.userdefined.objects;

public class Dog extends Animal {

    public Dog(String name,int age,String food){
        super(age,food,name);
        this.lifeExpectancy = 11;
    }
    public String animalSound() {
        return "Woof";
    }
}
