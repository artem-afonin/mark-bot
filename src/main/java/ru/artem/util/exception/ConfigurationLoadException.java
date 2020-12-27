package ru.artem.util.exception;

import java.io.IOException;

public class ConfigurationLoadException extends IOException {
    public ConfigurationLoadException(String message, Throwable cause) {
        super(message, cause);
    }
}
