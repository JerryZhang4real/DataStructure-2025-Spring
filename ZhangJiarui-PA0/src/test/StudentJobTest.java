package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Building;
import main.Job;
import main.Person;

class StudentJobTest {

	@Test
    void testJobConstructorAndGetters() {
        Person person = new Person("John", "Doe");
        person.enterBuilding(new Building(5), 3); // Person wants to go to floor 3

        Job job = new Job(person);

        // Test that the Person object is correctly assigned
        assertEquals(person, job.getPerson(), "The Person object should match the one provided in the constructor.");

        // Test that the toFloor is correctly assigned
        assertEquals(3, job.getToFloor(), "The toFloor value should match the Person's destination floor.");
    }

    @Test
    void testToString() {
        Person person = new Person("Jane", "Smith");
        person.enterBuilding(new Building(5), 2); // Person wants to go to floor 2

        Job job = new Job(person);

        // Test the toString method
        String expected = "Job: " + person.toString();
        assertEquals(expected, job.toString(), "The toString method should return the correct string representation of the Job.");
    }

}
