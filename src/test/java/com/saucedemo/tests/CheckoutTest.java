package com.saucedemo.tests;

import org.testng.annotations.Test;

import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import com.saucedemo.base.BaseTest;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test
    public void testCheckout() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addFirstThreeItemsToCart();
        productsPage.goToCart();
        productsPage.goToCheckout();

        CheckoutPage coPage = new CheckoutPage(driver);
        coPage.fillBuyerData();
        coPage.goToContinue();
        coPage.goToFinish();
        coPage.assertComplete();

        Thread.sleep(2000);
    }
}
