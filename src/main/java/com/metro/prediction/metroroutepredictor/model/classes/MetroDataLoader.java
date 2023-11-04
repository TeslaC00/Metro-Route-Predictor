package com.metro.prediction.metroroutepredictor.model.classes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.metro.prediction.metroroutepredictor.model.exceptions.DataLoadingException;

import java.io.File;
import java.io.IOException;

public class MetroDataLoader {

    public final static int TOTAL_STATIONS = 236;
    private static MetroDataLoader instance;
    private MetroSystemData metroSystemData;

    private MetroDataLoader() {
        getDataFromJson();
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
            throw new DataLoadingException(e);
        }
    }

}
