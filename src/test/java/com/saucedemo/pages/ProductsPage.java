package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage {
    private WebDriver driver;

    private By productTitle = By.className("title");
    private By productItems = By.cssSelector(".inventory_item");
    private By addToCartButtons = By.cssSelector("button.btn_inventory");
    private By cartBtn = By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOnProductsPage() {
        return driver.findElement(productTitle).isDisplayed();
    }

    public String getProductTitle() {
        return driver.findElement(productTitle).getText();
    }

    public void addFirstThreeItemsToCart() {
        List<WebElement> products = driver.findElements(productItems);
        List<WebElement> productAddToCartBtns = products.stream().map(p -> p.findElement(addToCartButtons)).toList();

        int itemCount = Math.min(3, productAddToCartBtns.size()); // only add if at least 3 exist
        for (int i = 0; i < itemCount; i++) {
            productAddToCartBtns.get(i).click();
        }
    }

    public void goToCart() {
        driver.findElement(cartBtn).click();
    }
}
