package com.thoughworks.ticketingapi.controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

import com.thoughworks.ticketingapi.model.Station;
import com.thoughworks.ticketingapi.model.StationRoute;

public class RouteController {

	private static RouteController instance;

	private RouteController() {
	}

	public static RouteController getInstance() {
		if (null == instance) {
			instance = new RouteController();
		}
		return instance;
	}

	public StationRoute getStationRoute(Station sourceStation, Station endStation) {
		int edges = getPathCount(sourceStation, endStation);
		StationRoute stationRoute = new StationRoute(sourceStation, endStation, edges-1);
		return stationRoute;
	}

	// return BFS traversal from a given source source
	private int getPathCount(Station sourceNode, Station destinationNode) {
		int graphLengthTravelled = 0;
		HashSet<Station> visited = new HashSet<Station>();
		// Create a queue for BFS
		LinkedList<Station> queue = new LinkedList<Station>();

		// Mark the current node as visited and enqueue it
		visited.add(sourceNode);
		queue.add(sourceNode);

		// 'nodeIterator' will be used to get all adjacent stations of a station
		Iterator<Station> nodeIterator;
		while (queue.size() != 0) {
			// Dequeue a station from queue
			sourceNode = queue.poll();

			Station currentStation;
			nodeIterator = sourceNode.getPossibleNeighbours().iterator();
			graphLengthTravelled++;
			while (nodeIterator.hasNext()) {

				currentStation = nodeIterator.next();
				if (currentStation.equals(destinationNode)) {
					return graphLengthTravelled;
				}

				if (!visited.contains(currentStation)) {
					visited.add(currentStation);
					queue.add(currentStation);
				}
			}
		}
		return graphLengthTravelled;
	}
}
