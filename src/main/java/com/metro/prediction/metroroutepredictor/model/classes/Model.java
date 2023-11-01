package com.metro.prediction.metroroutepredictor.model.classes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Model {
    private static Model model;
    private final List<MetroStation> uniqueMetroStations = new ArrayList<>();
    private final MetroDataLoader metroDataLoader;

    private Model() {
        metroDataLoader = MetroDataLoader.getInstance();
        initUniqueMetroStation();
    }

    public static synchronized Model getInstance() {
        if (model == null) {
            model = new Model();
        }
        return model;
    }

    public List<MetroStation> getAllStations() {
        return uniqueMetroStations;
    }

    private void initUniqueMetroStation() {
        List<MetroRoute> routes = metroDataLoader.getMetroRouteList();
        Set<String> stationNames = new HashSet<>();
        for (MetroRoute route : routes) {
            for (MetroStation station : route.getStations()) {
                if (!stationNames.contains(station.getStationName())) {
                    stationNames.add(station.getStationName());
                    uniqueMetroStations.add(station);
                }
            }
        }
    }
}
