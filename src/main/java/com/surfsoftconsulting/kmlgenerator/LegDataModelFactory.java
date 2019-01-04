package com.surfsoftconsulting.kmlgenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LegDataModelFactory {

    private final String title;
    private final String description;
    private final List<Map<Object, Object>> races;

    LegDataModelFactory(String title, String description, List<Map<Object, Object>> races) {
        this.title = title;
        this.description = description;
        this.races = races;
    }

    Map<Object, Object> createLeg() {

        Map<Object, Object> dataModel = new HashMap<>();

        dataModel.put("title", title);
        dataModel.put("description", description);
        dataModel.put("races", races);

        return dataModel;
    }

}
