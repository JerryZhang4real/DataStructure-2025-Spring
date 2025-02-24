package main;

/**
* Represents a station in the train system.
* This class manages queues for north-bound and south-bound riders and trains.
* It provides methods to add riders and trains, board trains, move trains between directions,
* and retrieve a string representation of the station's current status.
* Known Bugs:  None 
*
* @ Jiarui Zhang 
* jiaruiz@brandeis.edu 
* <02 23, 2025> 
* COSI 21A PA1
*/
public class Station {

	public Queue<Rider> northBoundRiders;
	public Queue<Rider> southBoundRiders;
	public Queue<Train> northBoundTrains;
	public Queue<Train> southBoundTrains;

	private String stationName;
	
	public Station(String name) {
		stationName = name;
		northBoundRiders = new Queue<Rider>(20);
		southBoundRiders = new Queue<Rider>(20);
		northBoundTrains = new Queue<Train>(20);
		southBoundTrains = new Queue<Train>(20);
	}
	
	public boolean addRider(Rider r) {
		if (r.getStarting().equals(stationName)) {
			if (r.goingNorth()) {
				northBoundRiders.enqueue(r);
			} else {
				southBoundRiders.enqueue(r);
			}

			return true;
		} 

		return false;
	}
	
	public String addTrain(Train t) {
		String disembarkingPassengers = stationName + " Disembarking Passengers: \n";

		t.updateStation(stationName);

		if (t.goingNorth()) {
			northBoundTrains.enqueue(t);
		} else {
			southBoundTrains.enqueue(t);
		}

		String buffer = t.disembarkPassengers();
		if (!buffer.equals("")) {
			disembarkingPassengers += buffer;
		} else {
			disembarkingPassengers = "";
		}

		return disembarkingPassengers;
	}
	
	public Train southBoardTrain() {
		if (southBoundTrains.size() > 0) {
			Train t = southBoundTrains.front();
			southBoundTrains.dequeue();

			while(southBoundRiders.size() > 0) {
				if (t.addPassenger(southBoundRiders.front())){
					southBoundRiders.dequeue();
				} else {
					break;
				}

			}

			return t;
		}

		return null;
	}
	
	public Train northBoardTrain() {
		if (northBoundTrains.size() > 0) {
			Train t = northBoundTrains.front();
			northBoundTrains.dequeue();

			while(northBoundRiders.size() > 0) {
				if (t.addPassenger(northBoundRiders.front())){
					northBoundRiders.dequeue();
				} else {
					break;
				}

			}

			return t;
		}

		return null;
	}
	
	public void moveTrainNorthToSouth() {
		Train t = northBoundTrains.front();
		t.swapDirection();

		northBoundTrains.dequeue();
		southBoundTrains.enqueue(t);
	}
	
	public void moveTrainSouthToNorth() {
		Train t = southBoundTrains.front();
		t.swapDirection();

		southBoundTrains.dequeue();
		northBoundTrains.enqueue(t);
	}
	
	@Override
	public String toString() {
		//adjust according to the PA's requirement
		String station2String = "";
		station2String += "Station: " + stationName + "\n";
		station2String += northBoundTrains.size() + " north-bound trains waiting\n";
		station2String += southBoundTrains.size() + " south-bound trains waiting\n";
		station2String += northBoundRiders.size() + " north-bound passengers waiting\n";
		station2String += southBoundRiders.size() + " south-bound passengers waiting\n";

		return station2String + "\n";
	}
	
	public String stationName() {
		return stationName;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || o.getClass() != this.getClass()){
			return false;
		}

		Station other = (Station) o;
		
		return this.stationName == other.stationName;
	}
}
