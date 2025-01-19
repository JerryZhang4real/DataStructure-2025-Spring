package main;

/**
* Represents a person who interacts with a building and its elevator system. 
* Tracks the person's name, current floor, destination floor, and location status.
* Provides functionality for entering a building and retrieving location details.
* Known Bugs: None
*
* Jiarui Zhang
* jiaruiz@brandeis.edu
* 01 19 2025
* COSI 21A PA0
*/

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
            status = Constants.PERSON_IN_LOBBY;
        }

        if(this.toFloor != -1 && this.atFloor == 0){
            status = Constants.PERSON_WAITING_TO_BE_SERVICED;
        }

        if(this.atFloor != 0){
            status = Constants.PERSON_IN_FLOOR + this.atFloor; 
        }

        return status;
    }

    public String toString(){
        return this.firstName + " " + this.lastName + " to floor " + this.toFloor;
    }
}
