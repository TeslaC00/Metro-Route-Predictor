package com.metro.prediction.metroroutepredictor.model.classes;

import com.metro.prediction.metroroutepredictor.model.interfaces.Connection;
import com.metro.prediction.metroroutepredictor.model.interfaces.Station;

public class StationConnection implements Connection {
    @Override
    public Station getSource() {
        return null;
//        TODO add code
    }

    @Override
    public Station getDestination() {
        return null;
//        TODO add code
    }

    @Override
    public String getColor() {
        return null;
//        TODO add code
    }

    @Override
    public String getRouteName() {
        return null;
//        TODO add code
    }

    @Override
    public double getDistance() {
        return 0;
//        TODO add code
    }

    @Override
    public double getTimeInSeconds() {
        return 0;
//        TODO add code
    }
}
