package main;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

/**
* Represents the MBTA simulation system.
* This class initializes the railway, stations, trains, and riders using external files and simulates the MBTA operations
* for a fixed number of iterations.
* Known Bugs:  None 
*
* @Jiarui Zhang 
* jiaruiz@brandeis.edu 
* <02 23, 2025> 
* COSI 21A PA1
*/
public class MBTA {

	public static final int SOUTHBOUND = 1;
	public static final int NORTHBOUND = 0;
	
	static final int TIMES = 6;
	static Railway r;
	
	public static void main(String[] args) {

		runSimulation();
		
	}
	
	public static void runSimulation() {
		r = new Railway();

		initStations("redLine.txt");
		initTrains("trains.txt");
		initRiders("riders.txt");


		for (int i = 0; i < TIMES; i++) {
			System.out.print(r.simulate());
		}
	}
	
	public static void initTrains(String trainsFile) {
		try {
			Scanner trainFileScanner = new Scanner(new File(trainsFile));
			while (trainFileScanner.hasNextLine()) {
				if (!trainFileScanner.hasNextLine()) {
					throw new NoSuchElementException("Expected Station name, but no line found.");
				}
				String currentStation = trainFileScanner.nextLine();
				if(!trainFileScanner.hasNextLine()) {
					throw new NoSuchElementException("Expected direction, but no line found.");
				}
				int direction = Integer.parseInt(trainFileScanner.nextLine());

				Train train = new Train(currentStation, direction);
				r.addTrain(train);
			}

			trainFileScanner.close();

		} catch (FileNotFoundException e){
			System.err.println(" File not found" + trainsFile);
		}
	}
	
	public static void initRiders(String ridersFile) {
		try {
			Scanner riderFileScanner = new Scanner(new File(ridersFile));
			while (riderFileScanner.hasNextLine()) {
				if (!riderFileScanner.hasNextLine()) {
					throw new NoSuchElementException("Expected Station name, but no line found.");
				}
				String riderID = riderFileScanner.nextLine();
				if(!riderFileScanner.hasNextLine()) {
					throw new NoSuchElementException("Expected direction, but no line found.");
				}
				String startStation = riderFileScanner.nextLine();
				if(!riderFileScanner.hasNextLine()) {
					throw new NoSuchElementException("Expected direction, but no line found.");
				}
				String destinationStation = riderFileScanner.nextLine();


				Rider rider = new Rider(riderID, startStation, destinationStation);
				r.addRider(rider);
			}

			riderFileScanner.close();

		} catch (FileNotFoundException e){
			System.err.println(" File not found" + ridersFile);
		}
	}
	
	public static void initStations(String stationsFile) {
		try {
			Scanner stationFileScanner = new Scanner(new File(stationsFile));
			while (stationFileScanner.hasNextLine()) {
				if (!stationFileScanner.hasNextLine()) {
					throw new NoSuchElementException("Expected Station name, but no line found.");
				}
				String stationName = stationFileScanner.nextLine();

				Station station = new Station(stationName);
				r.addStation(station);
			}

			stationFileScanner.close();

		} catch (FileNotFoundException e){
			System.err.println(" File not found" + stationsFile);
		}
	}
}
