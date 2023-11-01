module com.metro.prediction.metroroutepredictor {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;

    opens com.metro.prediction.metroroutepredictor to javafx.fxml, com.fasterxml.jackson.databind;
    exports com.metro.prediction.metroroutepredictor;
    exports com.metro.prediction.metroroutepredictor.controllers;
    exports com.metro.prediction.metroroutepredictor.views;
    exports com.metro.prediction.metroroutepredictor.model.interfaces;
    opens com.metro.prediction.metroroutepredictor.model.interfaces to com.fasterxml.jackson.databind, javafx.fxml;
    exports com.metro.prediction.metroroutepredictor.model.classes;
    opens com.metro.prediction.metroroutepredictor.model.classes to com.fasterxml.jackson.databind, javafx.fxml;
}