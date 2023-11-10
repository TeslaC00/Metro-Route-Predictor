package com.metro.prediction.metroroutepredictor.controllers;

import com.metro.prediction.metroroutepredictor.model.classes.MetroRouteFinder;
import com.metro.prediction.metroroutepredictor.model.classes.Model;
import com.metro.prediction.metroroutepredictor.model.interfaces.Route;
import com.metro.prediction.metroroutepredictor.model.interfaces.RouteFinder;
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
    public ListView<Station> routeListView;
    private RouteFinder routeFinder;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeComboBox();
        initializeButtons();
        routeFinder = new MetroRouteFinder();
    }

    /**
     * Initializes the Router Finder button.
     * Adds action event for this button
     */
    private void initializeButtons() {
        findRouteButton.setOnAction(event -> findRoute());
    }

    /**
     * Initializes the comboBoxes of the app.
     * Add the list of available stations to these in sorted manner.
     */
    private void initializeComboBox() {
        List<Station> sortedStations = new ArrayList<>(Model.getInstance().getAllStations());
        sortedStations.sort(Comparator.comparing(Station::getStationName));
        startStationComboBox.getItems().addAll(sortedStations);
        endStationComboBox.getItems().addAll(sortedStations);
    }

    /**
     * It calls the appropriate method for finding the route between Starting station and Ending station
     */
    private void findRoute() {
        clearList();
//        checks if start station is selected or not
        if (startStationComboBox.getValue() == null) {
            showErrorAlert("Null Station Error", "No Start Station is selected.\nPlease select a starting station");
            return;
        }
//        checks if the end station is selected or not
        if (endStationComboBox.getValue() == null) {
            showErrorAlert("Null Station Error", "No End Station is selected.\nPlease select a ending station");
            return;
        }
//        checks for same values in start or end
        if (startStationComboBox.getValue().equals(endStationComboBox.getValue())) {
            showWarnAlert("Similar Values", "You have selected same station for Starting and ending.\nPLease select different stations");
            return;
        }
//         Calls the method appropriate method according to the radio button selected
        if (comfyRadioButton.isSelected()) {
            showListView(routeFinder.comfyRoute(startStationComboBox.getValue(), endStationComboBox.getValue()));
        } else if (shortRadioButton.isSelected()) {
            showListView(routeFinder.shortestRoute(startStationComboBox.getValue(), endStationComboBox.getValue()));
        } else if (cheapRadioButton.isSelected()) {
            showListView(routeFinder.cheapestRoute(startStationComboBox.getValue(), endStationComboBox.getValue()));
        } else {
            showErrorAlert("Route Property Error", "No route property is selected.\nSelect either of the options:\nLess Interchange\tShortest\tCheapest");
        }
    }

    /**
     * Clears the list view
     */
    private void clearList() {
        routeListView.getItems().clear();
    }

    /**
     * @param route the route to show on list view
     */
    private void showListView(Route route) {
        routeListView.getItems().addAll(route.getStations());
    }

    /**
     * Shows a warning alert with custom header and content.
     *
     * @param header  Header text of the warning alert
     * @param content Content of the warning alert dialog box
     */
    private void showWarnAlert(String header, String content) {
        showAlert(Alert.AlertType.WARNING, "Warning", header, content);
    }

    /**
     * Shows an error alert with custom header and content.
     *
     * @param header  Header text of the error alert
     * @param content Content of the error alert dialog box
     */
    private void showErrorAlert(String header, String content) {
        showAlert(Alert.AlertType.ERROR, "Error", header, content);
    }

    /**
     * Shows custom alert and waits.
     *
     * @param alertType Type of alert you want show
     * @param title     Title of the alert
     * @param header    Header text of the alert
     * @param content   Content of the alert dialog box
     */

    private void showAlert(Alert.AlertType alertType, String title, String header, String content) {
        Alert alert = new Alert(alertType, content);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.showAndWait();
    }

}
