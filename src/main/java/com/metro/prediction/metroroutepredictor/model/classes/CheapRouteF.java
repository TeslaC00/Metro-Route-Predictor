/**
 * The CheapRouteF class that minimizes cost while finding the path with the least cost
 * between two metro stations using the A* algorithm.
 *
 * <p>It calculates the cost of each connection based on predefined distance intervals and returns the path with the
 * minimum cost.</p>
 */
package com.metro.prediction.metroroutepredictor.model.classes;

import com.metro.prediction.metroroutepredictor.model.interfaces.Connection;
import com.metro.prediction.metroroutepredictor.model.interfaces.Station;

import java.util.*;

public class CheapRouteF {
    private final MetroMap metroMap;

    /**
     * Constructs a CheapRouteF object with a default MetroMap.
     */
    public CheapRouteF() {
        metroMap = new MetroMap();
    }

    /**
     * Finds the cheapest route between the given start and goal stations.
     *
     * @param start The starting station.
     * @param goal  The destination station.
     * @return The list of stations representing the cheapest route.
     */
    public List<Station> findCheapestRoute(Station start, Station goal) {
        PriorityQueue<RouteNode> openSet = new PriorityQueue<>(new RouteNodeComparator());
        // The Cost of path from current station to neighbor
        Map<Station, Double> gScore = new HashMap<>();
        Map<Station, Station> cameFrom = new HashMap<>();

        gScore.put(start, 0.0);
        openSet.add(new RouteNode(start, 0.0, heuristic(start, goal), 0.0, new ArrayList<>()));

        while (!openSet.isEmpty()) {
            // Poll is used to remove from Priority Queue
            RouteNode current = openSet.poll();
            // Reconstruct the path from the goal to the start
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

    /**
     * Computes the heuristic value between two stations using their coordinates.
     *
     * @param a The first station.
     * @param b The second station.
     * @return The Euclidean distance between the two stations.
     */
    private double heuristic(Station a, Station b) {
        // Use the coordinates as the heuristic
        double dx = a.getX() - b.getX();
        double dy = a.getY() - b.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Calculates the cost based on the predefined distance intervals.
     *
     * @param distance The distance of the connection.
     * @return The calculated cost for the connection.
     */
    private double calculateCost(double distance) {
        if (distance <= 2000) {
            return 10.0;
        } else if (distance <= 5000) {
            return 20.0;
        } else if (distance <= 12000) {
            return 30.0;
        } else if (distance <= 21000) {
            return 40.0;
        } else if (distance <= 32000) {
            return 50.0;
        } else {
            return 60.0;
        }
    }

    /**
     * Represents a node in the route finding process.
     */
    public static class RouteNode {
        Station station;
        double gScore;
        double fScore;
        double cost;
        List<Station> path;

        /**
         * Constructs a RouteNode with the specified parameters.
         *
         * @param station The current station in the node.
         * @param gScore  The cost to reach the current station from the start.
         * @param fScore  The estimated total cost to reach the goal from the current station.
         * @param cost    The total cost of the path from the start to the current station.
         * @param path    The list of stations representing the current path.
         */
        RouteNode(Station station, double gScore, double fScore, double cost, List<Station> path) {
            this.station = station;
            this.gScore = gScore;
            this.fScore = fScore;
            this.cost = cost;
            this.path = path;
        }
    }

    /**
     * Comparator for comparing RouteNode objects based on total cost and estimated cost to the goal.
     */
    static class RouteNodeComparator implements Comparator<RouteNode> {
        public int compare(RouteNode a, RouteNode b) {
            return Double.compare(a.cost + a.fScore, b.cost + b.fScore);
        }
    }
}
