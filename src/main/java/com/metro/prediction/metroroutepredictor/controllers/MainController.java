package com.metro.prediction.metroroutepredictor.controllers;

import com.metro.prediction.metroroutepredictor.model.classes.MetroDataLoader;
import com.metro.prediction.metroroutepredictor.model.classes.MetroRoute;
import com.metro.prediction.metroroutepredictor.model.classes.MetroStation;
import com.metro.prediction.metroroutepredictor.model.classes.Model;
import com.metro.prediction.metroroutepredictor.model.interfaces.Route;
import com.metro.prediction.metroroutepredictor.model.interfaces.Station;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        testMetroDataLoader();
    }

    private void testMetroDataLoader() {
        MetroDataLoader dataLoader = MetroDataLoader.getInstance();
//        Route route = dataLoader.getMetroRouteList().get(0);
        Station station = Model.getInstance().getAllStations().get(0);
        System.out.println("Name: " + station.getStationName());
    }
}
