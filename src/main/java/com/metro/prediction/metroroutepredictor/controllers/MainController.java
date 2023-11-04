package com.metro.prediction.metroroutepredictor.controllers;

import com.metro.prediction.metroroutepredictor.model.classes.Model;
import com.metro.prediction.metroroutepredictor.model.interfaces.Connection;
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
        Station station = Model.getInstance().getAllStations().get(0);
        Connection connection = Model.getInstance().getAllConnections().get(0);
        System.out.println("Name: " + station.getStationName() + " x: " + station.getX() + " y: " + station.getY());
        System.out.println("src: " + connection.getSource() + " dst: " + connection.getDestination() + " color: " + connection.getColor() + " distance: " + connection.getDistance() + " time: " + connection.getTimeInSeconds() + " route name: " + connection.getRouteName());
    }
}
