package org.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
    public static ExtentReports extent;
    private static ExtentTest test;
    private static ExtentSparkReporter sparkReporter;

    public static void setUp() {
        sparkReporter = new ExtentSparkReporter("extent-report.html");
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Login Test Report");
        sparkReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    public static ExtentReports getExtent() {
        return extent;
    }

    public static ExtentTest createTest(String testName) {
        test = extent.createTest(testName);
        return test;
    }

    public static void tearDown() {
        if (extent != null) {
            extent.flush();
        }
    }
}