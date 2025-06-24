package com.saucedemo.helper;

import io.github.cdimascio.dotenv.Dotenv;

public class Config {
    private static final Dotenv dotenv = Dotenv.configure().load();

    // Method to get BASE_URL
    public static String getBaseUrl() {
        return dotenv.get("BASE_URL");
    }

    // Method to get BROWSER
    public static String getBrowser() {
        return dotenv.get("BROWSER");
    }

    // Method to get DRIVER_PATH
    public static String getDriverPath() {
        return dotenv.get("DRIVER_PATH");
    }
}