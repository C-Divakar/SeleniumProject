package org;

import org.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.testng.Assert.assertTrue;

public class HomePageTest extends BaseTest {

    private HomePage homePage;
    private static final String EXPECTED_PRODUCTS_PAGE_TITLE = "Automation Exercise - All Products";

    @BeforeMethod
    public void setUp(Method method) {
        super.setUp(method);
        homePage = new HomePage(getDriver());
    }

    @Test
    public void testHeaderMiddleIsDisplayed() {
        assertTrue(retryFindElement(homePage.getHeaderMiddle()).isDisplayed(), "Header middle is not displayed");
    }

    @Test
    public void testLogoIsDisplayed() {
        assertTrue(retryFindElement(homePage.getLogo()).isDisplayed(), "Logo is not displayed");
    }

    @Test
    public void testShopMenuIsDisplayed() {
        assertTrue(retryFindElement(homePage.getShopMenu()).isDisplayed(), "Shop menu is not displayed");
    }

    @Test
    public void testFeaturesItemsIsDisplayed() {
        assertTrue(retryFindElement(homePage.getFeaturesItems()).isDisplayed(), "Features items are not displayed");
    }

    @Test
    public void testGoToProductsPage() {
        homePage.goToProductsPage();
        Assert.assertEquals(getDriver().getTitle(), EXPECTED_PRODUCTS_PAGE_TITLE, "Products page title does not match");
    }
}