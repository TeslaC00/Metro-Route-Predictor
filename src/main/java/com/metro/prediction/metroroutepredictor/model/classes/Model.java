package com.metro.prediction.metroroutepredictor.model.classes;

import com.metro.prediction.metroroutepredictor.model.interfaces.Connection;
import com.metro.prediction.metroroutepredictor.model.interfaces.Station;

import java.util.List;

public class Model {
    private static Model model;
    private final MetroDataLoader metroDataLoader;

    private Model() {
        metroDataLoader = MetroDataLoader.getInstance();
    }

    public static Model getInstance() {
        if (model == null) {
            model = new Model();
        }
        return model;
    }

    public List<Station> getAllStations() {
        return metroDataLoader.getMetroSystemData().getAllStations();
    }

    public List<Connection> getAllConnections() {
        return metroDataLoader.getMetroSystemData().getAllConnections();
    }

}
