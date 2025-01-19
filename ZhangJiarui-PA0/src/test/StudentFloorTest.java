package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Floor;
import main.Person;

class StudentFloorTest {

    @Test
    void testEnterFloor() {
        Floor floor = new Floor();

        Person p1 = new Person("Alice", "Smith");
        Person p2 = new Person("Bob", "Johnson");

        floor.enterFloor(p1);
        floor.enterFloor(p2);

        // Verify the number of people on the floor
        assertEquals(2, floor.getPeopleAtFloor().size(), "The floor should have 2 people.");
        assertEquals(p1, floor.getPeopleAtFloor().get(0), "The first person should be Alice Smith.");
        assertEquals(p2, floor.getPeopleAtFloor().get(1), "The second person should be Bob Johnson.");
    }

    @Test
    void testToStringNoPeople() {
        Floor floor = new Floor();

        // Verify the toString output
        assertEquals("No one at this floor now", floor.toString(), "The floor should report no people.");
    }

    @Test
    void testToStringWithPeople() {
        Floor floor = new Floor();

        Person p1 = new Person("Alice", "Smith");
        Person p2 = new Person("Bob", "Johnson");

        floor.enterFloor(p1);
        floor.enterFloor(p2);

        // Verify the toString output
        String expected = "Alice Smith, Bob Johnson";
        assertEquals(expected, floor.toString(), "The toString output should match the expected format.");
    }

}
