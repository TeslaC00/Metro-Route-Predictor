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

    /**
     * @return Route name of which this connection is part of
     */
    @SuppressWarnings("unused")
    public String getRouteName() {
        return routeName;
    }

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
     * @return distance between source and destination in meters
     */
    @Override
    public double getDistance() {
        return distance;
    }

}
