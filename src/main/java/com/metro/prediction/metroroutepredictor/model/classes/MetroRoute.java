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

    /**
     * @param station The station to be added in the route
     */
    @Override
    public void addStation(Station station) {
        stations.add(station);
    }

    /**
     * @param connection the connection to be added in this route
     */
    @Override
    public void addConnection(Connection connection) {
        connections.add(connection);
    }

    /**
     * @param station removes the station
     */
    @Override
    public void removeStation(Station station) {
        stations.remove(station);
    }

    /**
     * @param connection removes the connection
     */
    @Override
    public void removeConnection(Connection connection) {
        connections.remove(connection);
    }

    /**
     * @return the list of all stations in this route
     */
    public List<Station> getStations() {
        return stations;
    }

    /**
     * @param stations all stations in this route
     */
    @Override
    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    /**
     * @return the list of all connections in this route
     */
    @Override
    public List<Connection> getConnections() {
        return connections;
    }

    /**
     * @param connections all connections in this route
     */
    @Override
    public void setConnections(List<Connection> connections) {
        this.connections = connections;
    }

}
