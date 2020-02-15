package com.thoughworks.ticketingapi.model;

public class StationRoute {
	private Station fromStation;
	private Station toStation;
	private int stops;

	public StationRoute(Station fromStation, Station toStation, int stops) {
		super();
		this.fromStation = fromStation;
		this.toStation = toStation;
		this.stops = stops;
	}

	public Station getFromStation() {
		return fromStation;
	}

	public void setFromStation(Station fromStation) {
		this.fromStation = fromStation;
	}

	public Station getToStation() {
		return toStation;
	}

	public void setToStation(Station toStation) {
		this.toStation = toStation;
	}

	public int getStops() {
		return stops;
	}

	public void setStops(int stops) {
		this.stops = stops;
	}

}
