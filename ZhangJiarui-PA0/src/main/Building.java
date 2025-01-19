package main;

/**
* Represents a building with multiple floors and an elevator. 
* Allows people to request the elevator and move to specific floors.
* Also supports tracking people at each floor.
* Known Bugs: None
*
* Jiarui Zhang
* jiaruiz@brandeis.edu
* 01 19 2025
* COSI 21A PA0
*/

public class Building {

    private Floor[] floorArr;
    private Elevator elevator;

    public Building(int numFloors){
        this.floorArr = new Floor[numFloors+1];
        for(int i = 0; i < numFloors+1; i++){
            floorArr[i] = new Floor();
        }
        this.elevator = new Elevator();
    }

    public int getMaxFloorNum(){
        return this.floorArr.length;
    }

    public Elevator getElevator(){
        return this.elevator;
    }

    public Floor[] getFloors(){
        return this.floorArr;
    }

    public boolean enterElevatorRequest(Person person, int floor){
        if(floor <= this.getMaxFloorNum() && floor >= 1){
            elevator.createJob(person, floor);
            return true;
        }

        return false;
    }

    public void startElevator(){
        for(int i = 0; i < elevator.getJobsArray().size(); i++){
            enterFloor(elevator.getJobsArray().get(i).getPerson(), elevator.getJobsArray().get(i).getToFloor());
        }
        elevator.processAllJobs();
    }

    public void enterFloor(Person person, int floor){
        floorArr[floor].enterFloor(person);;
    }

    public String toString(){
        String building2String = "";
        for(int i = 1; i <= this.getMaxFloorNum(); i++){
            building2String += floorArr[i].toString() + "\n";
        }

        return building2String;
    }
}