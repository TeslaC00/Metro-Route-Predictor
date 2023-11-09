package com.metro.prediction.metroroutepredictor.model.classes;
import com.metro.prediction.metroroutepredictor.model.interfaces.Connection;
import com.metro.prediction.metroroutepredictor.model.interfaces.Station;

import java.util.HashMap;
import java.util.*;
public class MinInterchangeRouteF {
        private MetroMap metroMap;

        public MinInterchangeRouteF() {
            metroMap = new MetroMap();
        }

        public class RouteNode {
            Station station;
            double gScore;
            double fScore;
            int interchangeCount; // Track interchange count
            List<Station> path;

            RouteNode(Station station, double gScore, double fScore, int interchangeCount, List<Station> path) {
                this.station = station;
                this.gScore = gScore;
                this.fScore = fScore;
                this.interchangeCount = interchangeCount;
                this.path = path;
            }
        }

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
                    if (!connection.getColor().equals()) {
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

        private double heuristic(Station a, Station b) {
            // Use the coordinates as the heuristic
            double dx = a.getX() - b.getX();
            double dy = a.getY() - b.getY();
            return Math.sqrt(dx * dx + dy * dy);
        }

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
