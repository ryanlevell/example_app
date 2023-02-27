package org.levell.example_app.config;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;
import java.net.URL;

public class Config {

    Configuration config;

    static final String TEMPLATE_CONFIG_FILE_NAME = "config-%s.properties";

    static final String PROP_PROFILE = "at.profile";
    static final String PROP_BASE_URI = "at.base-uri";

    public Config() {
        String profile = System.getProperty(PROP_PROFILE, "local");
        String fileName = String.format(TEMPLATE_CONFIG_FILE_NAME, profile);
        try {
            URL url = Thread.currentThread().getContextClassLoader().getResource(fileName);
            config = new Configurations().properties(new File(url.getFile()));
        } catch (ConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    public String getBaseUri() {
        return config.getString(PROP_BASE_URI);
    }
}
