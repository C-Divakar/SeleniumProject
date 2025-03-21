package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(css = "button[data-qa='login-button']")
    private WebElement loginButton;

    @FindBy(css = "p[style='color: red;']")
    private WebElement errorMessage;

    private HomePage homePage;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.homePage = new HomePage(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void login(String email, String password) {
        homePage.goToLoginPage();
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    public String getErrorMessageText() {
        waitForVisibility(errorMessage);
        return errorMessage.getText();
    }
}