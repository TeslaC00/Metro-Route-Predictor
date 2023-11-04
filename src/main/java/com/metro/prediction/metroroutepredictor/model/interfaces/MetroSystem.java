package com.metro.prediction.metroroutepredictor.model.interfaces;

import java.util.List;

public interface MetroSystem {
    List<Station> getAllStations();

    List<Connection> getAllConnections();
}
