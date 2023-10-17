module com.metro.prediction.metroroutepredictor {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.metro.prediction.metroroutepredictor to javafx.fxml;
    exports com.metro.prediction.metroroutepredictor;
}