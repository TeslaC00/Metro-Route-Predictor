package com.metro.prediction.metroroutepredictor.model.classes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.metro.prediction.metroroutepredictor.model.interfaces.Connection;

public class StationConnection implements Connection {
    @JsonProperty("source")
    private String source;
    @JsonProperty("destination")
    private String destination;
    @JsonProperty("route_name")
    private String routeName;
    @JsonProperty("color")
    private String color;
    @JsonProperty("distance")
    private double distance;
    @JsonProperty("time")
    private double timeInSeconds;
    @Override
    public String getSource() {
        return source;
//        TODO add code
    }

    @Override
    public String getDestination() {
        return destination;
//        TODO add code
    }

    @Override
    public String getColor() {
        return color;
//        TODO add code
    }

    @Override
    public String getRouteName() {
        return routeName;
//        TODO add code
    }

    @Override
    public double getDistance() {
        return distance;
//        TODO add code
    }

    @Override
    public double getTimeInSeconds() {
        return timeInSeconds;
//        TODO add code
    }
}
