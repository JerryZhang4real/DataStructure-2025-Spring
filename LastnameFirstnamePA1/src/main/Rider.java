package main;

/**
* Represents a rider in the train system.
* This class encapsulates a rider's unique ID, starting station, destination station,
* and their current travel direction (north or not north). It provides methods to
* retrieve these details, swap the travel direction, and check equality based on riderID.
* Known Bugs:  None 
*
* @ Jiarui Zhang 
* jiaruiz@brandeis.edu 
* <02 23, 2025> 
* COSI 21A PA1
*/
public class Rider {

	private String riderID;
	private String startingStation;
	private String destinationStation;
	private boolean isGoingNorth;

	public Rider(String riderID, String startingStation, String destinationStation) {
		this.riderID = riderID;
		this.startingStation = startingStation;
		this.destinationStation = destinationStation;
		this.isGoingNorth = false;
	}
	
	public String getStarting() {
		return startingStation;
	}
	
	public String getDestination() {
		return destinationStation;
	}
	
	public String getRiderID() {
		return riderID;
	}
	
	public boolean goingNorth() {	
		return isGoingNorth;
	}
	
	public void swapDirection() {
		isGoingNorth = !isGoingNorth;
	}
	
	@Override
	public String toString() {
		// adjust according to the PA's requirement
		return null;
	}
	
	@Override
	public boolean equals(Object s) {
		if (this == s){
			return true;
		}

		if (s == null || getClass() != s.getClass()){
			return false;
		}

		Rider other = (Rider) s;

		return this.getRiderID() == other.getRiderID();
	}
}
