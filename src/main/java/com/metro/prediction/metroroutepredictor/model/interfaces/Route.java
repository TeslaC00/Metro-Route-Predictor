package com.metro.prediction.metroroutepredictor.model.interfaces;

import java.util.List;

public interface Route {
    void addStation(Station station);

    void addConnection(Connection connection);

    void removeStation(Station station);

    void removeConnection(Connection connection);

    List<Station> getStations();

    void setStations(List<Station> stations);

    List<Connection> getConnections();

    void setConnections(List<Connection> connections);
}
