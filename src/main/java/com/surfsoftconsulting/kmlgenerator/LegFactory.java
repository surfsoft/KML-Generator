package com.surfsoftconsulting.kmlgenerator;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

class LegFactory {

    private static final LocalDateTime LEG_1_START = LocalDateTime.of(2017, 8, 20, 9, 0, 0);
    private static final LocalDateTime LEG_1_FINISH = LocalDateTime.of(2017, 9, 23, 3, 0, 0);

    private static final LocalDateTime LEG_2_START = LocalDateTime.of(2017, 10, 4, 15, 0, 0);
    private static final LocalDateTime LEG_2_FINISH = LocalDateTime.of(2017, 10, 19, 3, 20, 0);

    private static final LocalDateTime LEG_3_START = LocalDateTime.of(2017, 10, 31, 10, 0, 0);
    private static final LocalDateTime LEG_3_FINISH = LocalDateTime.of(2017, 11, 25, 16, 30, 0);

    private static final LocalDateTime LEG_4_RACE_1_START = LocalDateTime.of(2017, 12, 2, 4, 0, 0);
    private static final LocalDateTime LEG_4_RACE_1_FINISH = LocalDateTime.of(2017, 12, 14, 23, 30, 0);
    private static final LocalDateTime LEG_4_RACE_2_START = LocalDateTime.of(2017, 12, 25, 23, 10, 0);
    private static final LocalDateTime LEG_4_RACE_2_FINISH = LocalDateTime.of(2017, 12, 29, 7, 0, 0);
    private static final LocalDateTime LEG_4_RACE_3_START = LocalDateTime.of(2018, 1, 4, 22, 10, 0);
    private static final LocalDateTime LEG_4_RACE_3_FINISH = LocalDateTime.of(2018, 1, 16, 12, 0, 0);

    private static final LocalDateTime LEG_5_RACE_1_START = LocalDateTime.of(2018, 1, 29, 0, 0, 0);
    private static final LocalDateTime LEG_5_RACE_1_FINISH = LocalDateTime.of(2018, 2, 22, 23, 0, 0);
    private static final LocalDateTime LEG_5_RACE_2_START = LocalDateTime.of(2018, 3, 4, 0, 0, 0);
    private static final LocalDateTime LEG_5_RACE_2_FINISH = LocalDateTime.of(2018, 3, 15, 1, 0, 0);

    private static final LocalDateTime LEG_6_START = LocalDateTime.of(2018, 3, 23, 4, 0, 0);
    private static final LocalDateTime LEG_6_FINISH = LocalDateTime.of(2018, 4, 21, 15, 30, 0);

    private static final LocalDateTime LEG_7_RACE_1_START = LocalDateTime.of(2018, 4, 20, 19, 0, 0);
    private static final LocalDateTime LEG_7_RACE_1_FINISH = LocalDateTime.of(2018, 5, 23, 13, 0, 0);
    private static final LocalDateTime LEG_7_RACE_2_START = LocalDateTime.of(2018, 6, 3, 13, 30, 0);
    private static final LocalDateTime LEG_7_RACE_2_FINISH = LocalDateTime.of(2018, 6, 14, 13, 0, 0);

    private static final LocalDateTime LEG_8_RACE_1_START = LocalDateTime.of(2018, 6, 25, 13, 0, 0);
    private static final LocalDateTime LEG_8_RACE_1_FINISH = LocalDateTime.of(2018, 7, 9, 11, 30, 0);
    private static final LocalDateTime LEG_8_RACE_2_START = LocalDateTime.of(2018, 7, 22, 11, 0, 0);
    private static final LocalDateTime LEG_8_RACE_2_FINISH = LocalDateTime.of(2018, 7, 28, 11, 7, 0);

    List<LegMetadata> createLegs() {

        return asList(
                new LegMetadata(5, "Leg 5", "Australia to China", asList(
                        new RaceMetadata(1, "Race 1", "Airlie Beach, Australia", "Sanya, China", LEG_5_RACE_1_START, LEG_5_RACE_1_FINISH),
                        new RaceMetadata(2, "Race 2", "Sanya, China", "Qingdao, China", LEG_5_RACE_2_START, LEG_5_RACE_2_FINISH))),
                new LegMetadata(6, "Leg 6", "China to the USA",
                        singletonList(new RaceMetadata(1, "Race 1", "Qingdao, China", "Seattle, USA", LEG_6_START, LEG_6_FINISH)))
        );
    }


}
