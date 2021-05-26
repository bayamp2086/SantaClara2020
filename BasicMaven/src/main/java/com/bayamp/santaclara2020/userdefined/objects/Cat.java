package com.bayamp.santaclara2020.userdefined.objects;

public class Cat extends Animal {

    public Cat(String name,int age,String food){
        super(age,food,name);
        this.lifeExpectancy = 15;
    }

    public String animalSound() {
        return "Meow";
    }
}
