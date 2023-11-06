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
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    @Override
    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public double getTimeInSeconds() {
        return timeInSeconds;
    }

    public void setTimeInSeconds(double timeInSeconds) {
        this.timeInSeconds = timeInSeconds;
    }



}
