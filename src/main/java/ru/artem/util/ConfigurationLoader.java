package ru.artem.util;

import ru.artem.Application;
import ru.artem.util.config.ext.ConfigurationExtractor;
import ru.artem.util.exception.ConfigurationLoadException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationLoader {
    private final String propertiesFilename;
    private final ConfigurationExtractor extractor;

    public ConfigurationLoader(String propertiesFilename, ConfigurationExtractor extractor) {
        this.propertiesFilename = propertiesFilename;
        this.extractor = extractor;
    }

    public Object load() throws ConfigurationLoadException {
        Properties properties = new Properties();
        InputStream inputStream = Application.class.getClassLoader().getResourceAsStream(propertiesFilename);
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new ConfigurationLoadException(e.getMessage(), e.getCause());
        }
        return extractor.extract(properties);
    }
}
