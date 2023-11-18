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
     * @return the latitude of the station
     */
    public double getY() {
        return y;
    }

    /**
     * @return Metro station name
     */
    public String getStationName() {
        return stationName;
    }

    /**
     * @return gives metro station name so that it can be displayed easily
     */
    @Override
    public String toString() {
        return stationName;
    }
}
