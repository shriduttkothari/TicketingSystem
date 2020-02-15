package com.thoughworks.ticketingapi.controller;

import java.util.Currency;

import com.thoughworks.ticketingapi.model.Price;
import com.thoughworks.ticketingapi.model.StationRoute;

public class PricingController {

	private static final int BASE_PRICE = 10;
	private static final int STRETCH_PRICE = 20;
	private static final int PRICE_PER_FIVE_STATIONS = 5;
	
	private static PricingController instance;

	private PricingController() {
	}

	public static PricingController getInstance() {
		if (null == instance) {
			instance = new PricingController();
		}
		return instance;
	}

	public Price getPrice(StationRoute stationRoute, Currency currency) {
		int priceAmount;
		int stationDistance = stationRoute.getStops() + 1;
		if (stationDistance == 0) {
			throw new IllegalArgumentException("endStation is not reachable from startStation");
		} else if (stationDistance < 5) {
			priceAmount = BASE_PRICE;
		} else if (stationRoute.getFromStation().getPossibleNeighbours().size() == 1
				&& stationRoute.getToStation().getPossibleNeighbours().size() == 1) {
			priceAmount = STRETCH_PRICE;
		} else {

			int stationCount = stationDistance + 1 - 5;
			int factor = 0;
			if(stationCount % 5 != 0) {
				factor = (stationCount /5) + 1;	
			} else {
				factor = (stationCount /5);	
			}
			
			priceAmount = BASE_PRICE + (factor) * PRICE_PER_FIVE_STATIONS;
		}
		return new Price(priceAmount, currency);
	}

}
