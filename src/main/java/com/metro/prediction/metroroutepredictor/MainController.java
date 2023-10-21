package com.metro.prediction.metroroutepredictor;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    String[] stations = {"Station 1", "Station 2", "Station 3"};
    @FXML
    private ComboBox<String> startStation;
    @FXML
    private ComboBox<String> stopStation;
    @FXML
    private Canvas metroMap;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        startStation.getItems().addAll(stations);
        stopStation.getItems().addAll(stations);
        drawMap();
    }

    private void drawMap() {
        GraphicsContext gc = metroMap.getGraphicsContext2D();
    }
}