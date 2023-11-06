package com.metro.prediction.metroroutepredictor.model.interfaces;

public interface Station {
    /**
     * @return name of the station
     */
    String getStationName();

    /**
     * @return x coordinate of the station
     */
    double getX();

    /**
     * @return y coordinate of the station
     */
    double getY();
}
