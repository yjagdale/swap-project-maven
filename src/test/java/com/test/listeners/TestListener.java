package com.test.listeners;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;

import com.test.reporter.Reporter;
import com.test.utilis.Utils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    public void onFinish(ITestContext arg0) {
        Reporter.endReport();

    }

    public void onStart(ITestContext arg0) {
        Reporter.startReporter();
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    public void onTestFailure(ITestResult arg0) {
        try {
            String path = Utils.getScreenshotPath();
            Utils.reportLogScreenshot(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AWTException e) {
            e.printStackTrace();
        }

    }

    public void onTestSkipped(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    public void onTestStart(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    public void onTestSuccess(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

}
