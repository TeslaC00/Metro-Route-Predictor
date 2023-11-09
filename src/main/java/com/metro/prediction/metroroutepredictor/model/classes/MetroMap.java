package com.metro.prediction.metroroutepredictor.model.classes;

import com.metro.prediction.metroroutepredictor.model.interfaces.Connection;
import com.metro.prediction.metroroutepredictor.model.interfaces.Station;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MetroMap {
    private final Map<Station, List<Connection>> stationMap;
    private final Map<String, Station> stations;

    public MetroMap() {
        stationMap = new HashMap<>();
        stations = new HashMap<>();
        populateMap();
        populateStringMap();
    }

    private void populateStringMap() {
        for (Station station : Model.getInstance().getAllStations()) {
            stations.put(station.getStationName(), station);
        }
    }


    private void populateMap() {
        for (Station station : Model.getInstance().getAllStations()) {
            addStation(station);
            for (Connection connection : Model.getInstance().getAllConnections()) {
                if (connection.getSource().equals(station.getStationName())) {
                    addConnection(station, connection);
                }
            }
        }
    }

    public Station getStationByName(String name) {
        return stations.get(name);
    }

    public void addStation(Station station) {
        stationMap.put(station, new ArrayList<>());
    }

    public void addConnection(Station source, Connection connection) {
        stationMap.get(source).add(connection);
    }

    public List<Connection> getConnections(Station station) {
        return stationMap.get(station);
    }

    public Map<Station, List<Connection>> getStationMap() {
        return stationMap;
    }




}

