package com.metro.prediction.metroroutepredictor.model.interfaces;

public interface Connection {
    Station getSource();

    Station getDestination();

    String getColor();

    String getRouteName();

    double getDistance();

    double getTimeInSeconds();
}
