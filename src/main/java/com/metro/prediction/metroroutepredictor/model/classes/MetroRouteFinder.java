package com.metro.prediction.metroroutepredictor.model.classes;

import com.metro.prediction.metroroutepredictor.model.interfaces.Route;
import com.metro.prediction.metroroutepredictor.model.interfaces.RouteFinder;
import com.metro.prediction.metroroutepredictor.model.interfaces.Station;

public class MetroRouteFinder implements RouteFinder {
    @Override
    public Route shortestRoute(Station startStation, Station stopStation) {
        ShortRouteF Route1 = new ShortRouteF();
        MetroRoute R1 = new MetroRoute();
        for (Station station : Route1.findRoute(startStation, stopStation)) {
            R1.addStation(station);
        }
        return R1;

    }

    @Override
    public Route comfyRoute(Station startStation, Station stopStation) {
        MinInterchangeRouteF Route1 = new MinInterchangeRouteF();
        MetroRoute R1 = new MetroRoute();
        for (Station station : Route1.findMinInterchangeRoute(startStation, stopStation)) {
            R1.addStation(station);
        }
        return R1;
    }

    @Override
    public Route cheapestRoute(Station startStation, Station stopStation) {
        CheapRouteF Route1 = new CheapRouteF();
        MetroRoute R1 = new MetroRoute();
        for (Station station : Route1.findCheapestRoute(startStation, stopStation)) {
            R1.addStation(station);
        }
        return R1;
    }
}
