package com.metro.prediction.metroroutepredictor.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MetroRoute {
    @JsonProperty("Line_Name")
    private String lineName;
    @JsonProperty("Stations")
    private List<MetroStation> stations;
    @JsonProperty("Color")
    private String color;

    public List<MetroStation> getStations() {
        return stations;
    }

    public String getLineName() {
        return lineName;
    }

    public String getColor() {
        return color;
    }
}
