package com.metro.prediction.metroroutepredictor.model.classes;

import com.metro.prediction.metroroutepredictor.model.interfaces.Connection;
import com.metro.prediction.metroroutepredictor.model.interfaces.Station;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MetroMap {
    private static Map<Station, List<Connection>> stationMap;
    private static Map<String, Station> stations;

    public MetroMap() {
        populateMap();
        populateStringMap();
    }

    /**
     * Populates the stations hashmap with station name as key and station object as value
     */
    private void populateStringMap() {
        if (stations == null) {
            stations = new HashMap<>();
            for (Station station : Model.getInstance().getAllStations())
                stations.put(station.getStationName(), station);
        }
    }

    /**
     * Populates the stationMap hashmap with station object as key, and it's related connections list as value
     */
    private void populateMap() {
        if (stationMap == null) {
            stationMap = new HashMap<>();
            for (Station station : Model.getInstance().getAllStations()) {
                stationMap.put(station, new ArrayList<>());
                for (Connection connection : Model.getInstance().getAllConnections()) {
                    if (connection.getSource().equals(station.getStationName())) addConnection(station, connection);
                }
            }
        }
    }

    /**
     * @param name Station name
     * @return Station object
     */
    public Station getStationByName(String name) {
        return stations.get(name);
    }

    /**
     * @param source     Source station
     * @param connection Connection of the source station
     */
    public void addConnection(Station source, Connection connection) {
        stationMap.get(source).add(connection);
    }

    /**
     * @param station Source Station
     * @return List of connection of the source station
     */
    public List<Connection> getConnections(Station station) {
        return stationMap.get(station);
    }


}

