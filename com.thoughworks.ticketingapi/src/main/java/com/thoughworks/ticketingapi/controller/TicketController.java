package com.thoughworks.ticketingapi.controller;

import java.util.Currency;
import java.util.Map;

import com.thoughworks.ticketingapi.model.Price;
import com.thoughworks.ticketingapi.model.Station;
import com.thoughworks.ticketingapi.model.StationRoute;
import com.thoughworks.ticketingapi.model.Ticket;
import com.thoughworks.ticketingapi.repository.StationRepository;

public final class TicketController {

	private static TicketController instance;
	private static StationRepository stationRepository;
	
	private TicketController(StationRepository stationRepository) {
		TicketController.stationRepository = stationRepository;
	}
	
	public static TicketController getInstance() {
		if(null == instance) {
			instance = new TicketController(StationRepository.getInstance());
		}
		return instance;
	}
	
	public Ticket getTicket(String startStationName, String endStationName) {
		Map<String, Station> allStations = stationRepository.getAllStations();
		validateStationsExists(startStationName, endStationName, allStations);
		
		Station startStation = allStations.get(startStationName);
		Station endStation = allStations.get(endStationName);
		
		StationRoute stationRoute = RouteController.getInstance().getStationRoute(startStation, endStation);
		Price price = PricingController.getInstance().getPrice(stationRoute, Currency.getInstance("INR"));
		
		return new Ticket(stationRoute, price);
	}

	private static void validateStationsExists(String startStationName, String endStationName, Map<String, Station> allStations) {
		if(!allStations.containsKey(startStationName) || !allStations.containsKey(endStationName)) {
			throw new IllegalArgumentException("Invalid Station Name");
		} 
	}
	
}
