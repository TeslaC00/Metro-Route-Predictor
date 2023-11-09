package com.metro.prediction.metroroutepredictor.model.classes;
import com.metro.prediction.metroroutepredictor.model.interfaces.Connection;
import com.metro.prediction.metroroutepredictor.model.interfaces.Station;

import java.util.*;

public class ShortRouteF {

    private final MetroMap metroMap; // Add a reference to the MetroMap

    public ShortRouteF() {
        metroMap = new MetroMap();
    }
    public List<Station> findRoute(Station start, Station goal) {
        PriorityQueue<Node> openSet = new PriorityQueue<>(new NodeComparator());
        Map<Station, Double> gScore = new HashMap<>();
        Map<Station, Station> cameFrom = new HashMap<>();

        gScore.put(start, 0.0);
        openSet.add(new Node(start, 0.0, heuristic(start, goal)));

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();

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

            for (Connection connection : metroMap.getConnections(current.station)) {
                Station neighbor = metroMap.getStationByName(connection.getDestination());
                double tentativeGScore = gScore.get(current.station) + connection.getDistance();

                if (tentativeGScore < gScore.getOrDefault(neighbor, Double.MAX_VALUE)) {
                    cameFrom.put(neighbor, current.station);
                    gScore.put(neighbor, tentativeGScore);
                    double fScore = tentativeGScore + heuristic(neighbor, goal);
                    openSet.add(new Node(neighbor, tentativeGScore, fScore));
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


    class Node {
        Station station;
        double gScore;
        double fScore;

        Node(Station station, double gScore, double fScore) {
            this.station = station;
            this.gScore = gScore;
            this.fScore = fScore;
        }
    }

    class NodeComparator implements Comparator<Node> {
        public int compare(Node a, Node b) {
            return Double.compare(a.fScore, b.fScore);
        }
    }

}


