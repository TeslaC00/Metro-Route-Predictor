package com.metro.prediction.metroroutepredictor.model.classes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.metro.prediction.metroroutepredictor.model.exceptions.DataLoadingException;

import java.io.File;
import java.io.IOException;

public class MetroDataLoader {

    private MetroSystemData metroSystemData;

    public MetroDataLoader() {
        getDataFromJson();
    }

    /**
     * @return MetroSystemData object
     */
    public MetroSystemData getMetroSystemData() {
        return metroSystemData;
    }

    /**
     * Loads data from JSON file and assign it to metroSystemData object
     */
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
