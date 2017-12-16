package com.test.reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.test.utilis.Utils;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Reporter {

    public static ExtentReports extent;
    public static ExtentTest logger;
    private static String reportLocation = "./target/" + Utils.getDateTimeStamp() + ".html";


    public static void startReporter() {
        extent = new ExtentReports(reportLocation, true);
    }

    public static void endReport() {
        extent.flush();
        extent.close();
        System.out.println("Report has been stored at " + reportLocation);
    }

    public static void startTestCase(String testName) {
        logger = extent.startTest(testName);
    }

    public static void logEvent(LogStatus logStatus, String stepName, String details) {
        logger.log(logStatus, stepName, details);
    }

    public static void logEvent(LogStatus logStatus, String stepName) throws IOException, AWTException {
        String path = Utils.getScreenshotPath();
        logger.log(logStatus, stepName, logger.addScreenCapture(Utils.reportLogScreenshot(new File(path)).getAbsolutePath()));
    }

    public static void endTestCase() {
        extent.endTest(logger);
    }
}
