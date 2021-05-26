package com.bayamp.santaclara2020.userdefined.objects;

public abstract class Animal {

    int lifeExpectancy;
    int age;
    String food;
    String name;

    public Animal(int age,String food, String name){
        this.age=age;
        this.food=food;
        this.name=name;
    }

    public int updateAge()
    {
      int currentAge= age+3;
      return currentAge;
    }
    public abstract String animalSound();

    public boolean isMoreThanLifeExpectancy()
    {
        boolean isMoreThanLifeExpectancy=false;
        if(age>lifeExpectancy){
            System.out.println(name + " is living more than his life expectancy");
            isMoreThanLifeExpectancy = true;
        }else {
            System.out.println(name + " is not living more than his life expectancy");
        }
        return isMoreThanLifeExpectancy;
    }
    public int getAge(){
        System.out.println(name + " age is " + age);
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
}
