package com.metro.prediction.metroroutepredictor.model.exceptions;

public class FxmlLoadingException extends RuntimeException {
    public FxmlLoadingException(Throwable cause) {
        super("Error in Loading Fxml file ", cause);
    }
}
