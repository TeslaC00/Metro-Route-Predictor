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
     * @param source Source location from which the connection is made
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * @return Destination location of the connection made
     */
    @Override
    public String getDestination() {
        return destination;
    }

    /**
     * @param destination Destination location till which the connection is made
     */

    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * @return the color of the connection
     */
    @Override
    public String getColor() {
        return color;
    }

    /**
     * @param color the color of the connection made
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the route name of which the connection is part of
     */
    @Override
    public String getRouteName() {
        return routeName;
    }

    /**
     * @param routeName the route name of which the connection is part of
     */

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    /**
     * @return distance between source and destination in meters
     */
    @Override
    public double getDistance() {
        return distance;
    }

    /**
     * @param distance distance between source and destination in meters
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
     * @return time taken to reach from source to destination in seconds
     */
    @Override
    public double getTimeInSeconds() {
        return timeInSeconds;
    }

    /**
     * @param timeInSeconds time taken to reach from source to destination in seconds
     */
    public void setTimeInSeconds(double timeInSeconds) {
        this.timeInSeconds = timeInSeconds;
    }



}
