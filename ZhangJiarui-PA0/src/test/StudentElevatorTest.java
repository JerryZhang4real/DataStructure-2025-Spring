package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Building;
import main.Elevator;
import main.Person;

class StudentElevatorTest {

	@Test
    void testCreateJob() {
        Elevator elevator = new Elevator();

        Person person = new Person("Steve", "Jobs");
        person.enterBuilding(new Building(5), 3); // Person wants to go to floor 3
        elevator.createJob(person, 3);

        // Verify the job is added to the jobs array
        assertEquals(1, elevator.getJobsArray().size(), "The job array should have 1 job.");
        assertEquals(person, elevator.getJobsArray().get(0).getPerson(), "The person in the job should be Steve Jobs.");
        assertEquals(3, elevator.getJobsArray().get(0).getToFloor(), "The job should have a destination floor of 3.");
    }

	@Test
    void testProcessAllJobs() {
        Elevator elevator = new Elevator();

        Person p1 = new Person("Bill", "Clinton");
        p1.enterBuilding(new Building(5), 2);
        elevator.createJob(p1, 2);

        Person p2 = new Person("Henry", "Biden");
        p2.enterBuilding(new Building(5), 3);
        elevator.createJob(p2, 3);

        Person p3 = new Person("Thomas", "Jefferson");
        p3.enterBuilding(new Building(5), 1);
        elevator.createJob(p3, 1);

        elevator.processAllJobs();

        // Verify that all jobs have been processed
        assertEquals(0, elevator.getJobsArray().size(), "The job array should be empty after all jobs are processed.");
    }

}
