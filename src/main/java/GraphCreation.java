import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Station {
    int id;
    String name;
    double distance;
    boolean isInterchange;
    boolean isHeadStation;
    String changeLine;

    Station(int id, String name, double distance, boolean isInterchange, boolean isHeadStation, String changeLine) {
        this.id = id;
        this.name = name;
        this.distance = distance;
        this.isInterchange = isInterchange;
        this.isHeadStation = isHeadStation;
        this.changeLine = changeLine;
    }
}

class Line {
    String lineName;
    String color;
    List<Station> stations;

    Line(String lineName, String color) {
        this.lineName = lineName;
        this.color = color;
        this.stations = new ArrayList<>();
    }
}

public class GraphCreation {
    public static void main(String[] args) {
        try {
            String jsonFilePath = "src\main\resources\com\metro\prediction\metroroutepredictor\Metro_Stations.json";
            File jsonFile = new File(jsonFilePath);
            if (!jsonFile.exists()) {
                System.out.println("The JSON file does not exist.");
                return;
            }


            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(jsonFile);

            List<Line> lines = new ArrayList<>();

            for (JsonNode lineNode : rootNode.get("Line")) {
                String lineName = lineNode.get("Line_Name").asText();
                String color = lineNode.get("Color").asText();
                Line line = new Line(lineName, color);

                for (JsonNode stationNode : lineNode.get("Stations")) {
                    int id = stationNode.get("ID").asInt();
                    String stationName = stationNode.get("Station_Name").asText();
                    double distance = stationNode.get("Distance").asDouble();
                    boolean isInterchange = stationNode.get("Is_Interchange").asBoolean();
                    boolean isHeadStation = stationNode.get("Is_HeadStation").asBoolean();
                    String changeLine = stationNode.has("Change Line") ? stationNode.get("Change Line").asText() : null;

                    Station station = new Station(id, stationName, distance, isInterchange, isHeadStation, changeLine);
                    line.stations.add(station);
                }

                lines.add(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
