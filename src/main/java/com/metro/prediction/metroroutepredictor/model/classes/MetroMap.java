package com.metro.prediction.metroroutepredictor.model.classes;
import com.metro.prediction.metroroutepredictor.model.interfaces.Connection;
import com.metro.prediction.metroroutepredictor.model.interfaces.Station;

import java.util.*;
public class MetroMap {
    private Map<Station, List<Connection>> stationMap;

    public MetroMap() {
        stationMap = new HashMap<>();
    }

    public void addStation(Station station) {
        stationMap.put(station, new ArrayList<>());
    }

    public void addConnection(Station source, Connection connection) {
        stationMap.get(source).add(connection);

        // If you want bidirectional connections, you can add the reverse connection as well.
        // Uncomment the lines below if you want to do that.

        // Station destination = new MetroStation(connection.getDestination());
        // Connection reverseConnection = new StationConnection();
        // reverseConnection.setSource(connection.getDestination());
        // reverseConnection.setDestination(connection.getSource());
        // stationMap.get(destination).add(reverseConnection);
    }

    public List<Connection> getConnections(Station station) {
        return stationMap.get(station);
    }
}

