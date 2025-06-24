package com.saucedemo.tests;

import org.testng.annotations.Test;

import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import com.saucedemo.base.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckoutTest extends BaseTest {

    @Test
    public void testCheckout() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        assertEquals(productsPage.getPageTitle(), "Products", "Not in products page after login");

        // Ensure item cart is empty
        assertEquals(productsPage.getCartItemCount(), 0, "Cart should be empty at the start");

        // Add items to cart
        int itemCount = 3;
        productsPage.addSomeItemsToCart(itemCount);
        assertEquals(itemCount, productsPage.getCartItemCount(), "Item count in cart does not match expected");

        productsPage.goToCart();
        assertEquals(productsPage.getPageTitle(), "Your Cart", "Not in cart page after going to cart");

        productsPage.goToCheckout();

        CheckoutPage coPage = new CheckoutPage(driver);
        assertEquals(coPage.getPageTitle(), "Checkout: Your Information", "Not in checkout page");

        coPage.fillBuyerData();
        coPage.goToContinue();
        assertEquals(coPage.getPageTitle(), "Checkout: Overview", "Not in checkout overview page");

        coPage.goToFinish();
        assertEquals(coPage.getPageTitle(), "Checkout: Complete!", "Not in checkout complete page");
        assertTrue(coPage.getCompleteHeaderText().toLowerCase().contains("thank you"),
                "Complete header text does not contain expected message");

        Thread.sleep(2000);
    }
}
