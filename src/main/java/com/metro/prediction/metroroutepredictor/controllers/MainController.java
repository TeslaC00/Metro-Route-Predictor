package com.metro.prediction.metroroutepredictor.controllers;

import com.metro.prediction.metroroutepredictor.model.classes.Model;
import com.metro.prediction.metroroutepredictor.model.interfaces.Station;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    public ComboBox<Station> startStationComboBox;
    public ComboBox<Station> endStationComboBox;
    public RadioButton comfyRadioButton;
    public RadioButton shortRadioButton;
    public RadioButton cheapRadioButton;
    public Button findRouteButton;
    public ToggleGroup routePropertyToggleGroup;
    public Label testLabel;
    public ListView routeListView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeComboBox();
        initializeFindRouteButton();
    }

    private void initializeFindRouteButton() {
        findRouteButton.setOnAction(event -> findRoute());
    }

    private void initializeComboBox() {
        List<Station> sortedStations = new ArrayList<>(Model.getInstance().getAllStations());
        sortedStations.sort(Comparator.comparing(Station::getStationName));
        startStationComboBox.getItems().addAll(sortedStations);
        endStationComboBox.getItems().addAll(sortedStations);
    }

    private void findRoute() {
        if (startStationComboBox.getValue() == null) {
            showErrorAlert("Null Station Error", "No Start Station is selected.\nPlease select a starting station");
            return;
        }

        if (endStationComboBox.getValue() == null) {
            showErrorAlert("Null Station Error", "No End Station is selected.\nPlease select a ending station");
            return;
        }
        if (startStationComboBox.getValue().equals(endStationComboBox.getValue())) {
            showWarnAlert("Similar Values", "You have selected same station for Starting and ending.\nPLease select different stations");
            return;
        }

        if (comfyRadioButton.isSelected()) {
            testLabel.setText("Finding Comfy route from: " + startStationComboBox.getValue() + " to " + endStationComboBox.getValue());
        } else if (shortRadioButton.isSelected()) {
            testLabel.setText("Finding Shortest route from: " + startStationComboBox.getValue() + " to " + endStationComboBox.getValue());
        } else if (cheapRadioButton.isSelected()) {
            testLabel.setText("Finding Cheapest route from: " + startStationComboBox.getValue() + " to " + endStationComboBox.getValue());
        } else {
            showErrorAlert("Route Property Error", "No route property is selected.\nSelect either of the options:\nLess Interchange\tShortest\tCheapest");
        }
    }

    private void showWarnAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void showErrorAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

}
