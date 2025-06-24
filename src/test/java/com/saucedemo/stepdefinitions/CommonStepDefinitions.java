package com.saucedemo.stepdefinitions;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.saucedemo.helper.Config;
import com.saucedemo.hook.Hooks;
import com.saucedemo.pages.LoginPage;

import io.cucumber.java.en.Given;

public class CommonStepDefinitions {
    WebDriver driver;
    LoginPage loginPage;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver = Hooks.getDriver();
        assertTrue(driver.getCurrentUrl().contains(Config.getBaseUrl()), "User is not on the login page.");
    }

    @Given("the user is logged in with {string} and {string}")
    public void the_user_is_logged_in_with_and(String username, String password) {
        driver = Hooks.getDriver();
        loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        assertTrue(driver.getCurrentUrl().contains("inventory.html"));
    }
}
