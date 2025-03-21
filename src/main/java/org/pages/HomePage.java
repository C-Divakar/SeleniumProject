package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(css = "ul.nav.navbar-nav > li > a[href='/products']")
    private WebElement productsLink;

    @FindBy(css = "ul.nav.navbar-nav > li > a[href='/view_cart']")
    private WebElement cartLink;

    @FindBy(css = "ul.nav.navbar-nav > li > a[href='/login']")
    private WebElement loginLink;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//li//a[contains(text(), 'Logged in as')]")
    private WebElement loggedInAsText;

    @FindBy(css = "ul.nav.navbar-nav > li > a[href='/logout']")
    private WebElement logoutLink;

    @FindBy(css = "ul.nav.navbar-nav > li > a[href='/test_cases']")
    private WebElement testCasesLink;

    @FindBy(css = "ul.nav.navbar-nav > li > a[href='/api_list']")
    private WebElement apiTestingLink;

    @FindBy(css = "ul.nav.navbar-nav > li > a[href='https://www.youtube.com/c/AutomationExercise']")
    private WebElement videoTutorialsLink;

    @FindBy(css = "ul.nav.navbar-nav > li > a[href='/contact_us']")
    private WebElement contactUsLink;

    @FindBy(css = "div.header-middle")
    private WebElement headerMiddle;

    @FindBy(css = "div.logo")
    private WebElement logo;

    @FindBy(css = "div.shop-menu")
    private WebElement shopMenu;

    @FindBy(css = "div.features_items")
    private WebElement featuresItems;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isHeaderMiddleDisplayed() {
        return isElementDisplayed(headerMiddle);
    }

    public boolean isLogoDisplayed() {
        return isElementDisplayed(logo);
    }

    public boolean isShopMenuDisplayed() {
        return isElementDisplayed(shopMenu);
    }

    public boolean isFeaturesItemsDisplayed() {
        return isElementDisplayed(featuresItems);
    }

    public boolean isLogoutLinkDisplayed() {
        return isElementDisplayed(logoutLink);
    }

    public String getLoggedInAsText() {
        return getElementText(loggedInAsText);
    }

    public void goToProductsPage() {
        click(productsLink);
    }

    public void goToCartPage() {
        click(cartLink);
    }

    public void goToLoginPage() {
        click(loginLink);
    }

    public void goToTestCasesPage() {
        click(testCasesLink);
    }

    public void goToApiTestingPage() {
        click(apiTestingLink);
    }

    public void goToVideoTutorialsPage() {
        click(videoTutorialsLink);
    }

    public void goToContactUsPage() {
        click(contactUsLink);
    }

    public WebElement getHeaderMiddle() {
        return headerMiddle;
    }

    public WebElement getLogo() {
        return logo;
    }

    public WebElement getShopMenu() {
        return shopMenu;
    }

    public WebElement getFeaturesItems() {
        return featuresItems;
    }


}