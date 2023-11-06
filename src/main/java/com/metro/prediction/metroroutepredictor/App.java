package com.metro.prediction.metroroutepredictor;

import com.metro.prediction.metroroutepredictor.model.classes.Model;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch();
    }

    /**
     * @param stage the primary stage for this application, onto which
     * the application scene can be set.
     * Applications may create other stages, if needed, but they will not be
     * primary stages.
     */
    @Override
    public void start(Stage stage) {
        Model.getInstance().getViewFactory().showMainWindow();
    }
}