package com.surfsoftconsulting.kmlgenerator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class RaceDataModelFactory {

    Map<Object, Object> createRace(LegMetadata legMetadata, RaceMetadata raceMetadata) throws IOException {

        Map<Object, Object> dataModel = new HashMap<>();

        final String filename;
        if (legMetadata.getRaces().size() == 1) {
            filename = String.format("/leg-%s.csv", legMetadata.getLegNo());
        }
        else {
            filename = String.format("/leg-%s-race-%s.csv", legMetadata.getLegNo(), raceMetadata.getRaceNo());
        }
        CoordinateReader coordinateReader = new CoordinateReader(filename);
        dataModel.put("title", raceMetadata.getTitle());
        dataModel.put("description", raceMetadata.getDescription());
        dataModel.put("coordinates", coordinateReader.getCoordinates(raceMetadata.getRaceStartTime(), raceMetadata.getRaceFinishTime()));
        dataModel.put("longitude", coordinateReader.getLongitude(raceMetadata.getRaceStartTime()));
        dataModel.put("latitude", coordinateReader.getLatitude(raceMetadata.getRaceStartTime()));

        return dataModel;

    }

}
