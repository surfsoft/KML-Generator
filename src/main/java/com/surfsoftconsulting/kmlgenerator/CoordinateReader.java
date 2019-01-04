package com.surfsoftconsulting.kmlgenerator;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

// TODO assumes that the contents of the CSV file is in chronological order
// TODO refactor to read into a class instead of a list of String[] as this will also remove the need for the separate list of converted timestamps
class CoordinateReader {

    private static final DateTimeFormatter TIMESTAMP_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private final List<String[]> coordinates;
    private final List<LocalDateTime> timestamps = new ArrayList<>();

    CoordinateReader(String filename) {

        InputStream resourceAsStream = getClass().getResourceAsStream(filename);
        try {
            coordinates = new CSVReader(new InputStreamReader(resourceAsStream)).readAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int index = 0;
        while (index < coordinates.size()) {
            if (!coordinates.get(index)[15].equalsIgnoreCase("routine position")) {
                coordinates.remove(index);
            }
            else {
                index++;
            }
        }

        for (String[] line: coordinates) {
            timestamps.add(LocalDateTime.parse(line[1], TIMESTAMP_FORMAT));
        }

    }

    String getCoordinates(LocalDateTime fromTimestamp, LocalDateTime toTimestamp) {

        StringBuilder buffer = new StringBuilder();

        int fromIndex = findClosestEntry(fromTimestamp);
        int toIndex = findClosestEntry(toTimestamp);

        for (int index = fromIndex; index <= toIndex; index++) {
            if (buffer.length() > 0) {
                buffer.append("\n");
            }
            buffer.append(String.join(",", getLongitude(index), getLatitude(index), "0"));
        }

        return buffer.toString();

    }

    String getLongitude(LocalDateTime timestamp) {
        return getLongitude(findClosestEntry(timestamp));
    }

    String getLatitude(LocalDateTime timestamp) {
        return getLatitude(findClosestEntry(timestamp));
    }

    private String getLongitude(int index) {
        return coordinates.get(index)[4];
    }

    private String getLatitude(int index) {
        return coordinates.get(index)[3];
    }

    private int findClosestEntry(LocalDateTime timestamp) {

        boolean found = false;
        int closestEntry = 0;

        if (timestamp.isBefore(timestamps.get(0)) || timestamp.isAfter(timestamps.get(timestamps.size() - 1))) {
            throw new IllegalStateException(format("Timestamp %s is out of range for the data provided (earliest is %s, latest is %s)", timestamp, timestamps.get(0), timestamps.get(timestamps.size() - 1)));
        }

        for (int index = 0; index < timestamps.size() && !found; index++) {
            if (timestamp.isBefore(timestamps.get(index))) {
                // Current row is later than the required timestamp. Use the previous row (or current row if current row is the first one).
                found = true;
                closestEntry = (index == 0) ? index : index - 1;
            }
            else if (!timestamp.isAfter(timestamps.get(index))) {
                // Current row is the same as the required timestamp. Use this row.
                found = true;
                closestEntry = index;
            }
        }

        if (!found) {
            throw new IllegalStateException(format("Timestamp %s is out of range for the data provided (earliest is %s, latest is %s) - Is your CSV file in chronological order?", timestamp, timestamps.get(0), timestamps.get(timestamps.size() - 1)));
        }

        return closestEntry;

    }

}
