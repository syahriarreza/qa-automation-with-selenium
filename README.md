# QA Automation with Selenium for SauceDemo

This is a Java-based TestNG + Selenium automation project to test [https://www.saucedemo.com](https://www.saucedemo.com).

## 📁 Project Structure

```
src/
├── test/
│   ├── java/
│   │   └── com/saucedemo/
│   │       ├── base/            # BaseTest for WebDriver setup/teardown
│   │       ├── pages/           # Page Object Model (LoginPage, ProductsPage, CheckoutPage)
│   │       └── tests/           # Test classes (LoginTest, CheckoutTest)
│   └── resources/
│       └── test_suite.xml       # TestNG XML suite config
```

## 🚀 How to Run

1. Make sure you have:
   - Java 17+
   - Maven
   - Chrome browser
   - Chromedriver available in PATH

2. Install dependencies (skip running tests):
```bash
mvn clean install -DskipTests
```

3. Run test suite:
```bash
mvn test -DsuiteXmlFile=src/test/resources/test_suite.xml
```

## ✅ Features

- ✅ Test Login with multiple data using `@DataProvider`
- ✅ Page Object Model (POM)
- ✅ Add products to cart
- ✅ Navigate and interact with cart
- ✅ Structured with best practices

## 💡 Notes

- Chrome is run with options to suppress password manager popups.
- Add more assertions or expand page coverage as needed.

---

Made with 💻 and ☕️ for learning QA Automation.