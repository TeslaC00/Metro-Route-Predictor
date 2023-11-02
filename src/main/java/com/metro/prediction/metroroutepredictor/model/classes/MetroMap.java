package com.metro.prediction.metroroutepredictor.model.classes;
import java.util.*;
public class MetroMap {
    private Map<Integer, MetroStation> stationMap;
    private Map<MetroStation, List<MetroStation>> connections;

    public MetroMap() {
        stationMap = new HashMap<>();
        connections = new HashMap<>();
    }

    public void addStation(MetroStation station) {
        stationMap.put(station.getId(), station);
        connections.put(station, new ArrayList<>());
    }

    public void addConnection(MetroStation station1, MetroStation station2) {
        connections.get(station1).add(station2);
        connections.get(station2).add(station1);
    }

    public List<MetroStation> getConnections(MetroStation station) {
        return connections.get(station);
    }

    public MetroStation getStationById(int id) {
        return stationMap.get(id);
    }
}

