package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage extends BasePage {

    @FindBy(name = "title")
    private WebElement titleRadio;

    @FindBy(id = "name")
    private WebElement nameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "days")
    private WebElement daysDropdown;

    @FindBy(id = "months")
    private WebElement monthsDropdown;

    @FindBy(id = "years")
    private WebElement yearsDropdown;

    @FindBy(id = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    private WebElement optinCheckbox;

    @FindBy(id = "first_name")
    private WebElement firstNameInput;

    @FindBy(id = "last_name")
    private WebElement lastNameInput;

    @FindBy(id = "company")
    private WebElement companyInput;

    @FindBy(id = "address1")
    private WebElement address1Input;

    @FindBy(id = "address2")
    private WebElement address2Input;

    @FindBy(id = "country")
    private WebElement countryDropdown;

    @FindBy(id = "state")
    private WebElement stateInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "zipcode")
    private WebElement zipcodeInput;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumberInput;

    @FindBy(css = "button[type='submit']")
    private WebElement createAccountButton;

    public SignupPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterAccountInformation(String title, String name, String email, String password, String day, String month, String year) {
        if (title.equalsIgnoreCase("Mr")) {
            titleRadio.findElement(By.id("id_gender1")).click();
        } else {
            titleRadio.findElement(By.id("id_gender2")).click();
        }
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        daysDropdown.sendKeys(day);
        monthsDropdown.sendKeys(month);
        yearsDropdown.sendKeys(year);
    }

    public void enterAddressInformation(String firstName, String lastName, String company, String address1, String address2, String country, String state, String city, String zipcode, String mobileNumber) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        companyInput.sendKeys(company);
        address1Input.sendKeys(address1);
        address2Input.sendKeys(address2);
        countryDropdown.sendKeys(country);
        stateInput.sendKeys(state);
        cityInput.sendKeys(city);
        zipcodeInput.sendKeys(zipcode);
        mobileNumberInput.sendKeys(mobileNumber);
    }

    public void subscribeToNewsletter() {
        if (!newsletterCheckbox.isSelected()) {
            newsletterCheckbox.click();
        }
    }

    public void receiveSpecialOffers() {
        if (!optinCheckbox.isSelected()) {
            optinCheckbox.click();
        }
    }

    public void submitForm() {
        createAccountButton.click();
    }
}