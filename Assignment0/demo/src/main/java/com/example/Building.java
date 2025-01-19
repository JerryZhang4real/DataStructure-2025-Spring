package com.example;

public class Building {

    private Floor[] floorArr;
    private Elevator elevator;

    public Building(int numFloors){
        this.floorArr = new Floor[numFloors];
        this.elevator = new Elevator();
    }

    public int getMaxFloorNum(){
        return this.floorArr.length;
    }

    public boolean enterElevatorRequest(Person person, int floor){
        if(floor <= this.getMaxFloorNum() || floor >= 1){
            elevator.createJob(person, floor);
            return true;
        }

        return false;
    }

    public void startElevator(){
        elevator.processAllJobs();
    }

    public void enterFloor(Person person, int floor){
        floorArr[floor].peopleAtFloor.add(person);
    }

    public String toString(){
        String building2String = "";
        for(int i = 1; i <= this.getMaxFloorNum(); i++){
            building2String += floorArr[i].toString() + "\n";
        }

        return building2String;
    }
}