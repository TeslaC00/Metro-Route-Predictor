package com.metro.prediction.metroroutepredictor.views;

import com.metro.prediction.metroroutepredictor.model.exceptions.FxmlLoadingException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ViewFactory {

    public void showMainWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Main.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (IOException e) {
            throw new FxmlLoadingException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("Metro Route Predictor");
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Images/train_icon.png"))));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
