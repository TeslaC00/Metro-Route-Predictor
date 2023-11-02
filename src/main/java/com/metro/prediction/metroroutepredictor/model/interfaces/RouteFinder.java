package com.metro.prediction.metroroutepredictor.model.interfaces;

public interface RouteFinder {

    //    returns the shortest route that has the shortest distance
    Route shortestRoute(Station startStation, Station stopStation);

    //    returns the route with less intersection
    Route comfyRoute(Station startStation, Station stopStation);

    //    returns the route with minimum price
    Route cheapestRoute(Station startStation, Station stopStation);

}
