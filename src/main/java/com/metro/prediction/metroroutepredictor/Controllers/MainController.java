package com.metro.prediction.metroroutepredictor.Controllers;

import com.metro.prediction.metroroutepredictor.Models.MetroDataLoader;
import com.metro.prediction.metroroutepredictor.Models.MetroRoute;
import com.metro.prediction.metroroutepredictor.Models.MetroStation;
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
        MetroRoute route = dataLoader.getMetroRouteList().get(0);
        MetroStation station = route.getStations().get(0);
        System.out.println("Name: " + route.getLineName() + " Color: " + route.getColor());
        System.out.println("Name: " + station.getStationName() + " Distance: " + station.getDistance() + " Head: " + station.isHeadStation());
    }
}
