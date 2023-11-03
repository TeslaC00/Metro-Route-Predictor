package com.metro.prediction.metroroutepredictor.model.exceptions;

public class DataLoadingException extends RuntimeException {
    public DataLoadingException(Throwable cause) {
        super("Failed Data Loading from JSON", cause);
    }
}
