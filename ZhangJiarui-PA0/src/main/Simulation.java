package main;

/**
* Simulates the interaction between people and an elevator system in a building. 
* Creates a building, adds people with destination floors, processes elevator requests, 
* and manages elevator operations.
* Known Bugs: None
*
* @author Jiarui Zhang
* jiaruiz@brandeis.edu
* 01 19 2025
* COSI 21A PA0
*/

public class Simulation {
    public static void main(String[] args){

        Building building = new Building(3);

        Person p1 = new Person("Sam", "Altman");
        Person p2 = new Person("Elon", "Musk");
        Person p3 = new Person("Bill", "Gates");
        Person p4 = new Person("Jun", "Lei");
        Person p5 = new Person("Steve", "Jobs");
        Person p6 = new Person("Jeff", "Bezos");

        p5.enterBuilding(building, 2);
        p6.enterBuilding(building, 3);
        building.enterElevatorRequest(p5, 2);
        building.enterElevatorRequest(p6, 3);

        System.out.println("Sample Output 1: ");
        building.startElevator();
        System.out.println("Sample Output 1 ends.\n");


        p1.enterBuilding(building, 2);
        p2.enterBuilding(building, 3);
        p3.enterBuilding(building, 3);
        p4.enterBuilding(building, 2);
        building.enterElevatorRequest(p1, 2);
        building.enterElevatorRequest(p2, 3);
        building.enterElevatorRequest(p3, 3);
        building.enterElevatorRequest(p4, 2);
        
        System.out.println("Sample Output 2: ");
        building.startElevator();
        System.out.println("Sample Output 2 ends.");

    }
}
