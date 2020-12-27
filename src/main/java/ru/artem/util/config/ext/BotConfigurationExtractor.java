package ru.artem.util.config.ext;

import ru.artem.util.config.BotConfiguration;

import java.util.Properties;

public class BotConfigurationExtractor implements ConfigurationExtractor<BotConfiguration> {
    @Override
    public BotConfiguration extract(Properties properties) {
        String token = properties.getProperty("token");
        BotConfiguration configuration = new BotConfiguration(token);
        return configuration;
    }
}
