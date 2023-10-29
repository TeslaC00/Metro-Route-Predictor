package com.metro.prediction.metroroutepredictor.Models;

public interface MetroRouteFinder {

    //    returns the shortest route that has the shortest distance
    MetroRoute shortestRoute(String startStation, String stopStation);

    //    returns the route with less intersection
    MetroRoute comfyRoute(String startStation, String stopStation);

    //    returns the route with minimum price
    MetroRoute cheapestRoute(String startStation, String stopStation);

}
