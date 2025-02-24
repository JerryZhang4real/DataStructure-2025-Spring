package main;

import java.util.NoSuchElementException;

/**
* Represents the railway system as a doubly linked list of stations.
* This class maintains an ordered collection of stations along with an array
* of station names for quick lookup. It supports adding stations, riders, and trains,
* and simulating one run of the MBTA system by moving trains and boarding/disembarking riders.
* Known Bugs:  None 
*
* @ Jiarui Zhang 
* jiaruiz@brandeis.edu 
* <02 23, 2025> 
* COSI 21A PA1
*/
public class Railway {

	public DoubleLinkedList<Station> railway;
	public String[] stationNames;

	private int stationIndex;
	
	public Railway() {
		railway = new DoubleLinkedList<>();
		stationNames = new String[18];
		stationIndex = 0;
	}
	
	public void addStation(Station s) {

		for (int i = 0; i < stationIndex; i++){
			if (stationNames[i].equals(s.stationName())) {
				throw new IllegalArgumentException("Station: " + s.stationName() + "already exists");
			}
		}

		railway.insert(s);
		stationNames[stationIndex] = s.stationName();
		stationIndex++;
	}
	
	public void addRider(Rider r) {
		setRiderDirection(r);
		Node<Station> stationNode = railway.getFirst();
		
		while (stationNode != null) {
			Station startStation = stationNode.getData();
			if (startStation.stationName().equals(r.getStarting())) {
				if (r.goingNorth()) {
					startStation.northBoundRiders.enqueue(r);
				} else {
					startStation.southBoundRiders.enqueue(r);
				}

				return;
			}

			stationNode = stationNode.getNext();
		}

		throw new NoSuchElementException("The rider's starting Station: " + r.getStarting() + " does not exists in this railway");

	}
	
	public void addTrain(Train t) {
		Node<Station> stationNode = railway.getFirst();
		while (stationNode != null) {
			if (t.getStation().equals(stationNode.getData().stationName())) {
				Station station = stationNode.getData();
				if (t.goingNorth()) {
					station.northBoundTrains.enqueue(t);
				} else {
					station.southBoundTrains.enqueue(t);
				}

				return;
			}

			stationNode = stationNode.getNext();
		}

		throw new NoSuchElementException("There is no Station: " + t.getStation() + " in this railway");
	}
	
	public void setRiderDirection(Rider r) {
		String startStation = null;
		String destinationStation = null;

		for (int i = 0; i < stationNames.length; i++) {
			if (stationNames[i].equals(r.getStarting())) {
				startStation = stationNames[i];
			}

			if (stationNames[i].equals(r.getDestination())) {
				destinationStation = stationNames[i];
			}

			if (startStation != null && destinationStation == null) {
				return;
			}

			if (startStation == null && destinationStation != null) {
				r.swapDirection();
				return;
			}
		}
	}
	
	public String simulate() {
		String railwayLog = "Simulating one run of MBTA. \n";
		Node<Station> stationNode = railway.getFirst();

		while (stationNode != null) {
			Station station = stationNode.getData();
			railwayLog += station.toString();

			if (!station.stationName().equals("Braintree") && !station.stationName().equals("Alewife")) {
				Station nextStation = stationNode.getNext().getData();
				Station prevStation = stationNode.getPrev().getData();
				Train northTrain = station.northBoardTrain();
				if (northTrain != null) {
					railwayLog += prevStation.addTrain(northTrain);
				}

				Train southTrain = station.southBoardTrain();
				if (southTrain != null) {
					railwayLog += nextStation.addTrain(southTrain);
				}
			} else {
				if (station.stationName().equals("Braintree")) {
					Station prevStation = stationNode.getPrev().getData();
					if (station.northBoundTrains.size() > 0) {
						Train northTrain = station.northBoardTrain();
						railwayLog += prevStation.addTrain(northTrain);
					}

					if (station.southBoundTrains.size() > 0) {
						station.moveTrainSouthToNorth();
					}

				}

				if (station.stationName().equals("Alewife")) {
					Station nextStation = stationNode.getNext().getData();
					if (station.southBoundTrains.size() > 0) {
						Train southTrain = station.southBoardTrain();
						railwayLog += nextStation.addTrain(southTrain);
					}

					if (station.northBoundTrains.size() > 0) {
						station.moveTrainNorthToSouth();
					} 
				}

			}

			stationNode = stationNode.getNext();
			
		}

		return railwayLog + "\n\n------------------\n\n\n\n";
	}
	
	@Override
	public String toString() {
		String railway2String = "";
		Node<Station> stationNode = railway.getFirst();
		while (stationNode != null) {
			railway2String += stationNode.getData().toString() + "\n";
		}

		return railway2String;
	}
}
