package com.surfsoftconsulting.kmlgenerator;

class RaceMetadata {

    private final int raceNo;
    private final String title;
    private final String description;

    RaceMetadata(int raceNo, String title, String description) {
        this.raceNo = raceNo;
        this.title = title;
        this.description = description;
    }

    int getRaceNo() {
        return raceNo;
    }

    String getTitle() {
        return title;
    }

    String getDescription() {
        return description;
    }

}
