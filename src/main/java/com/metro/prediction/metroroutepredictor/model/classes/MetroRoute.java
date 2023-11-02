package com.metro.prediction.metroroutepredictor.model.classes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.metro.prediction.metroroutepredictor.model.interfaces.Connection;
import com.metro.prediction.metroroutepredictor.model.interfaces.Route;
import com.metro.prediction.metroroutepredictor.model.interfaces.Station;

import java.util.List;

public class MetroRoute implements Route {
    @JsonProperty("Line_Name")
    private String lineName;
    @JsonProperty("Stations")
    private List<Station> stations;
    @JsonProperty("Color")
    private String color;

    public List<Station> getStations() {
        return stations;
//        Todo check if code works correctly after modifying the data source file
    }

    @Override
    public List<Connection> getConnections() {
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
