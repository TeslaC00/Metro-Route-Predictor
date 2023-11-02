package com.metro.prediction.metroroutepredictor.model.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MetroSystemData {
    @JsonProperty("stations")
    private List<MetroStation> stations;
    @JsonProperty("connections")
    private List<StationConnection> connections;

    public List<MetroStation> getStations() {
        return stations;
    }

    public void setStations(List<MetroStation> stations) {
        this.stations = stations;
    }

    public List<StationConnection> getConnections() {
        return connections;
    }

    public void setConnections(List<StationConnection> connections) {
        this.connections = connections;
    }
}
