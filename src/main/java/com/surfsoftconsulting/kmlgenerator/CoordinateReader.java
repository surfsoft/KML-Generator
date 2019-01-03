package com.surfsoftconsulting.kmlgenerator;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

class CoordinateReader {

    private final List<String[]> coordinates;

    CoordinateReader(String filename) throws IOException {
        InputStream resourceAsStream = getClass().getResourceAsStream(filename);
        coordinates = new CSVReader(new InputStreamReader(resourceAsStream)).readAll();
    }

    String getCoordinates() {

        StringBuilder buffer = new StringBuilder();

        for (String[] line: coordinates) {
            if (buffer.length() > 0) {
                buffer.append(",\n");
            }
            buffer.append(String.join(",", line[4], line[3], "0"));
        }

        return buffer.toString();

    }

    String getLongitude() {
        return getLongitude(coordinates.get(0));
    }

    String getLatitude() {
        return getLatitude(coordinates.get(0));
    }

    private String getLongitude(String[] line) {
        return line[4];
    }

    private String getLatitude(String[] line) {
        return line[3];
    }

}
