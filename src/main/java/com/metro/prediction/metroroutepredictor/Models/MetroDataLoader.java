package com.metro.prediction.metroroutepredictor.Models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MetroDataLoader {

    public final static int TOTAL_STATIONS = 262;
    private static MetroDataLoader dataLoader;
    private List<MetroRoute> metroRouteList;

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

    public List<MetroRoute> getMetroRouteList() {
        return metroRouteList;
    }
}
