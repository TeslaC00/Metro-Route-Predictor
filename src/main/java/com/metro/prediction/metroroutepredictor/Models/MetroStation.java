package com.metro.prediction.metroroutepredictor.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MetroStation {
    @JsonProperty("Station_Name")
    private String stationName;

    @JsonProperty("Distance")
    private double distance;

    @JsonProperty("ID")
    private int id;

    @JsonProperty("Is_Interchange")
    private boolean isInterchange;

    @JsonProperty("Is_HeadStation")
    private boolean isHeadStation;

    @JsonProperty("Change_Line")
    private String changeLine;

    public double getDistance() {
        return distance;
    }

    public boolean isInterchange() {
        return isInterchange;
    }

    public boolean isHeadStation() {
        return isHeadStation;
    }

    public String getStationName() {
        return stationName;
    }

    public String getChangeLine() {
        return changeLine;
    }

    public int getId() {
        return id;
    }
}
