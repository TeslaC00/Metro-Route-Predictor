/**
 * The ShortRouteF class that aims to find the shortest path between two metro stations
 * using the A* algorithm.
 *
 * <p>It calculates the cost of each connection and uses a heuristic approach to prioritize paths with the minimum cost.</p>
 */
package com.metro.prediction.metroroutepredictor.model.classes;

import com.metro.prediction.metroroutepredictor.model.interfaces.Connection;
import com.metro.prediction.metroroutepredictor.model.interfaces.Station;

import java.util.*;

public class ShortRouteF {

    private final MetroMap metroMap;

    /**
     * Constructs a ShortRouteF object with a default MetroMap.
     */
    public ShortRouteF() {
        metroMap = new MetroMap();
    }

    /**
     * Finds the shortest route between the given start and goal stations.
     *
     * @param start The starting station.
     * @param goal  The destination station.
     * @return The list of stations representing the shortest route.
     */
    public List<Station> findRoute(Station start, Station goal) {
        PriorityQueue<Node> openSet = new PriorityQueue<>(new NodeComparator());
        // The Cost of path from current station to neighbor
        Map<Station, Double> gScore = new HashMap<>();
        Map<Station, Station> cameFrom = new HashMap<>();

        gScore.put(start, 0.0);
        openSet.add(new Node(start, 0.0, heuristic(start, goal)));

        while (!openSet.isEmpty()) {
            // Poll is used to remove from Priority Queue
            Node current = openSet.poll();
            // Reconstructs Shortest Path when you reach the goal
            if (current.station.equals(goal)) {
                // Reconstruct the path from the goal to the start
                List<Station> path = new ArrayList<>();
                Station currentNode = goal;
                while (currentNode != null) {
                    path.add(currentNode);
                    currentNode = cameFrom.get(currentNode);
                }
                Collections.reverse(path);
                return path;
            }
            //  If not goal station, Compare the next neighbour to judge next station
            for (Connection connection : metroMap.getConnections(current.station)) {
                Station neighbor = metroMap.getStationByName(connection.getDestination());
                double tentativeGScore = gScore.get(current.station) + connection.getDistance();

                if (tentativeGScore < gScore.getOrDefault(neighbor, Double.MAX_VALUE)) {
                    cameFrom.put(neighbor, current.station);
                    gScore.put(neighbor, tentativeGScore);
                    // fScore = cost till now + heuristic
                    double fScore = tentativeGScore + heuristic(neighbor, goal);
                    openSet.add(new Node(neighbor, tentativeGScore, fScore));
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
        // Use the coordinates as the heuristic(Euclidean Distance)
        double dx = a.getX() - b.getX();
        double dy = a.getY() - b.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Represents a node in the A* algorithm.
     */
    class Node {

        Station station;
        double gScore;
        double fScore;

        /**
         * Constructs a Node with the specified parameters.
         *
         * @param station The current station in the node.
         * @param gScore  The cost to reach the current station from the start.
         * @param fScore  The estimated total cost to reach the goal from the current station.
         */
        Node(Station station, double gScore, double fScore) {
            this.station = station;
            this.gScore = gScore;
            this.fScore = fScore;
        }
    }

    /**
     * Comparator for comparing Node objects based on their fScore values.
     */
    class NodeComparator implements Comparator<Node> {
        /**
         * Compares the fScore of nodes for prioritizing in the priority queue.
         *
         * @param a The first node.
         * @param b The second node.
         * @return The comparison result.
         */
        public int compare(Node a, Node b) {
            return Double.compare(a.fScore, b.fScore);
        }
    }

}


