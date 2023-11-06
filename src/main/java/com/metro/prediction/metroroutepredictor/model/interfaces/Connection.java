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
     * @return name of the route in String
     */
    String getRouteName();

    /**
     * @return distance to reach from source to destination in this connection
     */
    double getDistance();

    /**
     * @return time taken in seconds to reach destination from source taking speed as 30kph
     */
    double getTimeInSeconds();
}
