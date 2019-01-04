package com.surfsoftconsulting.kmlgenerator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class RaceDataModelFactory {

    private final int legNo;
    private final int raceNo;
    private final int maxRaceNo;
    private final String title;
    private final String description;

    RaceDataModelFactory(int legNo, int raceNo, int maxRaceNo, String title, String description) {
        this.legNo = legNo;
        this.raceNo = raceNo;
        this.maxRaceNo = maxRaceNo;
        this.title = title;
        this.description = description;
    }

    Map<Object, Object> createRace() throws IOException {

        Map<Object, Object> dataModel = new HashMap<>();

        final String filename;
        if (maxRaceNo == 1) {
            filename = String.format("/leg-%s.csv", legNo);
        }
        else {
            filename = String.format("/leg-%s-race-%s.csv", legNo, raceNo);
        }
        CoordinateReader coordinateReader = new CoordinateReader(filename);
        dataModel.put("title", title);
        dataModel.put("description", description);
        dataModel.put("coordinates", coordinateReader.getCoordinates());
        dataModel.put("longitude", coordinateReader.getLongitude());
        dataModel.put("latitude", coordinateReader.getLatitude());

        return dataModel;

    }

}
