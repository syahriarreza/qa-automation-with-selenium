package com.saucedemo.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.saucedemo.hook.Hooks;
import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.ProductsPage;

import io.cucumber.java.en.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckoutStepDefinitions {
    WebDriver driver;
    ProductsPage productsPage;
    CheckoutPage coPage;

    public CheckoutStepDefinitions() {
        driver = Hooks.getDriver();
        productsPage = new ProductsPage(driver);
        coPage = new CheckoutPage(driver);
    }

    @Given("the user is on the products page")
    public void the_user_is_on_the_products_page() {
        assertTrue(driver.getCurrentUrl().contains("inventory.html"));
        assertTrue(productsPage.getPageTitle().equals("Products"));
    }

    @Given("the cart is empty")
    public void the_cart_is_empty() {
        assertEquals(productsPage.getCartItemCount(), 0, "Cart should be empty at the start");
    }

    @When("the user adds {int} items to the cart")
    public void the_user_adds_items_to_the_cart(Integer itemCount) {
        productsPage.addSomeItemsToCart(itemCount);
        assertEquals(itemCount, productsPage.getCartItemCount(), "Item count in cart does not match expected");
    }

    @When("the user proceeds to the cart page")
    public void the_user_proceeds_to_the_cart_page() {
        productsPage.goToCart();
        assertEquals(productsPage.getPageTitle(), "Your Cart", "Not in cart page after going to cart");
    }

    @When("the user proceeds to the checkout page")
    public void the_user_proceeds_to_the_checkout_page() {
        productsPage.goToCheckout();
        assertEquals(coPage.getPageTitle(), "Checkout: Your Information", "Not in checkout page");
    }

    @When("the user fills in buyer information")
    public void the_user_fills_in_buyer_information() {
        coPage.fillBuyerData();
    }

    @When("the user continues to the checkout overview page")
    public void the_user_continues_to_the_checkout_overview_page() {
        coPage.goToContinue();
        assertEquals(coPage.getPageTitle(), "Checkout: Overview", "Not in checkout overview page");
    }

    @When("the user finishes the checkout process")
    public void the_user_finishes_the_checkout_process() {
        coPage.goToFinish();
    }

    @Then("the user should see the checkout complete page")
    public void the_user_should_see_the_checkout_complete_page() {
        assertEquals(coPage.getPageTitle(), "Checkout: Complete!", "Not in checkout complete page");
    }

    @Then("the header should contain {string}")
    public void the_header_should_contain(String expectedHeader) {
        assertTrue(coPage.getCompleteHeaderText().toLowerCase().contains(expectedHeader.toLowerCase()),
                "Complete header text does not contain expected message");
    }
}