package com.thoughworks.ticketingapi;

import com.thoughworks.ticketingapi.controller.TicketController;
import com.thoughworks.ticketingapi.model.Ticket;
import com.thoughworks.ticketingapi.repository.StationRepository;

public class TicketManager {
	
	public static void main(String[] args) {
		TicketController ticketController = TicketController.getInstance();
		Ticket ticket = ticketController.getTicket(StationRepository.STATION_1, StationRepository.STATION_8);
		System.out.println(ticket.toString());
	}
}
