package com.metro.prediction.metroroutepredictor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Metro Route Predictor");
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("train_icon.png"))));
        stage.setScene(scene);

        stage.show();
    }
}