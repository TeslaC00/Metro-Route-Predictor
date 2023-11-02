package com.metro.prediction.metroroutepredictor.model.classes;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.metro.prediction.metroroutepredictor.model.interfaces.Connection;
import com.metro.prediction.metroroutepredictor.model.interfaces.MetroSystem;
import com.metro.prediction.metroroutepredictor.model.interfaces.Route;
import com.metro.prediction.metroroutepredictor.model.interfaces.Station;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MetroDataLoader implements MetroSystem {

    public final static int TOTAL_STATIONS = 262;
    private static MetroDataLoader dataLoader;
    private List<Route> metroRouteList;

    private MetroDataLoader() {
        getDataFromJson();
    }

    public static synchronized MetroDataLoader getInstance() {
        if (dataLoader == null) {
            dataLoader = new MetroDataLoader();
        }
        return dataLoader;
    }

    private void getDataFromJson() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File metroDataFile = new File("src/main/resources/Data/Metro_Stations.json");
            metroRouteList = objectMapper.readValue(metroDataFile, new TypeReference<>() {
            });
        } catch (IOException e) {
            System.err.printf("Failed Data Loading From JSON " + e.getMessage());
        }
    }

    public List<Route> getMetroRouteList() {
        return metroRouteList;
//        Todo check for correctness of the code after modifying source data file
    }

    @Override
    public List<Station> getAllStations() {
        return null;
//        TODO add code
    }

    @Override
    public List<Connection> getAllConnections() {
        return null;
//        TODO add code
    }
}
