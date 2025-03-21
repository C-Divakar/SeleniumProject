package org.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.BaseTest;
import org.pages.HomePage;
import org.pages.LoginPage;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

public class LoginSteps extends BaseTest {

    private LoginPage loginPage;
    private HomePage homePage;

    @Before
    public void setUp(Method method) {
        super.setUp(method);
        homePage = new HomePage(getDriver());
        loginPage = new LoginPage(getDriver());

        properties = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream("src/test/resources/config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public void tearDown() {
        super.tearDownSuite();
    }

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        driver.get();
        homePage.goToLoginPage();
        getTest().info("Navigated to login page");
    }

    @When("the user enters a valid email and password")
    public void theUserEntersAValidEmailAndPassword() {
        loginPage.enterEmail(properties.getProperty("email"));
        loginPage.enterPassword(properties.getProperty("password"));
        getTest().info("Entered valid email and password");
    }

    @And("the user clicks the login button")
    public void theUserClicksTheLoginButton() {
        loginPage.clickLoginButton();
        getTest().info("Clicked login button");
    }

    @Then("the user should be logged in successfully")
    public void theUserShouldBeLoggedInSuccessfully() {
        Assert.assertTrue(homePage.isLogoutLinkDisplayed(), "Logout link should be displayed after successful login");
        getTest().pass("User logged in successfully");
    }

    @And("the logout link should be displayed")
    public void theLogoutLinkShouldBeDisplayed() {
        Assert.assertTrue(homePage.isLogoutLinkDisplayed(), "Logout link should be displayed after successful login");
        getTest().pass("Logout link displayed");
    }

    @And("the {string} text should display the correct username")
    public void theTextShouldDisplayTheCorrectUsername(String loggedInAsText) {
        Assert.assertEquals(homePage.getLoggedInAsText(), "Logged in as " + properties.getProperty("username"), "Logged in user name displayed correctly");
        getTest().pass("Correct username displayed");
    }
}
