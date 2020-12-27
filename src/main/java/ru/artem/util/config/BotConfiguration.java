package ru.artem.util.config;

public class BotConfiguration {
    private final String token;

    public BotConfiguration(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
