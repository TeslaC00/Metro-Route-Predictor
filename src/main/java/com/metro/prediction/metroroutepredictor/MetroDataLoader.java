package com.metro.prediction.metroroutepredictor;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

public class MetroDataLoader {
    public final static int TOTAL_STATIONS = 262;
    private static MetroDataLoader instance;
    List<Line> lines;

    private MetroDataLoader() {
        loadDataFromJSON();
    }

    public static synchronized MetroDataLoader getInstance() {
        if (instance == null) {
            instance = new MetroDataLoader();
        }
        return instance;
    }

    private void loadDataFromJSON() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File metroDataFile = new File("src/main/resources/com/metro/prediction/metroroutepredictor/Metro_Stations.json");
            lines = objectMapper.readValue(metroDataFile, new TypeReference<>() {
            });
        } catch (Exception e) {
            System.err.println("Failed data loading\n" + e.getMessage());
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}