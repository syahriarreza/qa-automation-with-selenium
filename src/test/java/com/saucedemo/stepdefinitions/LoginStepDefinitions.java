package com.saucedemo.stepdefinitions;

import io.cucumber.java.en.*;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.saucedemo.hook.Hooks;
import com.saucedemo.pages.LoginPage;

public class LoginStepDefinitions {
    WebDriver driver;
    LoginPage loginPage;

    public LoginStepDefinitions() {
        driver = Hooks.getDriver();
        loginPage = new LoginPage(driver);
    }

    @Given("the user enters {string} and {string}")
    public void the_user_enters(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("the login should {string}")
    public void the_login_should(String result) {
        switch (result) {
            case "succeed":
                assertTrue(driver.getCurrentUrl().contains("inventory.html"), "Expected to login successfully.");
                break;
            case "fail":
                assertTrue(loginPage.getErrorMessage().length() > 0, "Expected an error message.");
                break;
            default:
                throw new IllegalArgumentException("Unexpected value: " + result);
        }
    }
}