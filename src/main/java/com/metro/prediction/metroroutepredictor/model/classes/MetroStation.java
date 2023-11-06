package com.metro.prediction.metroroutepredictor.model.classes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.metro.prediction.metroroutepredictor.model.interfaces.Station;

public class MetroStation implements Station {
    @JsonProperty("name")
    private String stationName;
    @JsonProperty("longitude")
    private double x;
    @JsonProperty("latitude")
    private double y;

    /**
     * @return the longitude of the station
     */
    public double getX() {
        return x;
    }

    /**
     * @param x the longitude of the station
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the latitude of the station
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the longitude of the station
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * @return Metro station name
     */
    public String getStationName() {
        return stationName;
    }

    /**
     * @param stationName name of the Metro station
     */
    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    /**
     * @return gives metro station name so that it can be displayed easily
     */
    @Override
    public String toString() {
        return stationName;
    }
}
