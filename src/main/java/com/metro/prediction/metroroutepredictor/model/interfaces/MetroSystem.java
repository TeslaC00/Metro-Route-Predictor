package com.metro.prediction.metroroutepredictor.model.interfaces;

import java.util.List;

public interface MetroSystem {
    /**
     * @return List of all stations
     */
    List<Station> getAllStations();

    /**
     * @return List of all connections
     */
    List<Connection> getAllConnections();
}
