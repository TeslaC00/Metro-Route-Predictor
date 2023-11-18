package com.metro.prediction.metroroutepredictor.model.interfaces;

public interface Connection {
    /**
     * @return source of the connection in String
     */
    String getSource();

    /**
     * @return destination of the connection in String
     */
    String getDestination();

    /**
     * @return color of the connection in String
     */
    String getColor();

    /**
     * @return distance to reach from source to destination in this connection
     */
    double getDistance();

}
