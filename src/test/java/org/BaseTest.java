package org;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.utils.ExtentReportManager;

import java.io.*;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public abstract class BaseTest {

    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    protected Properties properties;
    public static final String BASE_URL = "https://www.automationexercise.com/";

    @BeforeSuite
    public void beforeSuite() {
        ExtentReportManager.setUp();

        properties = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream("src/test/resources/config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeMethod
    public void setUp(Method method) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver.set(new ChromeDriver(options));
        driver.get().manage().window().maximize();
        driver.get().get(BASE_URL);

        String testName = method.getDeclaringClass().getSimpleName() + "." + method.getName();
        test.set(ExtentReportManager.createTest(testName));
    }

    protected WebElement waitForElement(WebElement element) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement retryFindElement(WebElement element) {
        for (int i = 0; i < 3; i++) {
            try {
                return waitForElement(element);
            } catch (StaleElementReferenceException e) {
                // Retry finding the element
            }
        }
        throw new RuntimeException("Element not found after retries: " + element);
    }

    protected Object[][] readDataFromFile(String filePath) throws IOException {
        List<Object[]> data = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(",");
            data.add(fields);
        }
        reader.close();
        return data.toArray(new Object[0][]);
    }

    @AfterMethod
    public void tearDownClass() {
        if (driver.get() != null) {
            try {
                driver.get().quit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @AfterSuite
    public void tearDownSuite() {
        ExtentReportManager.tearDown();
    }

    protected WebDriver getDriver() {
        return driver.get();
    }

    protected ExtentTest getTest() {
        return test.get();
    }
}