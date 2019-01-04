package com.surfsoftconsulting.kmlgenerator;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

class LegFactory {

    List<LegMetadata> createLegs() {

        return asList(
                new LegMetadata(5, "Leg 5", "Australia to China", asList(
                        new RaceMetadata(1, "Race 1", "Airlie Beach, Australia to Sanya, China"),
                        new RaceMetadata(2, "Race 2", "Sanya, China to Qingdao, China"))),
                new LegMetadata(6, "Leg 6", "China to the USA",
                        singletonList(new RaceMetadata(1, "Race 1", "Qingdao, China to Seattle, USA")))
        );
    }


}
