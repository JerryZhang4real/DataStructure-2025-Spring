package com.example;

/**
* Simulates an elevator system within a building. 
* The elevator processes job requests to transport people between floors 
* while maintaining a maximum occupancy limit.
* Known Bugs: None
*
* Jiarui Zhang
* jiaruiz@brandeis.edu
* 01 19 2025
* COSI 21A PA0
*/

public class Elevator {

    private static int maxOccupants = 3;
    private int location;
    private MyArray<Job> jobs;
    private int jobIndex;

    public Elevator(){
        this.location = 0;
        this.jobIndex = 0;
        this.jobs = new MyArray<Job>();

    }

    public void createJob(Person person, int floor){
        Job newJob = new Job(person);
        jobs.add(newJob);
    }

    public void processAllJobs(){
        for(int i = 0; i < jobs.size(); i++){
            processJob(jobs.get(i));

            if(i == maxOccupants-1){
                i = -1;
            }
        }
    }

    public void processJob(Job job){
        //System.out.println("Elevator at floor " + location);

        int nextFloor = job.getToFloor();
        if(location > nextFloor){
            for(int i = location; i >= nextFloor; i--){
                if(i == 0){
                    location = 0;
                    System.out.println("Elevator at Lobby");
                }else{
                    location = i;
                    System.out.println("Elevator at floor " + i);
                }
            }
        }else if(location < nextFloor){
            for(int i = location; i <=nextFloor; i++){
                if(i == 0){
                    location = 0;
                    System.out.println("Elevator at Lobby");
                }else{
                    location = i;
                    System.out.println("Elevator at floor " + i);
                }
            }
        }else{
            if(location == 0){
                System.out.println("Elevator at Lobby");
                System.out.println("Elevator at Lobby");
            }else{
                System.out.println("Elevator at floor " + location);
                System.out.println("Elevator at floor " + location);
            }
        }

        exit(job.getPerson(), job.getToFloor());
    }

    public void exit(Person person, int floor){
        jobIndex += 1;
        if(jobIndex == maxOccupants){
            for(int i = 0; i < maxOccupants; i++){
                jobs.remove(0);
            }
            jobIndex = 0;

            for(int i = floor-1; i > 0; i--){
                System.out.println("Elevator at floor " + i);
            }

            System.out.println("Elevator at Lobby");

            location = 0;
        }

    }

    public String toString(){
        return jobs.toString();
    }
}
