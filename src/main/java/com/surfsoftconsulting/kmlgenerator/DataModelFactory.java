package com.surfsoftconsulting.kmlgenerator;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class DataModelFactory {

    Map<Object, Object> createDataModel() throws IOException {

        Map<Object, Object> dataModel = new HashMap<>();

        dataModel.put("documentTitle", "Visit Seattle Legs 5 and 6");
        dataModel.put("documentDescription", "The routes sailed by Visit Seattle (CV26) on legs 5 and 6 of the 17/18 Clipper Round The World race");

        Map<Object, Object> leg5Race1 = new RaceFactory(5, 1, 2, "Airlie Beach, Australia to Sanya, China").createRace();
        Map<Object, Object> leg5Race2 = new RaceFactory(5, 2, 2, "Sanya, China to Qingdao, China").createRace();
        Map<Object, Object> leg5 = new LegFactory(5, "Australia to China", Arrays.asList(leg5Race1, leg5Race2)).createLeg();
        Map<Object, Object> leg6Race1 = new RaceFactory(6, 1, 1, "Qingdao, China to Seattle, USA").createRace();
        Map<Object, Object> leg6 = new LegFactory(6, "China to the USA", Collections.singletonList(leg6Race1)).createLeg();

        dataModel.put("legs", Arrays.asList(leg5, leg6));

        return dataModel;

    }

}
