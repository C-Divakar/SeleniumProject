package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {

    @FindBy(css = "div.cart_info")
    private WebElement cartInfoSection;

    @FindBy(css = "button#checkout")
    private WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isCartInfoSectionDisplayed() {
        return cartInfoSection.isDisplayed();
    }

    public void proceedToCheckout() {
        click(checkoutButton);
    }
}