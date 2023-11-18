package com.metro.prediction.metroroutepredictor.model.interfaces;

import java.util.List;

public interface Route {
    /**
     * @param station add this station to the route
     */
    void addStation(Station station);

    /**
     * @return List of all station of the route
     */
    List<Station> getStations();

}
