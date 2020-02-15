package com.thoughworks.ticketingapi.model;

import java.util.HashSet;

public final class Station {

	private String name;
	private HashSet<Station> possibleNeighbours;

	private Station(StationBuilder stationBuilder) {
		super();
		this.name = stationBuilder.name;
		this.possibleNeighbours = stationBuilder.possibleNeighbours;
	}

	public void addNeighbour(Station ... stations) {
		for(Station station: stations) {
			if (this.equals(station)) {
				throw new IllegalArgumentException("Can not add own as neighbour");
			}
			if(null == possibleNeighbours) {
				possibleNeighbours = new HashSet<Station>();
			}
			possibleNeighbours.add(station);
		}		
	}

	public HashSet<Station> getPossibleNeighbours() {
		return possibleNeighbours;
	}

	public boolean isDistinct() {
		return possibleNeighbours.size() == 1;
	}

	public String getName() {
		return name;
	}

	public static class StationBuilder {

		private String name;
		private HashSet<Station> possibleNeighbours;

		public Station build() {
			Station station = new Station(this);
			validateStationObject(station);
			return station;
		}

		private void validateStationObject(Station station) {
			if (null == station.name) {
				throw new IllegalArgumentException("Station Name is mandatory");
			}
		}

		public StationBuilder(String name, HashSet<Station> possibleNeighbours) {
			super();
			this.name = name;
			this.possibleNeighbours = possibleNeighbours;
		}

		public StationBuilder name(String name) {
			this.name = name;
			return this;
		}

		public StationBuilder isDistinct(boolean isDistinct) {
			return this;
		}

		public StationBuilder possibleNeibours(HashSet<Station> possibleNeibours) {
			this.possibleNeighbours = possibleNeibours;
			return this;
		}
	}
}
