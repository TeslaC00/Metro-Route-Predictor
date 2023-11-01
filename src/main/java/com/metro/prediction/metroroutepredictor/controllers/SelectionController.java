package com.metro.prediction.metroroutepredictor.controllers;

import com.metro.prediction.metroroutepredictor.model.classes.MetroStation;
import com.metro.prediction.metroroutepredictor.model.classes.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class SelectionController implements Initializable {
    public ComboBox<MetroStation> startStation_box;
    public ComboBox<MetroStation> endStation_box;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initComboBox();
    }

    private void initComboBox() {
        startStation_box.setVisibleRowCount(12);
        endStation_box.setVisibleRowCount(12);
        System.out.println(startStation_box.getVisibleRowCount());
        startStation_box.getItems().addAll(Model.getInstance().getAllUniqueStations());
        endStation_box.getItems().addAll(Model.getInstance().getAllUniqueStations());
    }
}
