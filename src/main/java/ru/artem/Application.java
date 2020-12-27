package ru.artem;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import ru.artem.bot.listener.PingListener;
import ru.artem.util.ConfigurationLoader;
import ru.artem.util.config.BotConfiguration;
import ru.artem.util.config.ext.BotConfigurationExtractor;
import ru.artem.util.exception.ConfigurationLoadException;

import javax.security.auth.login.LoginException;

public class Application {
    public static void main(String[] args) throws LoginException, InterruptedException {
        BotConfiguration botConfiguration = loadBotConfiguration();
        JDA jda = JDABuilder.createDefault(botConfiguration.getToken())
                .addEventListeners(new PingListener())
                .build();
        jda.awaitReady();
    }

    private static BotConfiguration loadBotConfiguration() {
        BotConfiguration botConfiguration = null;
        try {
            BotConfigurationExtractor extractor = new BotConfigurationExtractor();
            String filename = "bot.properties";
            ConfigurationLoader loader = new ConfigurationLoader(filename, extractor);
            botConfiguration = (BotConfiguration) loader.load();
        } catch (ConfigurationLoadException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return botConfiguration;
    }
}
