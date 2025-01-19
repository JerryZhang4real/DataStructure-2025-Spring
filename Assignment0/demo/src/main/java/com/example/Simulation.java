package com.example;

public class Simulation {
    public static void main(String[] args){

        Person p1 = new Person("Sam", "Altman");
        Person p2 = new Person("Elon", "Musk");
        Person p3 = new Person("Bill", "Gates");
        Person p4 = new Person("Jun", "Lei");

        Building building = new Building(3);

        p1.enterBuilding(building, 2);
        p2.enterBuilding(building, 3);
        p3.enterBuilding(building, 3);
        p4.enterBuilding(building, 2);
        building.enterElevatorRequest(p1, 2);
        building.enterElevatorRequest(p2, 3);
        building.enterElevatorRequest(p3, 3);
        building.enterElevatorRequest(p4, 2);
        
        building.startElevator();
    }
}
