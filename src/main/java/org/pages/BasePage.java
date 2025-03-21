package org.pages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected ExtentTest test;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    protected String getPageTitle() {
        return driver.getTitle();
    }

    protected void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void click(WebElement element) {
        waitForVisibility(element);
        element.click();
    }

    protected void enterText(WebElement element, String text) {
        waitForVisibility(element);
        element.clear();
        element.sendKeys(text);
        test.info("Entered text: " + text + " into element: " + element);

    }

    protected boolean isElementDisplayed(WebElement element) {
        try {
            waitForVisibility(element);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected String getElementText(WebElement element) {
        try {
            waitForVisibility(element);
            return element.getText();
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            waitForVisibility(element);
            return element.getText();
        }
    }


    // Alert handling methods
    protected void acceptAlert() {
        driver.switchTo().alert().accept();
        test.info("Accepted alert");
    }

    protected void dismissAlert() {
        driver.switchTo().alert().dismiss();
        test.info("Dismissed alert");
    }

    protected String getAlertText() {
        String alertText = driver.switchTo().alert().getText();
        test.info("Alert text: " + alertText);
        return alertText;
    }

    protected void sendTextToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
        test.info("Sent text to alert: " + text);
    }

    // Popup handling methods
    protected void switchToFrame(WebElement iframe) {
        waitForVisibility(iframe);
        driver.switchTo().frame(iframe);
        test.info("Switched to frame: " + iframe);
    }

    protected void switchToDefaultContent() {
        driver.switchTo().defaultContent();
        test.info("Switched to default content");
    }

    // Window handling methods
    protected void switchToWindow(String windowHandle) {
        driver.switchTo().window(windowHandle);
        test.info("Switched to window: " + windowHandle);
    }

    protected String getWindowHandle() {
        return driver.getWindowHandle();
    }

    protected Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    protected void switchToWindow(int index) {
        driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(index));
        test.info("Switched to window index: " + index);
    }

    protected void switchToMainWindow() {
        String mainWindowHandle = driver.getWindowHandles().iterator().next();
        driver.switchTo().window(mainWindowHandle);
        test.info("Switched to main window");
    }

    protected void closeCurrentWindow() {
        driver.close();
        test.info("Closed current window");
    }
}