package main;

/**
* Represents a train in the rail system that carries riders.
* This class maintains the current station of the train, the direction it is traveling 
* (0 for northbound, 1 for southbound), and an array of riders as passengers.
* It provides methods to add and disembark passengers, swap travel direction, and update the station.
* Known Bugs:  None 
*
* @ Jiarui Zhang 
* jiaruiz@brandeis.edu 
* <02 23, 2025> 
* COSI 21A PA1
*/
public class Train {

	public static final int TOTAL_PASSENGERS = 10;
	public Rider[] passengers;
	public int passengerIndex;

	private String currentStation;
	private int direction;
	
	public Train(String currentStation, int direction) {
		this.passengers = new Rider[TOTAL_PASSENGERS];
		this.currentStation = currentStation;
		this.passengerIndex = 0;
		this.direction = direction;

		if(!(this.direction == 0 || this.direction == 1)){
			throw new IllegalArgumentException("The direction was expected to be 0 or 1 but got " + this.direction);
		}

	}
	
	public boolean goingNorth() {
		if (direction == 0) {
			return true;
		}

		return false;
	}
	
	public void swapDirection() {
		if (direction == 0){
			direction = 1;
		} else {
			direction = 0;
		}
	}
	
	public String currentPassengers() {
		String passengers2String = "";

		for (int i = 0; i < passengerIndex; i++) {
			passengers2String += passengers[i].getRiderID() + ", " + currentStation + "\n";
		}

		return passengers2String;
	}
	
	public boolean addPassenger(Rider r) {
		if (r != null && r.getStarting().equals(currentStation) && r.goingNorth() == goingNorth() && hasSpaceForPassengers() ){
			passengers[passengerIndex] = r;
			passengerIndex++;

			return true;
		}

		return false;
	}
	
	public boolean hasSpaceForPassengers() {
		return passengerIndex < TOTAL_PASSENGERS;
	}
	
	public String disembarkPassengers() {
		String removedPassengers = "";
		for (int i = 0; i < passengerIndex; i++){
			if (passengers[i].getDestination().equals(currentStation)) {
				removedPassengers += passengers[i].getRiderID() + ", " + currentStation + "\n";
				passengers[i] = null;	
				passengerIndex--;		
			}
		}

		int idx = 0;
		int left = 0;
		int right = 0;

		while (idx < passengerIndex) {
			if (passengers[right] != null) {
				passengers[left] = passengers[right];
				idx++;
				right++;
				left++;
			} else {
				right++;
			}
		}

		for(int i = passengerIndex; i < TOTAL_PASSENGERS; i++){
			passengers[i] = null;
		}


		return removedPassengers;
	}
	
	public void updateStation(String s) {
		currentStation = s;
	}
	
	public String getStation() {
		return currentStation;
	}
	
	@Override
	public String toString() {
		// adjust according to the PA's requirement
		String train2String = "";
		if (goingNorth()) {
			train2String += "Northbound train (at " + currentStation + ")";
		} else {
			train2String += "Southbound train (at " + currentStation + ")";
		}

		return train2String;
	}
}
