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

    @Deprecated
    private void testPopulateMap() {
        int count = 0;
        for (Map.Entry<Station, List<Connection>> entry : stationMap.entrySet()) {
            if (count >= 5) {
                break;
            }
            Station station = entry.getKey();
            count++;
            List<Connection> connections = entry.getValue();

            System.out.println("Station: " + station.getStationName());

            if (connections.isEmpty()) {
                System.out.println("  No connections for this station.");
            } else {
                System.out.println("  Connections:");

                for (Connection connection : connections) {
                    System.out.println("    Source: " + connection.getSource());
                    System.out.println("    Destination: " + connection.getDestination());
                    System.out.println("    Route Name: " + connection.getRouteName());
                    System.out.println("    Color: " + connection.getColor());
                    System.out.println("    Distance: " + connection.getDistance());
                    System.out.println("    Time in Seconds: " + connection.getTimeInSeconds());
                    System.out.println();
                }
            }

            System.out.println();
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

    public Station getStationFromString(String name) {
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

