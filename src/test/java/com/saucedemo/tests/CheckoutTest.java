package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import com.saucedemo.base.BaseTest;

public class CheckoutTest extends BaseTest {

    @Test
    public void testAddToCartAndGoToCheckout() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.getProductTitle(), "Products");

        productsPage.addBackpackToCart();
        productsPage.clickCartButton();

        // Tambahkan assert lain atau navigasi ke checkout jika kamu punya halaman
        // lanjutannya
    }
}
