package com.metro.prediction.metroroutepredictor.model.classes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.metro.prediction.metroroutepredictor.model.interfaces.Connection;
import com.metro.prediction.metroroutepredictor.model.interfaces.MetroSystem;
import com.metro.prediction.metroroutepredictor.model.interfaces.Route;
import com.metro.prediction.metroroutepredictor.model.interfaces.Station;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MetroDataLoader implements MetroSystem {

    public final static int TOTAL_STATIONS = 262;
    private static MetroDataLoader instance;
    private MetroSystemData metroSystemData;
    private MetroSystem metroSystem;
    private List<Route> metroRouteList;

    private MetroDataLoader() {
        getDataFromJson();
//        Todo add return type for getDataFromJson method
    }

    public static synchronized MetroDataLoader getInstance() {
        if (instance == null) {
            instance = new MetroDataLoader();
        }
        return instance;
    }

    public MetroSystemData getMetroSystemData() {
        return metroSystemData;
    }

    private void getDataFromJson() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File metroDataFile = new File("src/main/resources/Data/Metro_System_Data.json");
            metroSystemData = objectMapper.readValue(metroDataFile, MetroSystemData.class);
        } catch (IOException e) {
            System.err.printf("Failed Data Loading From JSON " + e.getMessage());
        }
    }

    @Deprecated
    public List<Route> getMetroRouteList() {
        return metroRouteList;
//        Todo remove redundant
    }

    @Override
    public List<Station> getAllStations() {
        return new ArrayList<>(metroSystemData.getStations());
//        TODO check code
    }

    @Override
    public List<Connection> getAllConnections() {
        return new ArrayList<>(metroSystemData.getConnections());
//        TODO check code
    }
}
