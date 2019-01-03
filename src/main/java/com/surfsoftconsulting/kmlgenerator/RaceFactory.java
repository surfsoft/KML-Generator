package com.surfsoftconsulting.kmlgenerator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class RaceFactory {

    private final int legNo;
    private final int raceNo;
    private final int maxRaceNo;
    private final String description;

    RaceFactory(int legNo, int raceNo, int maxRaceNo, String description) {
        this.legNo = legNo;
        this.raceNo = raceNo;
        this.maxRaceNo = maxRaceNo;
        this.description = description;
    }

    Map<Object, Object> createRace() throws IOException {

        Map<Object, Object> dataModel = new HashMap<>();

        final String title;
        final String filename;
        if (maxRaceNo == 1) {
            title = String.format("Leg %s", legNo);
            filename = String.format("/leg-%s.csv", legNo);
        }
        else {
            title = String.format("Leg %s race %s", legNo, raceNo);
            filename = String.format("/leg-%s-race-%s.csv", legNo, raceNo);
        }
        CoordinateReader coordinateReader = new CoordinateReader(filename);
        dataModel.put("title", title);
        dataModel.put("description", description);
        dataModel.put("coordinates", coordinateReader.getCoordinates());
        dataModel.put("longitude", coordinateReader.getLongitude());
        dataModel.put("latitude", coordinateReader.getLatitude());


        // TODO add 'lookat' and line string

        return dataModel;

    }

}
