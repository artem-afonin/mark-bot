package ru.artem.util.config.ext;

import java.util.Properties;

public interface ConfigurationExtractor<T> {
    T extract(Properties properties);
}
