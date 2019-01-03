package com.surfsoftconsulting.kmlgenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LegFactory {

    private final int legNo;
    private final String description;
    private final List<Map<Object, Object>> races;

    LegFactory(int legNo, String description, List<Map<Object, Object>> races) {
        this.legNo = legNo;
        this.description = description;
        this.races = races;
    }

    Map<Object, Object> createLeg() {

        Map<Object, Object> dataModel = new HashMap<>();

        dataModel.put("title", String.format("Leg %s", legNo));
        dataModel.put("description", description);
        dataModel.put("races", races);

        return dataModel;
    }

}
