# 🧪 QA Automation with Selenium + Cucumber for SauceDemo

This is a Java-based QA automation project using **Cucumber**, **Selenium WebDriver**, and **JUnit**, developed to automate UI testing for [https://www.saucedemo.com](https://www.saucedemo.com).

---

## 📁 Project Structure

```
QA-AUTOMATION-WITH-SELENIUM/
├── src/
│   └── test/
│       └── java/
│           └── com/saucedemo/
│               ├── abstractcomponent/       # Utility base like AbstractComponent
│               ├── helper/                  # Config & shared static values
│               ├── hook/                    # Hooks for WebDriver & .env
│               ├── pages/                   # Page Object classes (LoginPage, etc.)
│               └── stepdefinitions/         # Cucumber step implementations
├── resources/
│   └── features/                            # Cucumber .feature files
│       ├── login.feature
│       ├── checkout.feature
│       └── test_suite.xml
├── .env                                     # Custom environment config
├── pom.xml                                  # Maven project file
└── README.md
```

---

## ⚙️ Prerequisites

- Java 17 or later
- Maven 3.8+
- Chrome Browser
- ChromeDriver (matching browser version)

---

## 🛠️ .env Configuration

Create a `.env` file in your root directory with the following:

```properties
BASE_URL=https://www.saucedemo.com
BROWSER=chrome
DRIVER_PATH=D:\\Documents\\Desktop\\chromedriver-win64\\chromedriver.exe
```

> `.env` is automatically loaded via `io.github.cdimascio:dotenv-java` in `Hooks.java`.

---

## 🚀 How to Run Tests

### 1. Install Dependencies (without running tests)

```bash
mvn clean install -DskipTests
```

### 2. Run Tests via test_suite.xml

```bash
mvn test
```

The runner defined in `test_suite.xml` executes `com.saucedemo.TestRunner` which runs all Cucumber scenarios.

---

## ✅ Features Implemented

- 🔐 Login: success, failure, and edge cases
- 🛒 Add 3 products to cart
- 🧾 Checkout flow
- 📄 Page Object Model
- 🥒 Cucumber BDD with reusable steps
- 🧪 JUnit integration with Cucumber
- 🔄 Shared config via `.env` and utility components

---

## 🧪 Sample Gherkin (login.feature)

```gherkin
Feature: Login functionality

  Background: User landed on login page
    Given the user is on the login page

  Scenario Outline: User attempts to login
    Given the user enters "<username>" and "<password>"
    Then the login should "<result>"

    Examples:
      | username        | password     | result  |
      | standard_user   | secret_sauce | succeed |
      | locked_out_user | secret_sauce | fail    |
```

---

## 📌 Notes

- Driver is managed in `Hooks.java` with proper setup/teardown using `@Before` and `@After`.
- Element utilities are available in `AbstractComponent.java`.
- Common step definitions (reused across features) are in `CommonStepDefinitions.java`.

---

Made with ❤️ for QA Bootcamp and practical web automation.