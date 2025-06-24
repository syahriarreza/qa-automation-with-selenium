package com.saucedemo.abstractcomponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
    WebDriver driver;

    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isElementPresent(By locator) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0)); // temporary disable implicit wait
        boolean exists = driver.findElements(locator).size() > 0;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // restore implicit wait
        return exists;
    }

    public void waitUntilElementPresent(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
