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

    /**
     * @return Source location of the connection made
     */
    @Override
    public String getSource() {
        return source;
    }

    /**
     * @return Destination location of the connection made
     */
    @Override
    public String getDestination() {
        return destination;
    }

    /**
     * @return the color of the connection
     */
    @Override
    public String getColor() {
        return color;
    }

    /**
     * @return the route name of which the connection is part of
     */
    @Override
    public String getRouteName() {
        return routeName;
    }

    /**
     * @return distance between source and destination in meters
     */
    @Override
    public double getDistance() {
        return distance;
    }

    /**
     * @return time taken to reach from source to destination in seconds
     */
    @Override
    public double getTimeInSeconds() {
        return timeInSeconds;
    }

}
