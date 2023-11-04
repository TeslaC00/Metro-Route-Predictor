package com.metro.prediction.metroroutepredictor.model.classes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.metro.prediction.metroroutepredictor.model.interfaces.Connection;
import com.metro.prediction.metroroutepredictor.model.interfaces.MetroSystem;
import com.metro.prediction.metroroutepredictor.model.interfaces.Station;

import java.util.ArrayList;
import java.util.List;

public class MetroSystemData implements MetroSystem {
    @JsonProperty("stations")
    private List<MetroStation> stations;
    @JsonProperty("connections")
    private List<StationConnection> connections;

    public List<MetroStation> getStations() {
        return stations;
    }


    public List<StationConnection> getConnections() {
        return connections;
    }

    @Override
    public List<Station> getAllStations() {
        return new ArrayList<>(stations);
    }

    @Override
    public List<Connection> getAllConnections() {
        return new ArrayList<>(connections);
    }
}
