package com.metro.prediction.metroroutepredictor.model.classes;

import com.metro.prediction.metroroutepredictor.model.interfaces.Route;
import com.metro.prediction.metroroutepredictor.model.interfaces.Station;

import java.util.ArrayList;
import java.util.List;

public class MetroRoute implements Route {
    private final List<Station> stations;

    public MetroRoute() {
        stations = new ArrayList<>();
    }

    /**
     * @param station The station to be added in the route
     */
    @Override
    public void addStation(Station station) {
        stations.add(station);
    }

    /**
     * @return the list of all stations in this route
     */
    public List<Station> getStations() {
        return stations;
    }

}
