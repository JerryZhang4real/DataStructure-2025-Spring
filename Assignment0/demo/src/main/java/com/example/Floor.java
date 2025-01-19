package com.example;

public class Floor{
    MyArray<Person> peopleAtFloor;

    public Floor(/*add some params here maybe */){
        peopleAtFloor = new MyArray<Person>();
    }

    public void enterFloor(Person person){
        peopleAtFloor.add(person);
    }

    public String toString(){
        return peopleAtFloor.toString();
    }
}
