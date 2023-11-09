package com.metro.prediction.metroroutepredictor.model.classes;

import com.metro.prediction.metroroutepredictor.model.interfaces.Connection;
import com.metro.prediction.metroroutepredictor.model.interfaces.Station;

import java.util.HashMap;
import java.util.*;
import java.util.Map;
import java.util.PriorityQueue;

public class CheapRouteF {
    private MetroMap metroMap;

    public CheapRouteF() {
        metroMap = new MetroMap();
    }

    public class RouteNode {
        Station station;
        double gScore;
        double fScore;
        double cost;
        List<Station> path;

        RouteNode(Station station, double gScore, double fScore, double cost, List<Station> path) {
            this.station = station;
            this.gScore = gScore;
            this.fScore = fScore;
            this.cost = cost;
            this.path = path;
        }
    }

    public List<Station> findCheapestRoute(Station start, Station goal) {
        PriorityQueue<RouteNode> openSet = new PriorityQueue<>(new RouteNodeComparator());
        Map<Station, Double> gScore = new HashMap<>();
        Map<Station, Station> cameFrom = new HashMap<>();

        gScore.put(start, 0.0);
        openSet.add(new RouteNode(start, 0.0, heuristic(start, goal), 0.0, new ArrayList<>()));

        while (!openSet.isEmpty()) {
            RouteNode current = openSet.poll();

            if (current.station.equals(goal)) {
                return current.path; // Return the cheapest route
            }

            for (Connection connection : metroMap.getConnections(current.station)) {
                Station neighbor = metroMap.getStationByName(connection.getDestination());
                double tentativeGScore = current.gScore + connection.getDistance();

                if (tentativeGScore < gScore.getOrDefault(neighbor, Double.MAX_VALUE)) {
                    cameFrom.put(neighbor, current.station);
                    gScore.put(neighbor, tentativeGScore);

                    double cost = calculateCost(connection.getDistance());
                    double fScore = tentativeGScore + heuristic(neighbor, goal);

                    List<Station> path = new ArrayList<>(current.path);
                    path.add(neighbor);

                    openSet.add(new RouteNode(neighbor, tentativeGScore, fScore, current.cost + cost, path));
                }
            }
        }

        // If the while loop terminates, no path was found
        return null;
    }

    private double heuristic(Station a, Station b) {
        // Use the coordinates as the heuristic
        double dx = a.getX() - b.getX();
        double dy = a.getY() - b.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    private double calculateCost(double distance) {
        if (distance <= 2) {
            return 10.0;
        } else if (distance <= 5) {
            return 20.0;
        } else if (distance <= 12) {
            return 30.0;
        } else if (distance <= 21) {
            return 40.0;
        } else if (distance <= 32) {
            return 50.0;
        } else {
            return 60.0;
        }
    }

    class RouteNodeComparator implements Comparator<RouteNode> {
        public int compare(RouteNode a, RouteNode b) {
            return Double.compare(a.cost + a.fScore, b.cost + b.fScore);
        }
    }
}
