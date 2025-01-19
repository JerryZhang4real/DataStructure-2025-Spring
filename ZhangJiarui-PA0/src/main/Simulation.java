package main;

/**
* Simulates the interaction between people and an elevator system in a building. 
* Creates a building, adds people with destination floors, processes elevator requests, 
* and manages elevator operations.
* Known Bugs: None
*
* Jiarui Zhang
* jiaruiz@brandeis.edu
* 01 19 2025
* COSI 21A PA0
*/

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

        // for(int i = 1; i <= building.getMaxFloorNum(); i++){
        //     System.out.println(building.getFloors()[i].toString());
        // }

    }
}
