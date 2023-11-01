package com.metro.prediction.metroroutepredictor.model.interfaces;

import com.metro.prediction.metroroutepredictor.model.classes.MetroStation;
import com.metro.prediction.metroroutepredictor.model.classes.StationConnection;

import java.util.List;

public interface Route {
    List<MetroStation> getStations();

    List<StationConnection> getConnections();
}
