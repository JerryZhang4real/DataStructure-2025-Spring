package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import main.Person;
import main.Building;
import main.Constants;

class StudentPersonTest {

    @Test
    void testConstructorAndGetName() {
        Person person = new Person("Alice", "Wonderland");

        // Verify the name is correct
        assertEquals("Alice Wonderland", person.getName(), "The full name should be 'Alice Wonderland'.");
    }

    @Test
    void testEnterBuilding() {
        Person person = new Person("Bob", "Johnson");
        Building building = new Building(5);

        assertTrue(person.enterBuilding(building, 3), "Entering a valid floor should return true.");
        assertEquals(3, person.getToFloor(), "The destination floor should be set to 3.");

        assertFalse(person.enterBuilding(building, 6), "Entering an invalid floor should return false.");
        assertEquals(3, person.getToFloor(), "The destination floor should remain 3 after an invalid entry.");
    }

    @Test
    void testGetLocationInLobby() {
        Person person = new Person("Jack", "Sparrawl");
        assertEquals(Constants.PERSON_IN_LOBBY, person.getLocation(), "The initial location should be 'In Lobby'.");
    }

    @Test
    void testGetLocationWaitingToBeServiced() {
        // Create a Person and simulate entering a building
        Person person = new Person("David", "Jones");
        Building building = new Building(5);
        person.enterBuilding(building, 3);

        // Verify the location
        assertEquals(Constants.PERSON_WAITING_TO_BE_SERVICED, person.getLocation(), "The location should be 'Waiting to be serviced'.");
    }

    @Test
    void testGetLocationOnFloor() {
        Person person = new Person("Mieachal", "Jackson");
        person.enterBuilding(new Building(5), 3);

        person.getLocation(); // should initially be waiting
        person.setAtFloor(3); // Manually simulate the floor

        // Verify the location
        assertEquals(Constants.PERSON_IN_FLOOR + 3, person.getLocation(), "The location should be 'In Floor 3'.");
    }

    @Test
    void testToString() {
        Person person = new Person("Frank", "Ocean");
        person.enterBuilding(new Building(5), 4);

        // Verify the string representation
        assertEquals("Frank Ocean to floor 4", person.toString());
    }
}
