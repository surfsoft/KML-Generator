package com.surfsoftconsulting.kmlgenerator;

import java.util.List;

class LegMetadata {

    private final int legNo;
    private final String title;
    private final String description;
    private final List<RaceMetadata> races;

    LegMetadata(int legNo, String title, String description, List<RaceMetadata> races) {
        this.legNo = legNo;
        this.title = title;
        this.description = description;
        this.races = races;
    }

    int getLegNo() {
        return legNo;
    }

    String getTitle() {
        return title;
    }

    String getDescription() {
        return description;
    }

    List<RaceMetadata> getRaces() {
        return races;
    }

}
