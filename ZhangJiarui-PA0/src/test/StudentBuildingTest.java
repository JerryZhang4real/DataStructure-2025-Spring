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
		
		Assertions.assertEquals(3, building.getMaxFloorNum());
	}

	@Test
	void testEnterElevatorRequest(){
		Building building = new Building(3);
		Person p1 = new Person("Sam", "Altman");

		p1.enterBuilding(building, 4);
		Assertions.assertFalse(building.enterElevatorRequest(p1, 4));
		Assertions.assertTrue(building.getElevator().getJobsArray().isEmpty());

		p1.enterBuilding(building, -1);
		Assertions.assertFalse(building.enterElevatorRequest(p1, -1));
		Assertions.assertTrue(building.getElevator().getJobsArray().isEmpty());

		p1.enterBuilding(building, 3);
		Assertions.assertTrue(building.enterElevatorRequest(p1, 3));
		Assertions.assertEquals("Job: Sam Altman to floor 3 ", building.getElevator().getJobsArray().toString());
	}

	@Test
	void testEnterFloor(){
		Building building = new Building(3);
		Person p1 = new Person("Sam", "Altman");

		building.enterFloor(p1, 2);
		Assertions.assertEquals("Sam Altman", building.getFloors()[2].toString());
	}
}
