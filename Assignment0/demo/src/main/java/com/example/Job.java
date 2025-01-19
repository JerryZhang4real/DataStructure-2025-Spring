package com.example;

public class Job {
    private Person person;
    private int toFloor;
    
    public Job(Person person){
        this.person = person;
        this.toFloor = person.getToFloor();
    }

    public int getToFloor(){
        return this.toFloor;
    }

    public Person getPerson(){
        return this.person;
    }

    public String toString(){
        return "Job: " + person.toString();
    }
}
