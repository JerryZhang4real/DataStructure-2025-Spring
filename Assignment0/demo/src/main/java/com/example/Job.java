package com.example;

/**
* Represents a job for the elevator system. 
* Each job contains a person and their target floor, allowing the elevator to process their request.
* Known Bugs: None
*
* Jiarui Zhang
* jiaruiz@brandeis.edu
* 01 19 2025
* COSI 21A PA0
*/

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
