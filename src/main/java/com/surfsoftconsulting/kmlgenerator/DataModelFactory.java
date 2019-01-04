package com.surfsoftconsulting.kmlgenerator;

import java.io.IOException;
import java.util.*;

import static java.util.stream.Collectors.toList;

class DataModelFactory {

    private final LegFactory legFactory = new LegFactory();
    private final RaceDataModelFactory raceDataModelFactory = new RaceDataModelFactory();

    Map<Object, Object> createDataModel() {

        Map<Object, Object> dataModel = new HashMap<>();

        dataModel.put("documentTitle", "Visit Seattle Legs 5 and 6");
        dataModel.put("documentDescription", "The routes sailed by Visit Seattle (CV26) on legs 5 and 6 of the 17/18 Clipper Round The World race");
        dataModel.put("legs", legFactory.createLegs().stream().map(this::createLegDataModel).collect(toList()));

        return dataModel;

    }

    private Map<Object, Object> createLegDataModel(LegMetadata legMetadata) {

        List<Map<Object, Object>> races = legMetadata.getRaces().stream().map(r -> {
            try {
                return raceDataModelFactory.createRace(legMetadata, r);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).collect(toList());

        return new LegDataModelFactory(legMetadata.getTitle(), legMetadata.getDescription(), races).createLeg();

    }

}
