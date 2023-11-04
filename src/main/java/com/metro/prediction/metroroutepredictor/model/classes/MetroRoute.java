package com.metro.prediction.metroroutepredictor.model.classes;

import com.metro.prediction.metroroutepredictor.model.interfaces.Connection;
import com.metro.prediction.metroroutepredictor.model.interfaces.Route;
import com.metro.prediction.metroroutepredictor.model.interfaces.Station;

import java.util.ArrayList;
import java.util.List;

public class MetroRoute implements Route {
    private List<Station> stations;
    private List<Connection> connections;

    public MetroRoute() {
        stations = new ArrayList<>();
        connections = new ArrayList<>();
    }

    @Override
    public void addStation(Station station) {
        stations.add(station);
    }

    @Override
    public void addConnection(Connection connection) {
        connections.add(connection);
    }

    @Override
    public void removeStation(Station station) {
        stations.remove(station);
    }

    @Override
    public void removeConnection(Connection connection) {
        connections.remove(connection);
    }

    public List<Station> getStations() {
        return stations;
    }

    @Override
    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    @Override
    public List<Connection> getConnections() {
        return connections;
    }

    @Override
    public void setConnections(List<Connection> connections) {
        this.connections = connections;
    }

}
