package com.metro.prediction.metroroutepredictor.model.interfaces;

import java.util.List;

public interface Route {
    /**
     * @param station add this station to the route
     */
    void addStation(Station station);

    /**
     * @param connection add this connection to the route
     */
    void addConnection(Connection connection);

    /**
     * @param station removes station from route
     */
    void removeStation(Station station);

    /**
     * @param connection removes connection from the route
     */
    void removeConnection(Connection connection);

    /**
     * @return List of all station of the route
     */
    List<Station> getStations();

    /**
     * @param stations sets the stations of the route
     */
    void setStations(List<Station> stations);

    /**
     * @return List of all the connections of the route
     */
    List<Connection> getConnections();

    /**
     * @param connections sets the connections of the route
     */
    void setConnections(List<Connection> connections);
}
