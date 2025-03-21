package org;

import org.pages.HomePage;
import org.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.utils.ExtentReportManager;

import java.io.IOException;
import java.lang.reflect.Method;

public class LoginPageTest extends BaseTest {

    private LoginPage loginPage;
    private HomePage homePage;
    private static final String LOGIN_DATA_FILE = "src/test/resources/loginData.csv";

    @BeforeMethod
    public void setUp(Method method) {
        super.setUp(method);
        homePage = new HomePage(getDriver());
        loginPage = new LoginPage(getDriver());
    }

    @DataProvider
    public Object[][] loginData() throws IOException {
//        return new Object[][] {{properties.getProperty("email"),properties.getProperty("password"),properties.getProperty("username")}};
        return readDataFromFile(LOGIN_DATA_FILE);
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String inputType, String email, String password, String username) {
        loginPage.login(email, password);
        switch (inputType) {
            case "validInput":
                Assert.assertTrue(homePage.isLogoutLinkDisplayed(), "Logout link should be displayed after successful login");
                Assert.assertEquals(homePage.getLoggedInAsText(), "Logged in as " + username, "Logged in user name displayed correctly");
                break;
            case "invalidUserName":
            case "invalidPassWord":
            case "invalidUserNameAndPassword":
                String errorMessage = loginPage.getErrorMessageText();
                Assert.assertEquals(errorMessage, "Your email or password is incorrect!", "Error message should match for invalid login");
                break;
        }

    }
}
