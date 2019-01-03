package com.surfsoftconsulting.kmlgenerator;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.TemplateExceptionHandler;

class ConfigurationFactory {

    Configuration createConfiguration() {

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_27);
        configuration.setClassForTemplateLoading(this.getClass(), "/");
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setLogTemplateExceptions(false);
        configuration.setWrapUncheckedExceptions(true);
        configuration.setObjectWrapper(new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_27).build());

        return configuration;

    }

}
