package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    private WebDriver driver;

    private By productTitle = By.className("title");
    private By cartButton = By.id("shopping_cart_container");
    private By addToCartBackpack = By.id("add-to-cart-sauce-labs-backpack");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductTitle() {
        return driver.findElement(productTitle).getText();
    }

    public void addBackpackToCart() {
        // /html/body/div[1]/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/button
        // //*[@id="add-to-cart-sauce-labs-backpack"]
        driver.findElement(addToCartBackpack).click();
    }

    public void clickCartButton() {
        driver.findElement(cartButton).click();
    }
}
