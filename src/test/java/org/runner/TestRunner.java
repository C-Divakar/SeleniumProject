package org.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeSuite;
import org.utils.ExtentReportManager;

@CucumberOptions(features = "src/test/resources/features", glue = "org.steps", plugin = {"pretty", "html:target/cucumber-reports.html"}, monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void setUp() {
        ExtentReportManager.setUp();

    }
}