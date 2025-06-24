package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.saucedemo.abstractcomponent.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
    private WebDriver driver;

    @FindBy(className = "title")
    private WebElement titleEl;

    @FindBy(id = "first-name")
    private WebElement firstNameInputEl;

    @FindBy(id = "last-name")
    private WebElement lastNameInputEl;

    @FindBy(id = "postal-code")
    private WebElement zipCodeInputEl;

    @FindBy(id = "continue")
    private WebElement continueBtnEl;

    @FindBy(id = "finish")
    private WebElement finishBtnEl;

    private By completeHeader = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        super(driver); // Call to the constructor of parent (AbstractComponent)
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        // return driver.findElement(title).getText();
        return titleEl.getText();
    }

    public void fillBuyerData() {
        firstNameInputEl.sendKeys("John");
        lastNameInputEl.sendKeys("Doe");
        zipCodeInputEl.sendKeys("60246");
    }

    public void goToContinue() {
        continueBtnEl.click();
    }

    public void goToFinish() {
        finishBtnEl.click();
    }

    public String getCompleteHeaderText() {
        if (isElementPresent(completeHeader) == false) {
            return ""; // Return empty string if the complete header is not present
        }

        return driver.findElement(completeHeader).getText();
    }
}
