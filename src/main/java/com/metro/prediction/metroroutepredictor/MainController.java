package com.metro.prediction.metroroutepredictor;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;

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
    private Canvas canvas;
    private MetroDataLoader dataLoader;
    private double scale = 1.0;
    private GraphicsContext gc;
    private double orgX, orgY, orgTranslateX, orgTranslateY;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dataLoader = MetroDataLoader.getInstance();
        gc = canvas.getGraphicsContext2D();
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
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setFill(Color.RED);
        gc.fillOval(0, 0, 20, 20);
    }

    @FXML
    private void handleScroll(ScrollEvent event) {
        double zoomFactor = 1.2;
        if (event.getDeltaY() < 0) {
            scale /= zoomFactor;
        } else {
            scale *= zoomFactor;
        }
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.save();
        gc.scale(scale, scale);
        drawMap();
        gc.restore();
        event.consume();
    }

    @FXML
    private void handleMouseClick(MouseEvent event) {
        orgX = event.getSceneX();
        orgY = event.getSceneY();
        orgTranslateX = canvas.getTranslateX();
        orgTranslateY = canvas.getTranslateY();
    }

    @FXML
    private void handleMouseDragged(MouseEvent event) {
        double offsetX = event.getSceneX() - orgX;
        double offsetY = event.getSceneY() - orgY;
        double newTranslateX = orgTranslateX + offsetX;
        double newTranslateY = orgTranslateY + offsetY;

        canvas.setTranslateX(newTranslateX);
        canvas.setTranslateY(newTranslateY);
    }
}