package com.thoughworks.ticketingapi.repository;

import java.util.HashMap;
import java.util.Map;

import com.thoughworks.ticketingapi.model.Station;

public final class StationRepository {

	private static StationRepository instance;

	private StationRepository () {
		
	}
	
	public static StationRepository getInstance() {
		if(null == instance) {
			instance = new StationRepository();
		}
		return instance;
	}
	
	public static String STATION_1 = "Chennai Beach";
	public static String STATION_2 = "Chennai Fort";
	public static String STATION_3 = "Chennai Park";
	public static String STATION_4 = "Chennai Egmore";
	public static String STATION_5 = "Chetpet";
	public static String STATION_6 = "Nungambakkam";
	public static String STATION_7 = "Kodambakkam";
	public static String STATION_8 = "Mambalam";
	public static String STATION_9 = "Saidapet";
	public static String STATION_10 = "Guindy";
	public static String STATION_11 = "St. Thomas Mount";
	public static String STATION_12 = "Pazhavanthangal";
	public static String STATION_13 = "Meenambakkam";
	public static String STATION_14 = "Thisulam";
	public static String STATION_15 = "Pallavaram";
	public static String STATION_16 = "Chromepat";
	public static String STATION_17 = "Tambaram Santorium";
	public static String STATION_18 = "Tambaram";

	private static Map<String, Station> stationMap = new HashMap<String, Station>();

	
	public Map<String, Station> getAllStations() {
		return stationMap;
	}
	static {

		Station station1 = new Station.StationBuilder(STATION_1, null).build();
		Station station2 = new Station.StationBuilder(STATION_2, null).build();
		Station station3 = new Station.StationBuilder(STATION_3, null).build();
		Station station4 = new Station.StationBuilder(STATION_4, null).build();
		Station station5 = new Station.StationBuilder(STATION_5, null).build();
		Station station6 = new Station.StationBuilder(STATION_6, null).build();
		Station station7 = new Station.StationBuilder(STATION_7, null).build();
		Station station8 = new Station.StationBuilder(STATION_8, null).build();
		Station station9 = new Station.StationBuilder(STATION_9, null).build();
		Station station10 = new Station.StationBuilder(STATION_10, null).build();
		Station station11 = new Station.StationBuilder(STATION_11, null).build();
		Station station12 = new Station.StationBuilder(STATION_12, null).build();
		Station station13 = new Station.StationBuilder(STATION_13, null).build();
		Station station14 = new Station.StationBuilder(STATION_14, null).build();
		Station station15 = new Station.StationBuilder(STATION_15, null).build();
		Station station16 = new Station.StationBuilder(STATION_16, null).build();
		Station station17 = new Station.StationBuilder(STATION_17, null).build();
		Station station18 = new Station.StationBuilder(STATION_18, null).build();
		
		station1.addNeighbour(station2);
		station2.addNeighbour(station1, station3);
		station3.addNeighbour(station2, station4);
		station4.addNeighbour(station3, station5);
		station5.addNeighbour(station4, station6);
		station6.addNeighbour(station5, station7);
		station7.addNeighbour(station6, station8);
		station8.addNeighbour(station7, station9);
		station9.addNeighbour(station8, station10);
		station10.addNeighbour(station9, station11);
		station11.addNeighbour(station10, station12);
		station12.addNeighbour(station11, station13);
		station13.addNeighbour(station12, station14);
		station14.addNeighbour(station13, station15);
		station15.addNeighbour(station14, station16);
		station16.addNeighbour(station15, station17);
		station17.addNeighbour(station16, station18);
		station18.addNeighbour(station17);

		stationMap.put(station1.getName(), station1);
		stationMap.put(station2.getName(), station2);
		stationMap.put(station3.getName(), station3);
		stationMap.put(station4.getName(), station4);
		stationMap.put(station5.getName(), station5);
		stationMap.put(station6.getName(), station6);
		stationMap.put(station7.getName(), station7);
		stationMap.put(station8.getName(), station8);
		stationMap.put(station9.getName(), station9);
		stationMap.put(station10.getName(), station10);
		stationMap.put(station11.getName(), station11);
		stationMap.put(station12.getName(), station12);
		stationMap.put(station13.getName(), station13);
		stationMap.put(station14.getName(), station14);
		stationMap.put(station15.getName(), station15);
		stationMap.put(station16.getName(), station16);
		stationMap.put(station17.getName(), station17);
		stationMap.put(station18.getName(), station18);
	}

}
