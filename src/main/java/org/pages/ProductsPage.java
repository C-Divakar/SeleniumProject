package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {

    @FindBy(css = "div.features_items")
    private WebElement productsSection;

    @FindBy(css = "input#search_product")
    private WebElement searchBox;

    @FindBy(css = "button#submit_search")
    private WebElement searchButton;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductsSectionDisplayed() {
        return productsSection.isDisplayed();
    }

    public void searchForProduct(String productName) {
        enterText(searchBox, productName);
        click(searchButton);
    }
}