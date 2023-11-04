package com.metro.prediction.metroroutepredictor.model.interfaces;

public interface Connection {
    String getSource();

    String getDestination();

    String getColor();

    String getRouteName();

    double getDistance();

    double getTimeInSeconds();
}
