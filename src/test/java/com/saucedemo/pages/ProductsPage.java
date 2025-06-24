package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.abstractcomponent.AbstractComponent;

import java.util.List;

public class ProductsPage extends AbstractComponent {
    private WebDriver driver;

    @FindBy(className = "title")
    private WebElement titleEl;

    @FindBy(css = "button.btn_inventory")
    private WebElement addToCartButtonsEl;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartBtnEl;

    @FindBy(id = "checkout")
    private WebElement checkoutBtnEl;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadgeEl;

    private By productItems = By.cssSelector(".inventory_item");
    private By addToCartButtons = By.cssSelector("button.btn_inventory");
    private By cartBadge = By.className("shopping_cart_badge");

    public ProductsPage(WebDriver driver) {
        super(driver); // Call to the constructor of parent (AbstractComponent)
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return titleEl.getText();
    }

    public void addSomeItemsToCart(int itemCount) {
        List<WebElement> products = driver.findElements(productItems);
        List<WebElement> productAddToCartBtns = products.stream().map(p -> p.findElement(addToCartButtons)).toList();

        // only add if at least itemCount items exist
        int itemCountExist = Math.min(itemCount, productAddToCartBtns.size());
        for (int i = 0; i < itemCountExist; i++) {
            productAddToCartBtns.get(i).click();
        }
    }

    public int getCartItemCount() {
        if (isElementPresent(cartBadge)) {
            String badgeText = driver.findElement(cartBadge).getText();
            return Integer.parseInt(badgeText);
        }

        return 0; // No items in cart
    }

    public void goToCart() {
        cartBtnEl.click();
    }

    public void goToCheckout() {
        checkoutBtnEl.click();
    }
}
