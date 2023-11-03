package com.metro.prediction.metroroutepredictor.controllers;

import com.metro.prediction.metroroutepredictor.model.classes.Model;
import com.metro.prediction.metroroutepredictor.model.interfaces.Station;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class SelectionController implements Initializable {
    public ComboBox<Station> startStation_box;
    public ComboBox<Station> endStation_box;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initComboBox();
    }

    private void initComboBox() {
        startStation_box.getItems().addAll(Model.getInstance().getAllStations());
        endStation_box.getItems().addAll(Model.getInstance().getAllStations());
    }

}
