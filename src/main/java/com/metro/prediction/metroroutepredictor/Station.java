package com.metro.prediction.metroroutepredictor;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Station {
    @JsonProperty("ID")
    private int id;
    @JsonProperty("Station_Name")
    private String name;
    @JsonProperty("Distance")
    private double distance;
    @JsonProperty("Is_Interchange")
    private boolean isInterchange;
    @JsonProperty("Is_HeadStation")
    private boolean isHeadStation;
    @JsonProperty("Change_Line")
    private String changeLine;  // only used when changeLine is available

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public String getChangeLine() {
        return changeLine;
    }


    public double getDistance() {
        return distance;
    }


    public boolean isInterchange() {
        return isInterchange;
    }


    public boolean isHeadStation() {
        return isHeadStation;
    }

}
