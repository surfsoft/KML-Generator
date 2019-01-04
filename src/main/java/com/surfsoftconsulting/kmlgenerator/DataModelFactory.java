package com.surfsoftconsulting.kmlgenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

class DataModelFactory {

    private final LegFactory legFactory = new LegFactory();
    private final RaceDataModelFactory raceDataModelFactory = new RaceDataModelFactory(new CoordinateReader("/rtw.csv"));

    Map<Object, Object> createDataModel() {

        Map<Object, Object> dataModel = new HashMap<>();

        dataModel.put("documentTitle", "Clipper Round the World 17/18 - Visit Seattle GPS track");
        dataModel.put("documentDescription", "The routes sailed by Visit Seattle (CV26) on the 17/18 Clipper Round The World race. Note that dates shown are UTC and not localised (hence the Sydney-Hobart race has a start date of December 25th 2017");
        dataModel.put("legs", legFactory.createLegs().stream().map(this::createLegDataModel).collect(toList()));

        return dataModel;

    }

    private Map<Object, Object> createLegDataModel(LegMetadata legMetadata) {

        List<Map<Object, Object>> races = legMetadata.getRaces().stream().map(raceDataModelFactory::createRace).collect(toList());

        return new LegDataModelFactory(legMetadata.getTitle(), legMetadata.getDescription(), races).createLeg();

    }

}
