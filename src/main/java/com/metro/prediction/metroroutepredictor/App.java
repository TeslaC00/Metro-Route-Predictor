package com.metro.prediction.metroroutepredictor;

import com.metro.prediction.metroroutepredictor.model.classes.Model;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        Model.getInstance().getViewFactory().showMainWindow();
    }
}