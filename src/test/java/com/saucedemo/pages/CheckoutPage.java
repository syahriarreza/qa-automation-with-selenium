package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class CheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By title = By.className("title");
    private By firstName = By.xpath("//input[@id=\"first-name\"]");
    private By lastName = By.xpath("//input[@id=\"last-name\"]");
    private By zipCode = By.xpath("//input[@id=\"postal-code\"]");
    private By continueBtn = By.id("continue");
    private By finishBtn = By.id("finish");
    private By completeHeader = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;

        wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueBtn));

        assertEquals(this.getPageTitle(), "Checkout: Your Information");
    }

    public String getPageTitle() {
        return driver.findElement(title).getText();
    }

    public void fillBuyerData() {
        driver.findElement(firstName).sendKeys("John");
        driver.findElement(lastName).sendKeys("Doe");
        driver.findElement(zipCode).sendKeys("60246");
    }

    public void goToContinue() {
        driver.findElement(continueBtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(finishBtn));
        assertEquals(this.getPageTitle(), "Checkout: Overview");
    }

    public void goToFinish() {
        driver.findElement(finishBtn).click();
        assertEquals(this.getPageTitle(), "Checkout: Complete!");
    }

    public void assertComplete() {
        WebElement completeEl = driver.findElement(completeHeader);
        assertNotNull(completeEl);
        assertTrue(completeEl.getText().toLowerCase().contains("thank you"));
    }
}
