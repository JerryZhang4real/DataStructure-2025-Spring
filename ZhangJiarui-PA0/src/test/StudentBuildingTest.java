package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.Building;
import main.Person;

class StudentBuildingTest {

	@Test
	void testGetMaxFloorNum() {
		Building building = new Building(3);
		
		Assertions.assertEquals(3, building.getMaxFloorNum(), "Building should have 3 floors.");
	}

	@Test
	void testEnterElevatorRequest(){
		Building building = new Building(3);
		Person p1 = new Person("Sam", "Altman");

		p1.enterBuilding(building, 4);
		Assertions.assertFalse(building.enterElevatorRequest(p1, 4), "Request for floor 4 should fail.");
		Assertions.assertTrue(building.getElevator().getJobsArray().isEmpty(), "Elevator job list should remain empty.");

		p1.enterBuilding(building, -1);
		Assertions.assertFalse(building.enterElevatorRequest(p1, -1), "Request for negative floor should fail.");
		Assertions.assertTrue(building.getElevator().getJobsArray().isEmpty(), "Elevator job list should remain empty.");

		p1.enterBuilding(building, 3);
		Assertions.assertTrue(building.enterElevatorRequest(p1, 3), "Request for floor 3 should succeed.");
		Assertions.assertEquals("Job: Sam Altman to floor 3 ", building.getElevator().getJobsArray().toString(), "Elevator job list should include a job for Sam Altman to floor 3.");
	}

	@Test
	void testEnterFloor(){
		Building building = new Building(3);
		Person p1 = new Person("Sam", "Altman");

		building.enterFloor(p1, 2);
		Assertions.assertEquals("Sam Altman", building.getFloors()[2].toString(), "Floor 2 should list 'Sam Altman' as present.");
	}
}
