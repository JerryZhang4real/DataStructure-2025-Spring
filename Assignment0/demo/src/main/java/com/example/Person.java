package com.example;

public class Person {
    private String firstName;
    private String lastName;
    private int toFloor;
    private int atFloor;

    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.toFloor = -1;
        this.atFloor = 0;
    }

    public boolean enterBuilding(Building building, int floor){
        if(floor <= building.getMaxFloorNum()){
            this.toFloor = floor;
            return true;
        }

        return false;
    }

    public int getToFloor(){
        return this.toFloor;
    }

    public String getLocation(){
        String status = "";

        if(this.toFloor == -1){
            status = "In Lobby";
        }

        if(this.toFloor != -1 && this.atFloor == 0){
            status = "Waiting to be serviced";
        }

        if(this.atFloor != 0){
            status = "In Floor " + this.atFloor; 
        }

        return status;
    }

    public String toString(){
        return this.firstName + " " + this.lastName + " to floor " + this.toFloor;
    }
}
