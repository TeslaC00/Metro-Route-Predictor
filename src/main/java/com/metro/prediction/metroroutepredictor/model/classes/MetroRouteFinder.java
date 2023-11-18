/**
 * The MetroRouteFinder class implements a route finder that provides various types of routes between two metro stations.
 *
 * <p>It utilizes different route finding algorithms for finding the shortest, most comfortable, and cheapest routes.</p>
 */
package com.metro.prediction.metroroutepredictor.model.classes;

import com.metro.prediction.metroroutepredictor.model.interfaces.Route;
import com.metro.prediction.metroroutepredictor.model.interfaces.RouteFinder;
import com.metro.prediction.metroroutepredictor.model.interfaces.Station;

public class MetroRouteFinder implements RouteFinder {

    /**
     * Finds the shortest route between the given start and stop stations.
     *
     * @param startStation The starting station.
     * @param stopStation  The destination station.
     * @return The shortest route as a MetroRoute.
     */
    @Override
    public Route shortestRoute(Station startStation, Station stopStation) {
        ShortRouteF Route1 = new ShortRouteF();
        Route R1 = new MetroRoute();
        for (Station station : Route1.findRoute(startStation, stopStation)) {
            R1.addStation(station);
        }
        return R1;

    }

    /**
     * Finds the most comfortable route between the given start and stop stations with minimum interchanges.
     *
     * @param startStation The starting station.
     * @param stopStation  The destination station.
     * @return The most comfortable route as a MetroRoute.
     */
    @Override
    public Route comfyRoute(Station startStation, Station stopStation) {
        MinInterchangeRouteF Route1 = new MinInterchangeRouteF();
        Route R1 = new MetroRoute();
        for (Station station : Route1.findMinInterchangeRoute(startStation, stopStation)) {
            R1.addStation(station);
        }
        return R1;
    }

    /**
     * Finds the cheapest route between the given start and stop stations.
     *
     * @param startStation The starting station.
     * @param stopStation  The destination station.
     * @return The cheapest route as a MetroRoute.
     */
    @Override
    public Route cheapestRoute(Station startStation, Station stopStation) {
        CheapRouteF Route1 = new CheapRouteF();
        Route R1 = new MetroRoute();
        for (Station station : Route1.findCheapestRoute(startStation, stopStation)) {
            R1.addStation(station);
        }
        return R1;
    }
}
