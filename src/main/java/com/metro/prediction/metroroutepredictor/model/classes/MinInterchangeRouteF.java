package com.metro.prediction.metroroutepredictor.model.classes;

import com.metro.prediction.metroroutepredictor.model.interfaces.Connection;
import com.metro.prediction.metroroutepredictor.model.interfaces.Station;

import java.util.*;

/**
 * The MinInterchangeRouteF class that minimizes interchange while finding the shortest path
 * between two metro stations using the A* algorithm.
 *
 * <p>It uses a heuristic approach and prioritizes paths with the minimum number of interchanges.</p>
 */
public class MinInterchangeRouteF {
    private final MetroMap metroMap;

    /**
     * Constructs a MinInterchangeRouteF object with a default MetroMap.
     */
    public MinInterchangeRouteF() {
        metroMap = new MetroMap();
    }

    /**
     * Finds the route with the minimum interchange between the given start and goal stations.
     *
     * @param start The starting station.
     * @param goal  The destination station.
     * @return The list of stations representing the route with minimum interchange.
     */
    public List<Station> findMinInterchangeRoute(Station start, Station goal) {
        PriorityQueue<RouteNode> openSet = new PriorityQueue<>(new RouteNodeComparator());
        Map<Station, Double> gScore = new HashMap<>();
        Map<Station, Station> cameFrom = new HashMap<>();

        gScore.put(start, 0.0);
        openSet.add(new RouteNode(start, 0.0, heuristic(start, goal), 0, new ArrayList<>()));

        while (!openSet.isEmpty()) {
            RouteNode current = openSet.poll();

            if (current.station.equals(goal)) {
                return current.path; // Return the route with minimum interchange
            }

            for (Connection connection : metroMap.getConnections(current.station)) {
                Station neighbor = metroMap.getStationByName(connection.getDestination());
                double tentativeGScore = current.gScore + connection.getDistance();

                int interchangeCount = current.interchangeCount;
                if (current.path.size() >= 2 && !getPreviousConnectionColor(current).equals(connection.getColor())) {
                    interchangeCount++; // Increase interchange count if changing lines
                }


                if (tentativeGScore < gScore.getOrDefault(neighbor, Double.MAX_VALUE)) {
                    cameFrom.put(neighbor, current.station);
                    gScore.put(neighbor, tentativeGScore);

                    double fScore = tentativeGScore + heuristic(neighbor, goal);

                    List<Station> path = new ArrayList<>(current.path);
                    path.add(neighbor);

                    openSet.add(new RouteNode(neighbor, tentativeGScore, fScore, interchangeCount, path));
                }
            }
        }

        // If the while loop terminates, no path was found
        return null;
    }

    private String getPreviousConnectionColor(RouteNode current) {
        if (current.path.size() >= 2) {
            int previousConnectionIndex = current.path.size() - 2;
            Station previousStation = current.path.get(previousConnectionIndex);
            Station currentStation = current.station;

            // Find the connection between the previous station and the current station
            for (Connection connection : metroMap.getConnections(previousStation)) {
                if (connection.getDestination().equals(currentStation.getStationName())) {
                    return connection.getColor();
                }
            }
        }
        // Return an empty string or handle the case where the color is not found
        return "";
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
     * Represents a node in the route finding process.
     */
    public class RouteNode {
        Station station;
        double gScore;
        double fScore;
        int interchangeCount; // Track interchange count
        List<Station> path;

        /**
         * Constructs a RouteNode with the specified parameters.
         *
         * @param station          The current station in the node.
         * @param gScore           The cost to reach the current station from the start.
         * @param fScore           The estimated total cost to reach the goal from the current station.
         * @param interchangeCount The number of interchanges on the path.
         * @param path             The list of stations representing the current path.
         */
        RouteNode(Station station, double gScore, double fScore, int interchangeCount, List<Station> path) {
            this.station = station;
            this.gScore = gScore;
            this.fScore = fScore;
            this.interchangeCount = interchangeCount;
            this.path = path;
        }
    }

    /**
     * Comparator for comparing RouteNode objects based on interchange count and total cost.
     */
    class RouteNodeComparator implements Comparator<RouteNode> {
        public int compare(RouteNode a, RouteNode b) {
            // Prioritize paths with fewer interchanges
            int interchangeDiff = a.interchangeCount - b.interchangeCount;
            if (interchangeDiff != 0) {
                return interchangeDiff;
            }
            return Double.compare(a.fScore, b.fScore);
        }
    }
}
