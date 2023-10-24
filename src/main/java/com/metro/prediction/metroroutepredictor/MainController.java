package com.metro.prediction.metroroutepredictor;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    String[] stations = {"Station 1", "Station 2", "Station 3"};
    @FXML
    private ComboBox<String> startStation;
    @FXML
    private ComboBox<String> stopStation;
    @FXML
    private Canvas metroMap;
    private MetroDataLoader dataLoader;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dataLoader = MetroDataLoader.getInstance();
        startStation.getItems().addAll(stations);
        stopStation.getItems().addAll(stations);
        testLoader();
        drawMap();
    }

    private void testLoader() {
        List<Line> lines = dataLoader.getLines();
        Line red = lines.get(0);
        System.out.println(red.getName() + " " + red.getColor());
        Station station = red.getStations().get(0);
        System.out.println(station.getName() + " " + station.getDistance() + " " + station.getId() + " " + station.getChangeLine() + " " + station.isInterchange() + " " + station.isHeadStation());
    }

    private void drawMap() {
        GraphicsContext gc = metroMap.getGraphicsContext2D();
    }
}