package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApiTestingPage extends BasePage {

    @FindBy(css = "div.api_testing_list")
    private WebElement apiTestingList;

    public ApiTestingPage(WebDriver driver) {
        super(driver);
    }

    public boolean isApiTestingListDisplayed() {
        return apiTestingList.isDisplayed();
    }
}