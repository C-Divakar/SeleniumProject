package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestCasesPage extends BasePage {

    @FindBy(css = "div.test_cases_list")
    private WebElement testCasesList;

    public TestCasesPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTestCasesListDisplayed() {
        return testCasesList.isDisplayed();
    }
}