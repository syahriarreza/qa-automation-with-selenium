package com.saucedemo.hook;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import com.saucedemo.helper.Config;

import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setup() {
        String browser = Config.getBrowser(); // Get browser type from .env
        String driverPath = Config.getDriverPath(); // Get driver path from .env

        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", driverPath);

                // Disable credential saving popup
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--incognito");

                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", driverPath);

                // Disable credential saving popup
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("-private");

                driver = new FirefoxDriver(firefoxOptions);
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(Config.getBaseUrl()); // Get base URL from .env
    }

    @After
    public void teardown() {
        // Cleanup tasks after each scenario
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
