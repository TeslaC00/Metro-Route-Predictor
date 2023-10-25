package com.metro.prediction.metroroutepredictor.Models;

public interface MetroRouteFinder {

    MetroRoute shortestRoute();

    MetroRoute comfyRoute();

    MetroRoute cheapestRoute();

}
