package com.metro.prediction.metroroutepredictor.model.interfaces;

import java.util.List;

public interface Route {
    List<Station> getStations();

    List<Connection> getConnections();
}
