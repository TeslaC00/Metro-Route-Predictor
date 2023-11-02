package com.metro.prediction.metroroutepredictor.model.classes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.metro.prediction.metroroutepredictor.model.interfaces.Station;

public class MetroStation implements Station {
    @JsonProperty("name")
    private String stationName;
    @JsonProperty("location")
    private String location;


    public String getStationName() {
        return stationName;
    }


    @Override
    public String toString() {
        return stationName;
    }
}
