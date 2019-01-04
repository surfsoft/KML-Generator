package com.surfsoftconsulting.kmlgenerator;

import java.util.HashMap;
import java.util.Map;

class RaceDataModelFactory {

    private final CoordinateReader coordinateReader;

    RaceDataModelFactory(CoordinateReader coordinateReader) {
        this.coordinateReader = coordinateReader;
    }

    Map<Object, Object> createRace(RaceMetadata raceMetadata) {

        Map<Object, Object> dataModel = new HashMap<>();

        dataModel.put("title", raceMetadata.getTitle());
        dataModel.put("description", raceMetadata.getDescription());
        dataModel.put("coordinates", coordinateReader.getCoordinates(raceMetadata.getRaceStartTime(), raceMetadata.getRaceFinishTime()));
        dataModel.put("longitude", coordinateReader.getLongitude(raceMetadata.getRaceStartTime()));
        dataModel.put("latitude", coordinateReader.getLatitude(raceMetadata.getRaceStartTime()));

        return dataModel;

    }

}
