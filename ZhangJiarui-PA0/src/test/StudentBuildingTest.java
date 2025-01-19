package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.Building;

class StudentBuildingTest {

	@Test
	void testGetMaxFloorNum() {
		Building building = new Building(3);
		
		Assertions.assertEquals(3, building.getMaxFloorNum());
	}
}
