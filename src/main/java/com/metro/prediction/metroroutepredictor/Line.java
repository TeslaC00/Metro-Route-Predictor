package com.metro.prediction.metroroutepredictor;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Line {
    @JsonProperty("Line_Name")
    private String name;
    @JsonProperty("Color")
    private String color;
    @JsonProperty("Stations")
    private List<Station> stations;

    public String getName() {
        return name;
    }


    public String getColor() {
        return color;
    }


    public List<Station> getStations() {
        return stations;
    }

}
