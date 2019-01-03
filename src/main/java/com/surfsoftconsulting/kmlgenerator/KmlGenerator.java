package com.surfsoftconsulting.kmlgenerator;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

public class KmlGenerator {

    public static void main(String[] args) throws Exception {

        Configuration configuration = new ConfigurationFactory().createConfiguration();
        Map root = new DataModelFactory().createDataModel();

        Template temp = configuration.getTemplate("kml-file.ftlh");

        Writer out = new OutputStreamWriter(new FileOutputStream("visit-seattle.kml"));
        temp.process(root, out);
        out.close();

    }

}
