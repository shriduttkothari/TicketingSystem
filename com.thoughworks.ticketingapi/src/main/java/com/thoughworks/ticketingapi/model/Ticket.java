package com.thoughworks.ticketingapi.model;

public class Ticket {

	private StationRoute stationRoute;
	private Price price;

	public Ticket(StationRoute stationRoute, Price price) {
		super();
		this.stationRoute = stationRoute;
		this.price = price;
	}

	public StationRoute getStationRoute() {
		return stationRoute;
	}

	public void setStationRoute(StationRoute stationRoute) {
		this.stationRoute = stationRoute;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder ticketStirngBuilder = new StringBuilder();
		ticketStirngBuilder.append("Purchace Date & Time");
		ticketStirngBuilder.append("\n");
		ticketStirngBuilder.append(stationRoute.getFromStation().getName());
		ticketStirngBuilder.append("\n");
		ticketStirngBuilder.append(stationRoute.getToStation().getName());
		ticketStirngBuilder.append("\n");
		ticketStirngBuilder.append(stationRoute.getStops() + " Stops");
		ticketStirngBuilder.append("\n");
		ticketStirngBuilder.append(price.getCurrency().getSymbol() +" "+ price.getValue());
		return ticketStirngBuilder.toString();
	}
}
