package com.metro.prediction.metroroutepredictor.controllers;

import com.metro.prediction.metroroutepredictor.model.classes.Model;
import com.metro.prediction.metroroutepredictor.model.interfaces.Station;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class SelectionController implements Initializable {
    public ComboBox<Station> startStation_box;
    public ComboBox<Station> endStation_box;
    public RadioButton comfy_radio_btn;
    public RadioButton short_radio_btn;
    public RadioButton cheap_radio_btn;
    public Button find_btn;
    public ToggleGroup routeProperty;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initComboBox();
        initButtons();
    }

    private void initButtons() {
        find_btn.setOnAction(event -> findRoute());
    }

    private void initComboBox() {
        startStation_box.getItems().addAll(Model.getInstance().getAllStations());
        endStation_box.getItems().addAll(Model.getInstance().getAllStations());
    }

    private void findRoute() {
        if (comfy_radio_btn.isSelected()) {
            System.out.println("Finding Comfy route from: " + startStation_box.getValue() + " to " + endStation_box.getValue());
        } else if (short_radio_btn.isSelected()) {
            System.out.println("Finding Shortest route from: " + startStation_box.getValue() + " to " + endStation_box.getValue());
        } else if (cheap_radio_btn.isSelected()) {
            System.out.println("Finding Cheapest route from: " + startStation_box.getValue() + " to " + endStation_box.getValue());
        } else {
            showNoSelectionAlert();
        }
    }

    private void showNoSelectionAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Route Property Error");
        alert.setContentText("No route property is selected.\nSelect either of the options:\nLess Interchange\tShortest\tCheapest");
        alert.showAndWait();
    }

}
