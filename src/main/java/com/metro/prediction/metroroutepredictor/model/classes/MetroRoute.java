package com.metro.prediction.metroroutepredictor.model.classes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.metro.prediction.metroroutepredictor.model.interfaces.Route;

import java.util.List;

public class MetroRoute implements Route {
    @JsonProperty("Line_Name")
    private String lineName;
    @JsonProperty("Stations")
    private List<MetroStation> stations;
    @JsonProperty("Color")
    private String color;

    public List<MetroStation> getStations() {
        return stations;
    }

    @Override
    public List<StationConnection> getConnections() {
        return null;
//        TODO add get connections
    }

    public String getLineName() {
        return lineName;
    }

    public String getColor() {
        return color;
    }
}
