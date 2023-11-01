package com.metro.prediction.metroroutepredictor.model.interfaces;

import com.metro.prediction.metroroutepredictor.model.classes.MetroRoute;
import com.metro.prediction.metroroutepredictor.model.classes.MetroStation;

public interface MetroRouteFinder {

    //    returns the shortest route that has the shortest distance
    MetroRoute shortestRoute(MetroStation startStation, MetroStation stopStation);

    //    returns the route with less intersection
    MetroRoute comfyRoute(MetroStation startStation, MetroStation stopStation);

    //    returns the route with minimum price
    MetroRoute cheapestRoute(MetroStation startStation, MetroStation stopStation);

}
