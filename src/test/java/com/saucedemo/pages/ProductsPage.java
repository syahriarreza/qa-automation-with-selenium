package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.util.List;

public class ProductsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By title = By.className("title");
    private By productItems = By.cssSelector(".inventory_item");
    private By addToCartButtons = By.cssSelector("button.btn_inventory");
    private By cartBtn = By.className("shopping_cart_link");
    private By checkoutBtn = By.id("checkout");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        assertEquals(this.getPageTitle(), "Products");
    }

    public boolean isOnProductsPage() {
        return driver.findElement(title).isDisplayed();
    }

    public String getPageTitle() {
        return driver.findElement(title).getText();
    }

    public void addFirstThreeItemsToCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productItems));

        List<WebElement> products = driver.findElements(productItems);
        List<WebElement> productAddToCartBtns = products.stream().map(p -> p.findElement(addToCartButtons)).toList();
        assertTrue(productAddToCartBtns.size() > 0);

        int itemCount = Math.min(3, productAddToCartBtns.size()); // only add if at least 3 exist
        for (int i = 0; i < itemCount; i++) {
            productAddToCartBtns.get(i).click();
        }
    }

    public void goToCart() {
        driver.findElement(cartBtn).click();
        assertEquals(this.getPageTitle(), "Your Cart");
    }

    public void goToCheckout() {
        driver.findElement(checkoutBtn).click();
    }
}
