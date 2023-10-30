module com.metro.prediction.metroroutepredictor {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;

    opens com.metro.prediction.metroroutepredictor to javafx.fxml, com.fasterxml.jackson.databind;
    exports com.metro.prediction.metroroutepredictor;
    exports com.metro.prediction.metroroutepredictor.Controllers;
    exports com.metro.prediction.metroroutepredictor.Models;
    exports com.metro.prediction.metroroutepredictor.Views;
    opens com.metro.prediction.metroroutepredictor.Models to com.fasterxml.jackson.databind, javafx.fxml;
}