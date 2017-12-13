package com.test.utilis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
    public static WebDriver browser;

    public static void setBrowser(WebDriver driver) {
        browser = driver;
    }

    public static void waitForElementToVisible(WebElement element) {
        new WebDriverWait(browser, 60).until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementToVisible(WebElement element, int timeToWait) {
        new WebDriverWait(browser, timeToWait).until(ExpectedConditions.visibilityOf(element));
    }
}
