package main;

/**
* Simulates an elevator system within a building. 
* The elevator processes job requests to transport people between floors 
* while maintaining a maximum occupancy limit.
* Known Bugs: None
*
* @author Jiarui Zhang
* jiaruiz@brandeis.edu
* 01 19 2025
* COSI 21A PA0
*/

public class Elevator {

    public static int maxOccupants = 3;
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

    public MyArray<Job> getJobsArray(){
        return this.jobs;
    }

    public void processAllJobs(){
        for(int i = 0; i < jobs.size(); i++){
            processJob(jobs.get(i));

            //if everyone in the elevator has exited, their corresponding jobs
            //will be removed from the job array, so the index here must be reset.
            if(i == maxOccupants-1){
                i = -1;
            }
        }

        this.location = 0;
        this.jobIndex = 0;
        this.jobs.clear();
    }

    public void processJob(Job job){

        int nextFloor = job.getToFloor();
        if(location > nextFloor){ //going down
            for(int i = location; i >= nextFloor; i--){
                if(i == 0){
                    location = 0;
                    System.out.println(Constants.ELEVATOR_AT_LOBBY);
                }else{
                    location = i;
                    System.out.println(Constants.ELEVATOR_AT_FLOOR + i);
                }
            }
        }else if(location < nextFloor){ //going up
            for(int i = location; i <=nextFloor; i++){
                if(i == 0){
                    location = 0;
                    System.out.println(Constants.ELEVATOR_AT_LOBBY);
                }else{
                    location = i;
                    System.out.println(Constants.ELEVATOR_AT_FLOOR + i);
                }
            }
        }else{ //same floor
            if(location == 0){
                System.out.println(Constants.ELEVATOR_AT_LOBBY);
                System.out.println(Constants.ELEVATOR_AT_LOBBY);
            }else{
                System.out.println(Constants.ELEVATOR_AT_FLOOR + location);
                System.out.println(Constants.ELEVATOR_AT_FLOOR + location);
            }
        }

        exit(job.getPerson(), job.getToFloor());
    }

    public void exit(Person person, int floor){
        jobIndex += 1;
        if(jobIndex == maxOccupants){ // remove jobs batch completed by the elevator
            for(int i = 0; i < maxOccupants; i++){
                jobs.remove(0);
            }
            jobIndex = 0;

            for(int i = floor-1; i > 0; i--){
                System.out.println(Constants.ELEVATOR_AT_FLOOR + i);
            }

            System.out.println(Constants.ELEVATOR_AT_LOBBY);

            location = 0;
        }

    }

    public String toString(){
        return jobs.toString();
    }
}