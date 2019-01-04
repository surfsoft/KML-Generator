package com.surfsoftconsulting.kmlgenerator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class RaceMetadata {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("d MMMM yyyy");
    private final int raceNo;
    private final String title;
    private final String departing;
    private final String arriving;
    private final LocalDateTime raceStartTime;
    private final LocalDateTime raceFinishTime;

    RaceMetadata(int raceNo, String title, String departing, String arriving, LocalDateTime raceStartTime, LocalDateTime raceFinishTime) {
        this.raceNo = raceNo;
        this.title = title;
        this.departing = departing;
        this.arriving = arriving;
        this.raceStartTime = raceStartTime;
        this.raceFinishTime = raceFinishTime;
    }

    int getRaceNo() {
        return raceNo;
    }

    String getTitle() {
        return title;
    }

    String getDescription() {
        return String.format("This race departed %s on %s and arrived at %s on %s", departing, raceStartTime.format(DATE_FORMATTER), arriving, raceFinishTime.format(DATE_FORMATTER));
    }

    LocalDateTime getRaceStartTime() {
        return raceStartTime;
    }

    LocalDateTime getRaceFinishTime() {
        return raceFinishTime;
    }

}
