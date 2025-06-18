package com.saucedemo.tests;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
            {"standard_user", "secret_sauce", true},
            {"locked_out_user", "secret_sauce", false},
            {"", "secret_sauce", false},
            {"standard_user", "", false}
        };
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password, boolean shouldPass) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        if (shouldPass) {
            assertTrue(driver.getCurrentUrl().contains("inventory.html"), "Expected to login successfully.");
        } else {
            assertTrue(loginPage.getErrorMessage().length() > 0, "Expected an error message.");
        }

        Thread.sleep(2000);
    }
}